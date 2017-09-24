<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>VitaliiZhuk</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <spring:url value="resources/css/bootstrap.css" var="bootstrap"/>

    <link href="resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="Bike-shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design" />
    <script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
    <!--webfont-->
    <link href='http://fonts.googleapis.com/css?family=Roboto:500,900,100,300,700,400' rel='stylesheet' type='text/css'>
    <link href="https://fonts.googleapis.com/css?family=Bitter" rel="stylesheet">
    <!--webfont-->
    <!-- dropdown -->
    <script src="resources/js/jquery.easydropdown.js"></script>
    <link href="resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="resources/js/scripts.js" type="text/javascript"></script>
    <!--js-->
    <!---- start-smoth-scrolling---->
    <script type="text/javascript" src="resources/js/move-top.js"></script>
    <script type="text/javascript" src="resources/js/easing.js"></script>
    <script type="text/javascript">
        jQuery(document).ready(function($) {
            $(".scroll").click(function(event){
                event.preventDefault();
                $('html,body').animate({scrollTop:$(this.hash).offset().top},900);
            });
        });
    </script>
    <!---- start-smoth-scrolling---->


</head>
<body>
<!--banner-->
<script src="resources/js/responsiveslides.min.js"></script>
<script>
    $(function () {
        $("#slider").responsiveSlides({
            auto: true,
            nav: true,
            speed: 500,
            namespace: "callbacks",
            pager: true,
        });
    });
</script>
<div class="banner-bg banner-bg1">
    <div class="container">
        <div class="header">
            <div class="logo">
                <a  href="/"><img src="resources/images/logo.png"
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

                    <a class="shop" href="cart.html"><img src="resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="caption">
        <div class="slider">
            <div class="callbacks_container">
                <ul class="rslides" id="slider">
                    <li><h1>МТВ</h1></li>
                    <li><h1>ШОССЕ</h1></li>
                    <li><h1>МІСЬКІЙ</h1></li>
                </ul>
                <p>Хочеш <span>унікальний</span> велосипед? <span>Твої</span> побажання - наші <span>запчастини!</span></p>
                <a class="morebtn" href="bicycles.html">ЗІБРАТИ МТВ!</a>
                <a class="morebtn" href="bicycles.html">ЗІБРАТИ ШОССЕ!</a>
                <a class="morebtn" href="bicycles.html">ЗІБРАТИ МІСЬКИЙ!</a>

            </div>
        </div>
    </div>
    <div class="dwn">
        <a class="scroll" href="#cate"><img src="resources/images/scroll.png" alt=""/></a>
    </div>
</div>
<!--/banner-->
<div id="cate" class="categories">
    <div class="container">
        <h3>Рами</h3>
        <div class="categorie-grids">
            <a href="/show_frames"><div class="col-md-4 cate-grid grid5">
                <h4>Рами</h4>
                <a class="store" href="/show_frames">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="container">
        <h3>Гальма</h3>
        <div class="categorie-grids">
            <a href="/show_brakesHydro"><div class="col-md-4 cate-grid grid1">
                <h4>Дискові гальма гідравлічні</h4>
                <a class="store" href="/show_brakesHydro">Вибрати</a>
            </div></a>
            <a href="/show_brakesMech"><div class="col-md-4 cate-grid grid2">
                <h4>Дискові гальма<br> механічні</h4>
                <a class="store" href="/show_brakesMech">Вибрати</a>
            </div></a>
            <a href="/show_brakesVBrake"><div class="col-md-4 cate-grid grid3">
                <h4>Ободні гальма (V-brake)</h4>
                <a class="store" href="/show_brakesVBrake">Вибрати</a>
            </div></a>
            <a href="/show_brakesHandle"><div class="col-md-4 cate-grid grid4">
                <h4>Гальмівні ручки</h4>
                <a class="store" href="/show_brakesHandle">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="container">
        <h3>Колеса та комплектуючі</h3>
        <div class="categorie-grids">
            <a href="/show_wheels"><div class="col-md-4 cate-grid grid6">
                <h4>Колеса</h4>
                <a class="store" href="/show_wheels">Вибрати</a>
            </div></a>
            <a href="/show_rims"><div class="col-md-4 cate-grid grid7">
                <h4>Обода</h4>
                <a class="store" href="/show_rims">Вибрати</a>
            </div></a>
            <a href="/show_frontHubs"><div class="col-md-4 cate-grid grid8">
                <h4>Передні втулки</h4>
                <a class="store" href="/show_frontHubs">Вибрати</a>
            </div></a>
            <a href="/show_backHubs"><div class="col-md-4 cate-grid grid9">
                <h4>Задні втулки</h4>
                <a class="store" href="/show_backHubs">Вибрати</a>
            </div></a>
            <a href="/show_spokes"><div class="col-md-4 cate-grid grid10">
                <h4>Спиці</h4>
                <a class="store" href="/show_spokes">Вибрати</a>
            </div></a>
            <a href="/show_tires"><div class="col-md-4 cate-grid grid11">
                <h4>Покришки</h4>
                <a class="store" href="/show_tires">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>
    <div class="container">
        <h3>Рульове управління</h3>
        <div class="categorie-grids">
            <a href="/show_handlebars"><div class="col-md-4 cate-grid grid12">
                <h4>Рулі</h4>
                <a class="store" href="/show_handlebars">Вибрати</a>
            </div></a>
            <a href="/show_windings"><div class="col-md-4 cate-grid grid13">
                <h4>Обмотки руля</h4>
                <a class="store" href="/show_windings">Вибрати</a>
            </div></a>
            <a href="/show_headsets"><div class="col-md-4 cate-grid grid14">
                <h4>Рульові колонки</h4>
                <a class="store" href="/show_headsets">Вибрати</a>
            </div></a>
            <a href="/show_stems"><div class="col-md-4 cate-grid grid15">
                <h4>Виноси</h4>
                <a class="store" href="/show_stems">Вибрати</a>
            </div></a>
            <a href="/show_grips"><div class="col-md-4 cate-grid grid16">
                <h4>Гріпси</h4>
                <a class="store" href="/show_grips">Вибрати</a>
            </div></a>
            <div class="clearfix"></div>
        </div>
    </div>



</div>


<!---->
<div class="contact">
    <div class="container">
        <h3>CONTACT US</h3>
        <p>Please contact us for all inquiries and purchase options.</p>
        <form>
            <input type="text" placeholder="NAME" required="">
            <input type="text" placeholder="SURNAME" required="">
            <input class="user" type="text" placeholder="USER@DOMAIN.COM" required=""><br>
            <textarea placeholder="MESSAGE"></textarea>
            <input type="submit" value="SEND">
        </form>
    </div>
</div>
<!---->
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="index.html"><img src="resources/images/logo2.png" alt=""/></a>
        </div>
        <div class="ftr-menu">
            <ul>
                <li><a href="bicycles.html">BICYCLES</a></li>
                <li><a href="parts.html">PARTS</a></li>
                <li><a href="accessories.html">ACCESSORIES</a></li>
                <li><a href="404.html">EXTRAS</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!---->

</body>
</html>

