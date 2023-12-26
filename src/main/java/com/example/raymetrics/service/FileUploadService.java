package com.example.raymetrics.service;

import com.example.raymetrics.entity.Inquiry;
import com.example.raymetrics.repository.InquiryRepository;
import com.google.cloud.storage.Blob;
import com.google.cloud.storage.Bucket;
import com.google.firebase.cloud.StorageClient;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import static com.google.common.io.Files.getFileExtension;

@Service
@RequiredArgsConstructor
public class FileUploadService {
    @Autowired
    private ResourceLoader resourceLoader;
    private final InquiryRepository inquiryRepository;

    public boolean uploadImg(HttpServletRequest request, HttpServletResponse response) {
        try {

            //파일정보
            String sFileInfo = "";
            //파일명을 받는다 - 일반 원본파일명
            String sFilename = request.getHeader("file-name");
            //파일 확장자
            String sFilenameExt = sFilename.substring(sFilename.lastIndexOf(".") + 1);
            //확장자를소문자로 변경
            sFilenameExt = sFilenameExt.toLowerCase();

            //이미지 검증 배열변수
            String[] allowFileArr = {"jpg", "png", "bmp", "gif"};

            //확장자 체크
            int nCnt = 0;
            for (int i = 0; i < allowFileArr.length; i++) {
                if (sFilenameExt.equals(allowFileArr[i])) {
                    nCnt++;
                }
            }

            //이미지가 아니라면
            if (nCnt == 0) {
                PrintWriter print = response.getWriter();
                print.print("NOTALLOW_" + sFilename);
                print.flush();
                print.close();
            } else {
                //디렉토리 설정 및 업로드

                //파일경로
                String filePath = resourceLoader.getResource("resources/uploadImg/").getFile().getPath();
                File file = new File(filePath);

                if (!file.exists()) {
                    file.mkdirs();
                }

                String sRealFileNm = "";
                SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
                String today = formatter.format(new java.util.Date());
                sRealFileNm = today + UUID.randomUUID().toString() + sFilename.substring(sFilename.lastIndexOf("."));
                String rlFileNm = filePath + "/" + sRealFileNm;

                ///////////////// 서버에 파일쓰기 /////////////////
                InputStream inputStream = request.getInputStream();
                OutputStream outputStream = new FileOutputStream(rlFileNm);
                int numRead;
                byte bytes[] = new byte[Integer.parseInt(request.getHeader("file-size"))];
                while ((numRead = inputStream.read(bytes, 0, bytes.length)) != -1) {
                    outputStream.write(bytes, 0, numRead);
                }
                if (inputStream != null) {
                    inputStream.close();
                }
                outputStream.flush();
                outputStream.close();

                ///////////////// 이미지 /////////////////
                // 정보 출력
                sFileInfo += "&bNewLine=true";
                // img 태그의 title 속성을 원본파일명으로 적용시켜주기 위함
                sFileInfo += "&sFileName=" + sFilename;
                sFileInfo += "&sFileURL=" + "/resources/uploadImg/" + sRealFileNm;
                PrintWriter printWriter = response.getWriter();
                printWriter.print(sFileInfo);
                printWriter.flush();
                printWriter.close();
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    public void uploadImgToCloud(Inquiry inquiry) throws IOException {
        String contents = inquiry.getContents();

        Document doc = Jsoup.parse(contents);

        Elements imgElements = doc.select("img");
        for(Element imgElement:imgElements){
            String src = imgElement.attr("src");

            // 파일 경로 문자열을 Path 객체로 변환
            Path path = Paths.get(src);

            // 파일 이름을 가져옴
            String fileName = path.getFileName().toString();

            // 파일 MIME를 추출
            String contentType = Files.probeContentType(path);

            //파일경로
            String filePath = resourceLoader.getResource(src).getFile().getPath();
            Bucket bucket = StorageClient.getInstance().bucket("raymetrics-57ba9.appspot.com");
            InputStream fileContent = new FileInputStream(filePath);
            Blob blob = bucket.create(fileName, fileContent, contentType);

            // 새로운 URL 생성
            String newUrl = String.valueOf(blob.signUrl(36500, TimeUnit.DAYS));
            // imgElement의 src 속성을 새 URL로 업데이트
            imgElement.attr("src", newUrl);

            //해당파일 로컬에서 삭제
            fileDelete(filePath);
        }


        String newContents = doc.toString();
        inquiryRepository.save(inquiry.setContents(newContents));
    }


    public void fileDelete(String filePath){
        File file = new File(filePath);

        if (file.exists()) {
            if(file.isDirectory()){ //파일이 디렉토리인지 확인

                File[] files = file.listFiles();

                for( int i=0; i<files.length; i++){
                    if( files[i].delete() ){
                        System.out.println(files[i].getName()+" 삭제성공");
                    }else{
                        System.out.println(files[i].getName()+" 삭제실패");
                    }
                }

            }
            if(file.delete()){
                System.out.println("파일삭제 성공");
            }else{
                System.out.println("파일삭제 실패");
            }
        }
    }
}
