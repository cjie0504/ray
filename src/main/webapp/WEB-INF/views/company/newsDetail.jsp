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
                    <h2 style="color: white;">NEWS</h2>
                </div>
            </div>
        </div>
    </div>
</div>

    <!-- Breadcrumb Begin -->

    <!-- Breadcrumb End -->

    <!-- Contact Widget Section Begin -->

<section class="spad" style="width: 75%;margin: auto;">

    <div class="panel" style="margin-left:1px;min-height: 500px;">
        <div id="contAreaBox">
            <div class="panel">
                <div class="panel-body">
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
                                    <th class="active" >작성자</th>
                                    <td class="form-inline">${NEWS.regAdminName}</td>
                                </tr>
                                <tr>
                                    <th class="active">제목</th>
                                    <td class="form-inline">${NEWS.title}</td>
                                </tr>
                                <tr>
                                    <th class="active">작성일</th>
                                    <td class="form-inline">${NEWS.regDt}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    <div>
                            ${NEWS.contents}
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div style="margin-right:50px;margin-top: 100px; float: right">
        <a href="/news" class="btn btn-secondary">목록으로</a>
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
            bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
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
        console.log(editorContent);

        try {
            // 폼을 직접 찾아서 제출
            var form = document.getElementById("form");
            form.submit();
        } catch(e) {
            console.error("Error submitting form:", e);
        }
    }

    function setDefaultFont() {
        var sDefaultFont = '궁서';
        var nFontSize = 24;
        oEditors.getById["smartEditor"].setDefaultFont(sDefaultFont, nFontSize);
    }


</script>
