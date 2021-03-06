<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Brakes</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
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
                <a href="/"><img src="resources/images/logo.png"
                                 alt=""
                                 width="110"
                                 height="112"/>
                </a>
            </div>
            <div class="top-nav">
                <label class="mobile_menu" for="mobile_menu">
                    <span>Menu</span>
                </label>
                <input id="mobile_menu" type="checkbox">
                <ul class="nav">
                    <li class="dropdown1"><a href="#chooseBike">Зібрати велосипед</a>
                        <ul class="dropdown2">
                            <li><a href="/chooseSize/${'MTB'}">МТВ</a></li>
                            <li><a href="/chooseSize/${'Shosse'}">ШОССЕ</a></li>
                            <li><a href="/chooseSize/${'City'}">МІСЬКИЙ</a></li>
                        </ul>
                    </li>
                    <li class="dropdown1"><a href="#cate">КОМППОНЕНТИ</a>
                        <ul class="dropdown2">
                            <!--
                            <li><a href="#">Підібрати декілька компонентів</a></li>
                            -->
                            <li><a href="/show_Frame">Рами</a></li>
                            <li><a href="/show_Fork">Вилки</a></li>
                            <li><a href="/show_brakesComponents">Гальма</a></li>
                            <li><a href="/show_handlebarsComponents">Рульове управління</a></li>
                            <li><a href="/show_wheelsComponent">Колеса та комплектуючі</a></li>
                            <li><a href="/show_transmissionComponent">Трансмісія</a></li>
                        </ul>
                    </li>
                    <li class="dropdown1"><a href="#">ДОДАТКОВІ КОМПЛЕКТУЮЧІ</a>
                        <ul class="dropdown2">
                            <li><a href="#">Сідла</a></li>
                            <li><a href="#">Підсидільні штирі</a></li>
                            <li><a href="#">Покришки</a></li>
                            <li><a href="#">Камери</a></li>
                            <li><a href="#">Баудени</a></li>
                            <li><a href="#">Троси</a></li>
                        </ul>
                    </li>
                    <a class="shop" href="/cart"><img src="resources/images/cart.png" alt=""/></a>
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
        <div class="row">
            <a href="/show_BrakeDiscHydraulic"><div class="col-md-4 col-sm-12 col-xs-12 component grid1">
                <h4>Дискові гальма гідравлічні</h4>
                <a class="store" href="/show_BrakeDiscHydraulic">Вибрати</a>
            </div></a>
            <a href="/show_BrakeDiscMechanik"><div class="col-md-4 col-sm-12 col-xs-12 component grid2">
                <h4>Дискові гальма механічні</h4>
                <a class="store" href="/show_BrakeDiscMechanik">Вибрати</a>
            </div></a>
            <a href="/show_BrakeVBrake"><div class="col-md-4 col-sm-12 col-xs-12 component grid3">
                <h4>Ободні гальма (V-brake)</h4>
                <a class="store" href="/show_BrakeVBrake">Вибрати</a>
            </div></a>
            <a href="/show_BrakeHandle"><div class="col-md-4 col-sm-12 col-xs-12 component grid4">
                <h4>Гальмівні ручки</h4>
                <a class="store" href="/show_BrakeHandle">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container" id="about">
        <div class="contact-details">
            <div class="logo2">
                <a href="/"><img src="resources/images/logo.png"
                                 alt="logo"
                                 width="60"
                                 height="62"/>
                </a>
                <div class="about">
                    <p>
                        Даний проект являється демонстраційним і не використовуєтсья для продажу комплектуючих.
                    </p>
                </div>
            </div>
            <h2>Контакти розробника</h2>
            <p class="address">
                <span>Vitalii Zhuk</span><br>
                <span>Ukraine, Kiev</span><br>
                <span class="address-block-label"><i class="fa fa-phone" aria-hidden="true"></i></span>
                <a class="address-block-link" target="_blank" href="tel:+380638521116">+380638521116</a><br>
                <span class="address-block-label"><i class="fa fa-envelope" aria-hidden="true"></i></span>
                <a class="address-block-link" target="_blank" href="mailto:golden_beetle@bigmir.net">zhukvitaliis@gmail.com</a><br>
                <span class="address-block-label"><i class="fa fa-facebook"></i></span>
                <a class="address-block-link" target="_blank" href="https://www.facebook.com/vitalii.zh">ZhukVitalii</a>
            </p>
        </div>
    </div>
</div>
<ul class="copyright">
    <li>&copy; Copyright 2018 VitaliiZhuk</li>
    <li>All Rights Reserved</li>
</ul>
</body>
</html>

