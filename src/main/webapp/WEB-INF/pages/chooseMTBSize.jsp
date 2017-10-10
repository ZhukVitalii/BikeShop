<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Frames</title>
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
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
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
                    <a class="shop" href="/cart"><img src="resources/images/cart.png" alt=""/></a>
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

                </ul>
            </div>
        </div>
    </nav>

    <div class="product-head">
        <a href="index.html">Home</a> <span>::</span>
    </div>
    <h3>Виберіть розмір згідно таблиці</h3>
    <br>
    <div class="table-responsive col-md-10">
        <table class="table">
            <thead>
            <tr>
                <th>Ваш зріст</th>
                <th>Розмір рами </th>
                <th>Розмір рами в дюймах </th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>135-150</td>
                <td>XS</td>
                <td>14</td>
            </tr>
            <tr>
                <td>150-160</td>
                <td>XS, S</td>
                <td>15</td>
            </tr>
            <tr>
                <td>155-165</td>
                <td>S</td>
                <td>16</td>
            </tr>
            <tr>
                <td>165-175</td>
                <td>S, M</td>
                <td>17</td>
            </tr>
            <tr>
                <td>170-180</td>
                <td>L</td>
                <td>18</td>
            </tr>
            <tr>
                <td>175-185</td>
                <td>L</td>
                <td>19</td>
            </tr>
            <tr>
                <td>180-190</td>
                <td>XL</td>
                <td>20</td>
            </tr>
            <tr>
                <td>185-190</td>
                <td>XL</td>
                <td>21</td>
            </tr>
            <tr>
                <td>185-195</td>
                <td>XXL</td>
                <td>22</td>
            </tr>
            <tr>
                <td>190-200</td>
                <td>XXL</td>
                <td>23</td>
            </tr>
            </tbody>
        </table>
    </div>
    <div class="clearfix"></div>
   <div class="categorie-grids">
        <c:forEach items="${framesizes}" var="framesize">
            <div class="col-md-4 cate-grid grid26">
                <a href="<c:url value="/framesMTB/${framesize.id}"/>">
                    <b><i>${framesize.size} </i></b></font>
                </a>
            </div>
        </c:forEach>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>