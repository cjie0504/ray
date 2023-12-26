<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8"%>

<style>
    body {
        font-size: 140%;
    }

    h2 {
        text-align: center;
        padding: 20px 0;
    }

    table caption {
        padding: .5em 0;
    }

    table.dataTable th,
    table.dataTable td {
        white-space: nowrap;
    }

    .p {
        text-align: center;
        padding-top: 140px;
        font-size: 14px;
    }

    html,
    body {
        font: 100%/1.5 Verdana, sans-serif
    }
    #wrapper {
        margin: 0 auto;
        display: block;
        width: 960px;
    }
    .page-header {
        text-align: center;
        font-size: 1.5em;
        font-weight: normal;
        border-bottom: 1px solid #ddd;
        margin: 30px 0
    }
    #pagination {
        margin: 0;
        padding: 0;
        text-align: center
    }
    #pagination li {
        display: inline
    }
    #pagination li a {
        display: inline-block;
        text-decoration: none;
        padding: 5px 10px;
        color: #000
    }

    /* Active and Hoverable Pagination */
    #pagination li a {
        border-radius: 5px;
        -webkit-transition: background-color 0.3s;
        transition: background-color 0.3s

    }
    #pagination li a.active {
        background-color: #4caf50;
        color: #fff
    }
    #pagination li a:hover:not(.active) {
        background-color: #ddd;
    }

    /* border-pagination */
    .b-pagination-outer {
        width: 100%;
        margin: 0 auto;
        text-align: center;
        overflow: hidden;
        display: flex
    }
    #border-pagination {
        margin: 0 auto;
        padding: 0;
        text-align: center
    }
    #border-pagination li {
        display: inline;

    }
    #border-pagination li a {
        display: block;
        text-decoration: none;
        color: #000;
        padding: 5px 10px;
        border: 1px solid #ddd;
        float: left;

    }
    #border-pagination li a {
        -webkit-transition: background-color 0.4s;
        transition: background-color 0.4s
    }
    #border-pagination li a.active {
        background-color: #4caf50;
        color: #fff;
    }
    #border-pagination li a:hover:not(.active) {
        background: #ddd;
    }
    /*.myButton {*/
    /*    box-shadow: 0px 0px 0px -7px #276873;*/
    /*    background-color:#599bb3;*/
    /*    border-radius:8px;*/
    /*    display:inline-block;*/
    /*    cursor:pointer;*/
    /*    color:#ffffff;*/
    /*    font-family:Arial;*/
    /*    font-size:14px;*/
    /*    padding:9px 19px;*/
    /*    text-decoration:none;*/
    /*    text-shadow:0px 0px 0px #3d768a;*/
    /*}*/
    /*.myButton:hover {*/
    /*    background-color:#408c99;*/
    /*}*/
    /*.myButton:active {*/
    /*    position:relative;*/
    /*    top:1px;*/
    /*}*/
</style>
<!-- Header Section Begin -->
<jsp:include page="../layout/header.jsp"></jsp:include>
<spring:eval expression="page" var="page" />

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
<section class="spad">
    <div class="container">
        <div class="row" style="justify-content: space-around;">
            <div class="col-xs-12" style="width: 80%;">
                <table summary="This table shows how to create responsive tables using Datatables' extended functionality" class="table table-bordered table-hover dt-responsive">
                    <caption class="text-center">An example of a responsive table based on <a href="https://datatables.net/extensions/responsive/" target="_blank">DataTables</a>:</caption>
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
<%--                        <th>댓글수</th>--%>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="list" items="${INQUIRY_LIST.content}">
                        <tr onclick="goDetail(${list.inquiryNo})">
                            <td>${list.inquiryNo}</td>
                            <td>${list.title}</td>
                            <td>${list.name}</td>
                            <td>${list.regDt}</td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <div class="btn-text-right" style=" text-align: right;margin: 1em 8em 1.5em 0;">
            <button type="button" class="btn btn-primary" onclick="goToRegisterPage()">글쓰기</button>
        </div>

    </div>

    <div id="wrapper">
        <div class="b-pagination-outer">
            <ul id="border-pagination">
                <li><a class="" href="<c:url value="?page=0" />">«</a></li>
                <c:forEach var="i" begin="${START_PAGE-1}" end="${END_PAGE - 1}">
                    <c:choose>
                        <c:when test="${INQUIRY_LIST.number eq i}">
                            <li><a href="<c:url value="?page=1" />" class="active">${i + 1}</a></li>
                        </c:when>
                        <c:otherwise>
                            <li><a href="<c:url value="?page=${i}" />">${i + 1}</a></li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <li><a href="<c:url value="?page=${INQUIRY_LIST.totalPages-1}" />">»</a></li>
            </ul>
        </div>

    </div>
</div>
</section>
<!--    footer start-->
<jsp:include page="../layout/footer.jsp"></jsp:include>
<!-- Js Plugins -->
<script type="text/javascript" src="../resources/static/smartEditor/js/HuskyEZCreator.js" charset="utf-8"></script>
<script src="/resources/js/jquery-3.3.1.min.js"></script>
<script src="/resources/js/bootstrap.min.js"></script>
<script src="/resources/js/jquery.magnific-popup.min.js"></script>
<script src="/resources/js/mixitup.min.js"></script>
<script src="/resources/js/masonry.pkgd.min.js"></script>
<script src="/resources/js/jquery.slicknav.js"></script>
<script src="/resources/js/owl.carousel.min.js"></script>
<script src="/resources/js/main.js"></script>
<script>
    $('table').DataTable();
    function goToRegisterPage(){
        var pageUrl='/contactUs/inquiryRegister';
        window.location.href = pageUrl;
    }

    function goDetail(no){
        var pageUrl='/inquiry/detail/'+no;
        window.location.href = pageUrl;
    }
</script>