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

<section class="spad" style="width: 75%;margin: auto;min-height: 500px;">

    <div class="panel" style="margin-left:1px;">
        <div id="contAreaBox">
            <div class="panel">
                <div class="panel-body">
                    <form id="form" action="/inquiry/checkPw" method="post">
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
                                <tr id="passwordRow">
                                    <th class="active">비밀번호</th>
                                    <td class="form-inline">
                                        <input type="password" id="pw" name="pw" class="form-control" style="width: 200px" placeholder="비밀번호를 입력하세요" />
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <input type="hidden" id="inquiryNo" name="inquiryNo" value="${INQUIRY.inquiryNo}">
                        <div style="margin-right:50px; float: right">
                            <button type="button" class="btn btn-primary" onclick="submitContents(this);" >확인</button>
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
    var result = '<%= request.getAttribute("RESULT") %>';
    console.log(">>>>>>"+result);
    if (result === 'FAIL') {
    alert("이름 또는 비밀번호를 확인해주세요");
    }

    function submitContents(elClickedObj) {
        try {
            //빈값체크
            if(validateForm()){
                // 폼을 직접 찾아서 제출
                var form = document.getElementById("form");
                form.submit();
            }
        } catch(e) {
            console.error("Error submitting form:", e);
        }
    }

    function validateForm() {
        var name = document.getElementById('board_writer').value;
        var pw = document.getElementById('pw').value;

        if (name.trim() === '') {
            alert('이름을 입력하세요.');
            name.focus();
            return false;
        }

        if (pw.trim() === '') {
            alert('비밀번호를 입력하세요.');
            pw.focus();
            return false;
        }

        return true;
    }

        function setDefaultFont() {
        var sDefaultFont = '궁서';
        var nFontSize = 24;
        oEditors.getById["smartEditor"].setDefaultFont(sDefaultFont, nFontSize);
    }



</script>
