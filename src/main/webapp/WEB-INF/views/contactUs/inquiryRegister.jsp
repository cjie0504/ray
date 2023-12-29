<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>


<!-- Header Section Begin -->
<jsp:include page="../layout/header.jsp"></jsp:include>
<!-- Header End -->
<!-- Breadcrumb Begin -->
<div class="breadcrumb-option spad set-bg" data-setbg="/resources/img/headerImg.jpg">
    <div class="container" id="subTitle">
        <div class="row">
            <div class="col-lg-12 text-center">
                <div class="breadcrumb__text">
                    <h2>Contact Us</h2>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Breadcrumb End -->
<div class="set-bg" data-setbg="/resources/img/company/subHeaderImg.jpg" style="height: 18%;">
    <div class="container">
        <div class="row">
            <div class="menuSubTitle col-lg-12">
                <div>
                    <h2 style="color: white;">Inquiry Board</h2>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Breadcrumb Begin -->

    <!-- Breadcrumb End -->

    <!-- Contact Widget Section Begin -->

<section class="spad" style="width: 80%;margin: auto;">

    <div class="panel" style="margin-left:1px;">
        <div id="contAreaBox">
            <div class="panel">
                <div class="panel-body">
                    <form id="form" action="/contactUs/inquiry" method="post">
                        <div class="table-responsive" style="text-align:center;">
                            <table id="datatable-scroller"
                                   class="table table-bordered tbl_Form">
                                <caption></caption>
                                <colgroup>
                                    <col width="250px" />
                                    <col />
                                </colgroup>
                                <tbody>
                                <tr>
                                    <th class="active" >작성자 이름</th>
                                    <td class="form-inline"><input type="text" id="board_writer"
                                                                   name="name" class="form-control" style="width: 200px" placeholder="이름" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active" >소속</th>
                                    <td class="form-inline"><input type="text" id="company"
                                                                   name="company" class="form-control" style="width: 200px" placeholder="소속명" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active" >이메일</th>
                                    <td class="form-inline"><input type="email" id="email"
                                                                   name="email" class="form-control" style="width: 200px" placeholder="이메일" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active" >핸드폰번호</th>
                                    <td class="form-inline"><input type="tel" id="phone"
                                                                   name="phone" class="form-control" style="width: 200px" placeholder="핸드폰 번호" value="" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active">공개여부</th>
                                    <td class="form-inline">
<%--                                        <div class="custom-control custom-radio custom-control-inline">--%>
<%--                                            <input type="radio" id="publicRadio" name="showYn" value="true" class="custom-control-input" checked>--%>
<%--                                            <label class="custom-control-label" for="publicRadio">공개</label>--%>
<%--                                        </div>--%>
                                        <div class="custom-control custom-radio custom-control-inline">
                                            <input type="radio" id="privateRadio" name="showYn" value="false" class="custom-control-input" checked>
                                            <label class="custom-control-label" for="privateRadio">비공개</label>
                                        </div>
                                        <span class="text-gray-500 text-xs ml-4">* 비공개 글로 게시가 됩니다.</span>
                                    </td>
                                </tr>
                                <tr id="passwordRow">
                                    <th class="active">비밀번호</th>
                                    <td class="form-inline">
                                        <input type="password" id="pw" name="pw" class="form-control" style="width: 200px" placeholder="비밀번호를 입력하세요" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active">제목</th>
                                    <td class="form-inline"><input type="text" id="title"
                                                                   name="title" class="form-control" style="width: 840px" />
                                    </td>
                                </tr>
                                <tr>
                                    <th class="active" >내용</th>
                                    <td class="form-inline">
                                    <textarea
                                            id="smartEditor" name="smartEditor" cols="100" rows="20"
                                            class="form-control"></textarea>

                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div style="margin-right:50px;margin-top: 100px; float: right">
                            <button type="button" class="btn btn-primary" onclick="submitContents(this);" >등록</button>
                            <a href="/inquiry" class="btn btn-danger">취소</a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</section>
