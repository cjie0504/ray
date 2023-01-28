<%--<%@ page pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>--%>
<%--<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>--%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<%--<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>--%>

<%--<!doctype html>--%>
<%--<html lang="ko">--%>
<%--<head>--%>
<%--</head>--%>

<%--<body>--%>
<%--<header>--%>
<%--    <jsp:include page="layout/header.jsp"></jsp:include>--%>
<%--</header>--%>
<%--<div class="body-contents container content">--%>
<%--    asd--%>
<%--</div>--%>

<%--<footer>--%>
<%--    <jsp:include page="layout/footer.jsp"></jsp:include>--%>
<%--</footer>--%>
<%--</body>--%>
<%--</html>--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" isELIgnored="false"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="format-detection" content="telephone=no"/>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="title" content="MyGenomeBox">
    <meta name="description" content="Personal Genome Revolution - Cloud based Genomics Healthcare Web Portal & Genome App Box">
    <meta name="keywords" content="MyGenomeBox, chromosome, DNA, MGB">
    <meta name="_csrf" content="${_csrf.token}"/>
    <meta name="_csrf_header" content="${_csrf.headerName}"/>
    <meta property="og:title" content="MyGenomeBox">
    <meta property="og:description" content="Personal Genome Revolution - Cloud based Genomics Healthcare Web Portal & Genome App Box">
    <meta property="og:url" content="https://www.mygenomebox.com">
    <meta property="og:type" content="website">
    <meta property="og:site_name" content="MyGenomeBox">
    <meta property="og:image" content="https://d14rou3pdf9zu2.cloudfront.net/kr/common/top_logo_new2.png">

    <title>MyGenomeBox</title>

    <!-- Favicon -->

    <link rel="shortcut icon" href="https://d14rou3pdf9zu2.cloudfront.net/kr/common/meta.png">
    <link rel="apple-touch-icon" href="https://d14rou3pdf9zu2.cloudfront.net/kr/common/meta.png">
    <link rel="apple-touch-icon-precomposed" href="https://d14rou3pdf9zu2.cloudfront.net/kr/common/meta.png">

    <!-- Web Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,400i,600,600i,700,700i,800" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Encode+Sans:400,500,600,700,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&display=swap&subset=korean" rel="stylesheet">

    <!-- CSS Global Compulsory -->
    <link rel="stylesheet" href="/resources/assets/plugins/bootstrap/css/bootstrap.min.css?${srcVersion}">
    <link rel="stylesheet" href="/resources/assets/css/style.min.css?${srcVersion}">

    <!-- CSS Header and Footer -->
    <link rel="stylesheet" href="/resources/assets/css/headers/header-v8.min.css?${srcVersion}">
    <link rel="stylesheet" href="/resources/assets/css/footers/footer-v1.min.css?${srcVersion}">

    <!-- CSS Implementing Plugins -->
    <link rel="stylesheet" href="/resources/assets/plugins/animate.min.css?${srcVersion}">
    <link rel="stylesheet" href="/resources/assets/plugins/font-awesome/css/font-awesome.min.css?${srcVersion}">
    <link rel="stylesheet" href="/resources/assets/plugins/parallax-slider/css/parallax-slider.min.css?${srcVersion}">
    <link rel="stylesheet" href="/resources/assets/plugins/sky-forms-pro/skyforms/css/sky-forms.min.css?${srcVersion}">

    <!-- CSS Theme -->
    <link rel="stylesheet" href="/resources/assets/css/theme-colors/blue.min.css?${srcVersion}" id="style_color">

    <!-- CSS Customization -->
    <link rel="stylesheet" href="/resources/assets/css/custom.min.css?${srcVersion}">

</head>
<body class="header-fixed header-fixed-space-v2 ext-webkit ext-chrome" id="syno-nsc-ext-gen3">
<div class="wrapper">
    <jsp:include page="layoutBackup/header.jsp"></jsp:include>
    gg
    <jsp:include page="layoutBackup/footer.jsp"></jsp:include>

    <!-- loading -->
    <div id="loading_section" class="loading_section">
        <div class="img_loading"></div>
        <div class="bg_loading"></div>
    </div>
    <!-- //loading -->

</div>

</body>
</html>