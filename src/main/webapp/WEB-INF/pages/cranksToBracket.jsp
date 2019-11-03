<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Cranks</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <spring:url value="/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="/resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="/resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href="/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
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
    <script src="/resources/js/jquery.easydropdown.js"></script>
    <link href="/resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="/resources/js/scripts.js" type="text/javascript"></script>
    <!--js-->


</head>

<body>
<script src="/resources/js/responsiveslides.min.js"></script>
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
                <a href="/"><img src="/resources/images/logo.png"
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
                            <li><a href="/chooseMTBSize">МТВ</a></li>
                            <li><a href="/chooseShosseSize">ШОССЕ</a></li>
                            <li><a href="/chooseCitySize">МІСЬКИЙ</a></li>
                        </ul>
                    </li>
                    <li class="dropdown1"><a href="#cate">КОМППОНЕНТИ</a>
                        <ul class="dropdown2">
                            <!--
                            <li><a href="#">Підібрати декілька компонентів</a></li>
                            -->
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
                    <a class="shop" href="/cart"><img src="/resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>

<div class="container">
    <div class="product">
        <div class="product-head">
            <a href="/">Home</a> <span>::</span>
        </div>
        <c:forEach items="${cranks}" var="crank">
            <!--Include the Etalage files-->
            <link rel="stylesheet" href="/resources/css/etalage.css">
            <script src="/resources/js/jquery.etalage.min.js"></script>
            <script>
                jQuery(document).ready(function($){
                    $('#etalage').etalage({
                        thumb_image_width: 400,
                        thumb_image_height: 400,
                        source_image_width: 800,
                        source_image_height: 1000,
                        show_hint: true,
                        click_callback: function(image_anchor, instance_id){
                            alert('Callback example:\nYou clicked on an image with the anchor: "'+image_anchor+'"\n(in Etalage instance: "'+instance_id+'")');
                        }
                    });
                });
            </script>
            <!--//details-product-slider-->
            <div class="details-left-slider">
                <a href="<c:url value="/crank/${crank.url}"/>"
                   title="Перейти до <c:out value="${crank.name}"/>">
                    <img height="300" width="300" src="${crank.way}" />
                </a>
                <div class="details-left-info">
                    <div class="link-to-one">
                        <a href="<c:url value="/crank/${crank.url}"/>"
                           title="Перейти до <c:out value="${crank.name}"/>">
                            <h3>${crank.name}</h3>
                        </a>
                    </div>
                    <h5> Артикул  : ${crank.article}</h5>
                    <p class="manufacturer"> <h3> Виробник  : ${crank.transmissionMaker.name} </h3></p>
                    <h4></h4>
                    <p>${crank.price}<label>грн</label><a href="#"></a></p>
                    <div class="btn_form">
                        <a href="/chooseBackGearKas/${crank.id}">Підібрати компоненти під дану каретку</a>
                        <a href="/cartAddCrank/${crank.article}">Додати до корзини</a>
                    </div>
                    <div class="bike-type">
                        <table>
                            <tr>
                                <th><h5>Тип велосипеду  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.bikeType.type}</i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Сумісність з кількістю задніх зірок :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.backSprocketNumber.number} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Кількість зірок :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.frontSprocketNumber.number} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Набір зірок :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.frontSprocketSize.size} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Найбільша зірка  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.frontSprocketMax.number} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Найменша зірка  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.frontSprocketMin.number} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Довжина шатуна  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.crankLength.length} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Матеріаль зірок  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.sprocketMaterial} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Матеріаль шатуна :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.crankMaterial} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Тип каретки  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.bracketType.type} </i></b></font></th>
                            </tr>
                        </table>
                        <table>
                            <tr>
                                <th><h5>Колір  :   </h5></th>
                                <th><p align="center"><font size="4" color="#0080C0" >
                                    <b><i>   ${crank.color} </i></b></font></th>
                            </tr>
                        </table>
                        <h5>Опис ::</h5>
                        <p class="desc">${crank.description}</p>
                    </div>
                </div>
                <div class="clearfix"></div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>