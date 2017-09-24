<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>${rim.name}/</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <spring:url value="${rim.url}/resources/css/bootstrap.css" var="bootstrap"/>
    <link href="${rim.url}/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="${rim.url}/resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="${rim.url}/resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href="${rim.url}/resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
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
    <script src="${rim.url}/resources/js/jquery.easydropdown.js"></script>
    <link href="${rim.url}/resources/css/nav.css" rel="stylesheet" type="text/css" media="all"/>
    <script src="${rim.url}/resources/js/scripts.js" type="text/javascript"></script>
    <!--js-->
</head>
<body>
<script src="${rim.url}/resources/js/responsiveslides.min.js"></script>
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
                <a href="/"><img src="${rim.url}/resources/images/logo.png"
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
                    <a class="shop" href="/cart"><img src="${rim.url}/resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="container">
    <div class="product">
        <div class="container">
            <div class="ctnt-bar cntnt">
                <div class="content-bar">
                    <div class="single-page">
                        <div class="product-head">
                            <a href="/">Home</a> <span>::</span>
                        </div>
                        <c:forEach items="${rims}" var="rim">
                        <!--Include the Etalage files-->
                        <link rel="stylesheet" href="${rim.url}/resources/css/etalage.css">
                        <script src="${rim.url}/resources/js/jquery.etalage.min.js"></script>
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
                            <img height="300" width="300" src="${rim.way}" />
                            <div class="details-left-info">
                                <h3>${rim.name}</h3>
                                <h5> Артикул  : ${rim.article}</h5>
                                <p class="maker"> <h3> Виробник  : ${rim.wheelMaker.name} </h3></p>
                                <h4></h4>
                                <p>${rim.price}<label>грн</label><a href="#"></a></p>
                                <div class="btn_form">
                                    <a href="cart.html">Купити</a>
                                    <a href="/cartAddRim/${rim.article}">Додати до корзини</a>
                                </div>
                                <div class="bike-type">
                                    <table>
                                        <tr>
                                            <th><h5>Тип :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.bikeType.type}</i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Діаметр  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.wheelsDiam.diam}</i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Розмір ETRTO :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.etrtoSize.size} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Матеріал :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.material} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Кількість спиць  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.spokeNumber.number} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Діаметр отвору під камеру  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.innerTubeDiameter.diam} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Ширина обода  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.rimWide.wide} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Висота обода  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.rimHeight.height} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Сумісність з гальмами  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.brakesType.type} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Вага  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.weight} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Тип ніпелю  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.nipple.nipple} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Колір  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${rim.color} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <h5>Опис ::</h5>
                                    <p class="desc">${rim.description}</p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>

            </div>
        </div>
        </c:forEach>
    </div>
</div>
</body>
</html>