<!--    footer start-->
<jsp:include page="../layout/footer.jsp"></jsp:include>
<!-- Js Plugins -->
<script type="text/javascript" src="/resources/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/mixitup.min.js"></script>
<script src="/resources/js/masonry.pkgd.min.js"></script>
<script src="/resources/js/jquery.slicknav.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/main.js"></script>
<script type="text/javascript">
    var oEditors = [];

    // 추가 글꼴 목록
    //var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];

    nhn.husky.EZCreator.createInIFrame({
        oAppRef: oEditors,
        elPlaceHolder: "smartEditor",
        sSkinURI: "/resources/smartEditor/SmartEditor2Skin.html",
        htParams : {
            bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
            bUseModeChanger : false,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
            //bSkipXssFilter : true,		// client-side xss filter 무시 여부 (true:사용하지 않음 / 그외:사용)
            //aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
            fOnBeforeUnload : function(){
                //alert("완료!");
            }
        }, //boolean
        fOnAppLoad : function(){
            //예제 코드
            //oEditors.getById["smartEditor"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
        },
        fCreator: "createSEditor2"
    });

    function pasteHTML() {
        var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
        oEditors.getById["smartEditor"].exec("PASTE_HTML", [sHTML]);
    }

    function showHTML() {
        var sHTML = oEditors.getById["smartEditor"].getIR();
        alert(sHTML);
    }

    function submitContents(elClickedObj) {
        // SmartEditor2의 내용을 textarea에 적용
        oEditors.getById["smartEditor"].exec("UPDATE_CONTENTS_FIELD", []);

        // textarea에 적용된 내용을 확인
        var editorContent = document.getElementById("smartEditor").value;

        //유효성 검사
        if(validateForm()){
            try {
                // 폼을 직접 찾아서 제출
                var form = document.getElementById("form");
                // 버튼 비활성화
                elClickedObj.disabled = true;

                form.submit();
            } catch(e) {
                console.error("Error submitting form:", e);
            }
        }
    }

    function validateForm() {
        var name = document.getElementById('board_writer').value;
        var company = document.getElementById('company').value;
        var email = document.getElementById('email').value;
        var phone = document.getElementById('phone').value;
        var password = document.getElementById('pw').value;
        var title = document.getElementById('title').value;
        var content = document.getElementById('smartEditor').value;

        // 이메일 정규식
        var emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$/;

        // 전화번호 정규식 (숫자만 허용하도록)
        var telRegex = /^[0-9]+$/;

        // 비밀번호는 여러 규칙을 따로 설정하실 수 있습니다.
        // 여기서는 최소 6자리 이상이어야 한다고 가정합니다.

        // 이름과 제목은 비어있지 않아야 합니다.
        if (name.trim() === '') {
            alert('이름을 입력하세요.');
            name.focus();
            return false;
        }

        if (company.trim() === '') {
            alert('소속을 입력하세요.');
            company.focus();
            return false;
        }

        if (title.trim() === '') {
            alert('제목을 입력하세요.');
            title.focus();
            return false;
        }


        if (content.trim() === '') {
            alert('내용을 입력하세요.');
            content.focus();
            return false;
        }

        // 이메일 유효성 검사
        if (!emailRegex.test(email)) {
            alert('유효한 이메일 주소를 입력하세요.');
            email.focus();
            return false;
        }

        // 전화번호 유효성 검사
        if (!telRegex.test(phone)) {
            alert('유효한 전화번호를 입력하세요.');
            phone.focus();
            return false;
        }

        // 비밀번호는 여러 규칙을 따로 설정하실 수 있습니다.
        // 여기서는 최소 6자리 이상이어야 한다고 가정합니다.
        if (password.length < 4) {
            alert('비밀번호는 최소 4자리 이상이어야 합니다.');
            password.focus();
            return false;
        }
        if (password.length > 20) {
            alert('비밀번호는 최대 20자리 입니다.');
            password.focus();
            return false;
        }

        // 나머지 유효성 검사 추가 가능

        return true;
    }


    function setDefaultFont() {
        var sDefaultFont = '궁서';
        var nFontSize = 24;
        oEditors.getById["smartEditor"].setDefaultFont(sDefaultFont, nFontSize);
    }


    $('input[name="showYn"]').change(function() {
        if ($(this).val() === 'false') {
            $('#passwordRow').show(); // 비공개 선택 시 비밀번호 입력란 표시
        } else {
            $('#passwordRow').hide(); // 공개 선택 시 비밀번호 입력란 숨김
        }
    });

</script>
