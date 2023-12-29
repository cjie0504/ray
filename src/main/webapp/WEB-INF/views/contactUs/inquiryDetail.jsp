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
                                    <th class="active" >작성자 이름</th>
                                    <td class="form-inline">${INQUIRY.name}</td>
                                </tr>
                                <tr>
                                    <th class="active" >소속</th>
                                    <td class="form-inline">${INQUIRY.company}</td>
                                </tr>
                                <tr>
                                    <th class="active" >이메일</th>
                                    <td class="form-inline">${INQUIRY.email}</td>
                                </tr>
                                <tr>
                                    <th class="active" >핸드폰번호</th>
                                    <td class="form-inline">${INQUIRY.phone}</td>
                                </tr>

                                <tr>
                                    <th class="active">제목</th>
                                    <td class="form-inline">${INQUIRY.title}</td>
                                </tr>
                                <tr>
                                    <th class="active">작성일</th>
                                    <td class="form-inline">${INQUIRY.regDt}</td>
                                </tr>
                                </tbody>
                            </table>
                        </div>

                    <div>
                            ${INQUIRY.contents}
                    </div>

                </div>
            </div>
        </div>
    </div>
    <div style="margin-right:50px; margin-top:100px;float: right">
        <a href="/inquiry" class="btn btn-secondary">목록으로</a>
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
</script>
