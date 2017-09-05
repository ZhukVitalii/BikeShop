<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Handlebar and Components</title>
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>
    <link href="resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Bike-shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
    <!--webfont-->
    <!-- dropdown -->
    <script src="resources/js/jquery.easydropdown.js"></script>
    <link href="resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="resources/js/scripts.js" type="text/javascript"></script>
    <!--js-->


</head>

<body>
<script src="resources/js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: false,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>
<div class="banner-bg banner-sec">
    <div class="container">
        <div class="header">
            <div class="logo">
                <a href="/"><img src="resources/images/logo.png" alt=""/></a>
            </div>
            <div class="top-nav">
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label>
                <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="dropdown1"><a href="bicycles.html">Зібрати велосипед</a>
                        <ul class="dropdown2">
                            <li><a href="/chooseMTBSize">МТВ</a></li>
                            <li><a href="/chooseShosseSize">ШОССЕ</a></li>
                            <li><a href="/chooseCitySize">МІСЬКИЙ</a></li>
                        </ul>
                    </li>
                    <li class="dropdown1"><a href="parts.html">КОМППОНЕНТИ</a>
                        <ul class="dropdown2">
                            <li><a href="parts.html">Підібрати декілька компонентів</a></li>
                            <li><a href="/show_frames">Рами</a></li>
                            <li><a href="/show_forks">Вилки</a></li>
                            <li><a href="/show_brakesComponents">Гальма</a></li>
                            <li><a href="parts.html">Рульове управління</a></li>
                            <li><a href="parts.html">Колеса та комплектуючі</a></li>
                            <li><a href="parts.html">Трансмісія</a></li>
                        </ul>
                    </li>
                    <li class="dropdown1"><a href="accessories.html">ДОДАТКОВІ КОМПЛЕКТУЮЧІ</a>
                        <ul class="dropdown2">
                            <li><a href="accessories.html">Сідла</a></li>
                            <li><a href="accessories.html">Підсидільні штирі</a></li>
                            <li><a href="accessories.html">Покришки</a></li>
                            <li><a href="accessories.html">Камери</a></li>
                            <li><a href="accessories.html">Баудени</a></li>
                            <li><a href="accessories.html">Троси</a></li>
                        </ul>
                    </li>

                    <a class="shop" href="cart.html"><img src="resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<!--/banner-->
<div id="cate" class="categories">
    <div class="container">
        <h3>Категорії</h3>
        <div class="categorie-grids">
            <a href="/show_handlebars"><div class="col-md-4 cate-grid grid12">
                <h4>Рулі</h4>
                <a class="store" href="/show_handlebars">Вибрати</a>
            </div></a>
            <a href="/show_stems"><div class="col-md-4 cate-grid grid15">
                <h4>Виноси</h4>
                <a class="store" href="/show_stems">Вибрати</a>
            </div></a>
            <a href="/show_windings"><div class="col-md-4 cate-grid grid13">
                <h4>Обмотки руля</h4>
                <a class="store" href="/show_windings">Вибрати</a>
            </div></a>
            <a href="/show_headsets"><div class="col-md-4 cate-grid grid14">
                <h4>Рульові колонки</h4>
                <a class="store" href="/show_headsets">Вибрати</a>
            </div></a>
            <a href="/show_grips"><div class="col-md-4 cate-grid grid16">
                <h4>Гріпси</h4>
                <a class="store" href="/show_grips">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>
</div>


</body>
</html>

