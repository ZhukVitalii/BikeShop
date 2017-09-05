<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Handles</title>
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
                            <li><a href="/start_page">МТВ</a></li>
                            <li><a href="bicycles.html">ШОССЕ</a></li>
                            <li><a href="bicycles.html">МІСЬКИЙ</a></li>
                        </ul>
                    </li>

                    <li class="dropdown1"><a href="parts.html">КОМППОНЕНТИ</a>
                        <ul class="dropdown2">
                            <li><a href="parts.html">Підібрати декілька компонентів</a></li>
                            <li><a href="parts.html">Рами</a></li>
                            <li><a href="parts.html">Вилки</a></li>
                            <li><a href="parts.html">Гальма</a></li>
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

<div class="container">

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${brakeMakers}" var="brakeMaker">
                                <li><a href="/brakeMaker/${brakeMaker.id}">${brakeMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <div class="product">
        <div class="container">
            <div class="ctnt-bar cntnt">
                <div class="content-bar">
                    <div class="single-page">
                        <div class="product-head">
                            <a href="index.html">Home</a> <span>::</span>
                        </div>

                        <c:forEach items="${brakeHandles}" var="brakeHandle">
                        <!--Include the Etalage files-->
                        <link rel="stylesheet" href="resources/css/etalage.css">
                        <script src="resources/js/jquery.etalage.min.js"></script>
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
                            <a href="optionallink.html">
                                <img height="300" width="300" src="${brakeHandle.way}" />
                            </a>
                            <div class="details-left-info">

                                <h3>${brakeHandle.name}</h3>
                                <p class="maker"> <h5> Виробник  : ${brakeHandle.brakeMaker.name} </h5></p>
                                <h4></h4>
                                <p>${brakeHandle.price}<label>грн</label><a href="#"></a></p>
                                <div class="btn_form">
                                    <a href="cart.html">Купити</a>
                                    <a href="cart.html">Додати до корзини</a>
                                </div>
                                <div class="bike-type">

                                    <table>
                                        <tr>
                                            <th><h5>Розташування  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.brakeHandleLocation.local}</i></b></font></th>
                                        </tr>
                                    </table>

                                    <table>
                                        <tr>
                                            <th><h5>Сумісність з  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.brakeHandleCompatibility.comp} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Матеріал ручки :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.materialHandle} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Матеріал корпусу :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.materialCorp} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <!--
                                    <table>
                                        <tr>
                                            <th><h5>Сумісність з діаметром руля  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.handlebarDiameter.diam} </i></b></font></th>
                                        </tr>
                                    </table>
                                    -->
                                    <table>
                                        <tr>
                                            <th><h5>Ширина ручки  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.brakeHandleWide.wide} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Вага  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.weight} </i></b></font></th>
                                        </tr>
                                    </table>
                                    <table>
                                        <tr>
                                            <th><h5>Колір  :   </h5></th>
                                            <th><p align="center"><font size="4" color="#0080C0" >
                                                <b><i>   ${brakeHandle.color} </i></b></font></th>
                                        </tr>
                                    </table>


                                    <h5>Опис  ::</h5>
                                    <p class="desc">${brakeHandle.description}</p>
                                </div>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/show_brakesHandle?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
                <c:if test="${byGroupPages ne null}">
                    <c:forEach var="i" begin="1" end="${byGroupPages}">
                        <li><a href="/brakeMaker/${groupId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                    </c:forEach>
                </c:if>
            </ul>
        </nav>
    </div>
</div>
</body>
</html>