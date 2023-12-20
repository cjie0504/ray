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
            <div class="col-xs-12">
                <table summary="This table shows how to create responsive tables using Datatables' extended functionality" class="table table-bordered table-hover dt-responsive">
                    <caption class="text-center">An example of a responsive table based on <a href="https://datatables.net/extensions/responsive/" target="_blank">DataTables</a>:</caption>
                    <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>날짜</th>
                        <th>댓글수</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>Argentina</td>
                        <td>Spanish (official), English, Italian, German, French</td>
                        <td>41,803,125</td>
                        <td>31.3</td>
                        <td>2,780,387</td>
                    </tr>
                    <tr>
                        <td>Australia</td>
                        <td>English 79%, native and other languages</td>
                        <td>23,630,169</td>
                        <td>37.3</td>
                        <td>7,739,983</td>
                    </tr>
                    <tr>
                        <td>Greece</td>
                        <td>Greek 99% (official), English, French</td>
                        <td>11,128,404</td>
                        <td>43.2</td>
                        <td>131,956</td>
                    </tr>
                    <tr>
                        <td>Luxembourg</td>
                        <td>Luxermbourgish (national) French, German (both administrative)</td>
                        <td>536,761</td>
                        <td>39.1</td>
                        <td>2,586</td>
                    </tr>
                    <tr>
                        <td>Russia</td>
                        <td>Russian, others</td>
                        <td>142,467,651</td>
                        <td>38.4</td>
                        <td>17,076,310</td>
                    </tr>
                    <tr>
                        <td>Sweden</td>
                        <td>Swedish, small Sami- and Finnish-speaking minorities</td>
                        <td>9,631,261</td>
                        <td>41.1</td>
                        <td>449,954</td>
                    </tr>
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
                <li><a class="" href="#">«</a></li>
                <li><a href="#">1</a></li>
                <li><a href="#" class="active">2</a></li>
                <li><a href="#">3</a></li>
                <li><a href="#">4</a></li>
                <li><a href="#">5</a></li>
                <li><a href="#">6</a></li>
                <li><a href="#">7</a></li>
                <li><a href="#">»</a></li>
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
</script>