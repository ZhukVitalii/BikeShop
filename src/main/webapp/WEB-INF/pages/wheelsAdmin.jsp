<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
    <title>Admin</title>
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
                    <a class="shop" href="/cart"><img src="/resources/images/cart.png" alt=""/></a>
                </ul>
            </div>
            <div class="clearfix"></div>
        </div>
    </div>
</div>
<div class="container">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_wheel" class="btn btn-default navbar-btn">Додати колесо</button></li>
                    <li><button type="button" id="add_wheelMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_wheel" class="btn btn-default navbar-btn">Видалити колесо</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Діаметр колеса</b></td>
            <td><b>Тип</b></td>
            <td><b>Тип гальм</b></td>
            <td><b>Кількість спиць</b></td>
            <td><b>Обід</b></td>
            <td><b>Ширина обода</b></td>
            <td><b>Опис обода</b></td>
            <td><b>Втулка</b></td>
            <td><b>Опис втулки</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${wheels}" var="wheel">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${wheel.id}" id="checkbox_${wheel.id}"/></td>

                <td>${wheel.name}</td>

                <c:choose>
                    <c:when test="${wheel.wheelsDiam ne null}">
                        <td>${wheel.wheelsDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${wheel.bikeType ne null}">
                        <td>${wheel.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${wheel.brakesType ne null}">
                        <td>${wheel.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${wheel.spokeNumber ne null}">
                        <td>${wheel.spokeNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${wheel.rimName}</td>

                <c:choose>
                    <c:when test="${wheel.rimWide ne null}">
                        <td>${wheel.rimWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${wheel.rimDescription}</td>
                <td>${wheel.hubName}</td>
                <td>${wheel.hubDescription}</td>
                <td>${wheel.description}</td>
                <td>${wheel.price}</td>

                <c:choose>
                    <c:when test="${wheel.maker ne null}">
                        <td>${wheel.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${wheel.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Обода</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul id="groupList2" class="nav navbar-nav">
                    <li><button type="button" id="add_rim" class="btn btn-default navbar-btn">Додати обід</button></li>
                    <li><button type="button" id="add_rimMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_rim" class="btn btn-default navbar-btn">Видалити обід</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип</b></td>
            <td><b>Діаметр</b></td>
            <td><b>Розмір ETRTO</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Кількість отворів для спиць</b></td>
            <td><b>Діаметр отвору під камеру</b></td>
            <td><b>Ширина</b></td>
            <td><b>Висота</b></td>
            <td><b>Тип гальм</b></td>
            <td><b>Вага</b></td>
            <td><b>Тип ніпеля</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${rims}" var="rim">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${rim.id}" id="checkbox_${rim.id}"/></td>

                <td>${rim.name}</td>
                <c:choose>
                    <c:when test="${rim.bikeType ne null}">
                        <td>${rim.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${rim.wheelsDiam ne null}">
                        <td>${rim.wheelsDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${rim.etrtoSize ne null}">
                        <td>${rim.etrtoSize.size}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${rim.material}</td>
                <c:choose>
                    <c:when test="${rim.spokeNumber ne null}">
                        <td>${rim.spokeNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${rim.innerTubeDiameter ne null}">
                        <td>${rim.innerTubeDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${rim.rimWide ne null}">
                        <td>${rim.rimWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${rim.rimHeight ne null}">
                        <td>${rim.rimHeight.height}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${rim.brakesType ne null}">
                        <td>${rim.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${rim.weight}</td>
                <c:choose>
                    <c:when test="${rim.nipple ne null}">
                        <td>${rim.nipple.nipple}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${rim.color}</td>
                <td>${rim.description}</td>
                <td>${rim.price}</td>

                <c:choose>
                    <c:when test="${rim.maker ne null}">
                        <td>${rim.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${rim.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big>Передня втулка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                <ul id="groupList3" class="nav navbar-nav">
                    <li><button type="button" id="add_frontHub" class="btn btn-default navbar-btn">Додати передню втулку</button></li>
                    <li><button type="button" id="add_frontHubMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_frontHub" class="btn btn-default navbar-btn">Видалити передню втулку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип кріплення втулки</b></td>
            <td><b>Тип підшипників</b></td>
            <td><b>Матеріал осі</b></td>
            <td><b>Довжина осі</b></td>
            <td><b>Діаметер осі</b></td>
            <td><b>Тип гальм</b></td>
            <td><b>Кріплення ротора</b></td>
            <td><b>Кількість спиць</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${frontHubs}" var="frontHub">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${frontHub.id}" id="checkbox_${frontHub.id}"/></td>

                <td>${frontHub.name}</td>
                <c:choose>
                    <c:when test="${frontHub.hubFixType ne null}">
                        <td>${frontHub.hubFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${frontHub.bearingType ne null}">
                        <td>${frontHub.bearingType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frontHub.material}</td>
                <c:choose>
                    <c:when test="${frontHub.axisLength ne null}">
                        <td>${frontHub.axisLength.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frontHub.axisDiam ne null}">
                        <td>${frontHub.axisDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frontHub.brakesType ne null}">
                        <td>${frontHub.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frontHub.rotorFixType ne null}">
                        <td>${frontHub.rotorFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frontHub.spokeNumber ne null}">
                        <td>${frontHub.spokeNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frontHub.weight}</td>
                <td>${frontHub.color}</td>
                <td>${frontHub.description}</td>
                <td>${frontHub.price}</td>

                <c:choose>
                    <c:when test="${frontHub.maker ne null}">
                        <td>${frontHub.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${frontHub.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big>Задня втулка</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
                <ul id="groupList5" class="nav navbar-nav">
                    <li><button type="button" id="add_backHub" class="btn btn-default navbar-btn">Додати задню втулку</button></li>
                    <li><button type="button" id="add_backHubMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_backHub" class="btn btn-default navbar-btn">Видалити задню втулку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип кріплення втулки</b></td>
            <td><b>Тип підшипників</b></td>
            <td><b>Матеріал осі</b></td>
            <td><b>Довжина осі</b></td>
            <td><b>Діаметер осі</b></td>
            <td><b>Тип гальм</b></td>
            <td><b>Кріплення ротора</b></td>
            <td><b>Кількість спиць</b></td>
            <td><b>Сумісність з типом передачі</b></td>
            <td><b>Сумісність з кількістю передач</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${backHubs}" var="backHub">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${backHub.id}" id="checkbox_${backHub.id}"/></td>

                <td>${backHub.name}</td>
                <c:choose>
                    <c:when test="${backHub.hubFixType ne null}">
                        <td>${backHub.hubFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backHub.bearingType ne null}">
                        <td>${backHub.bearingType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${backHub.material}</td>
                <c:choose>
                    <c:when test="${backHub.axisLength ne null}">
                        <td>${backHub.axisLength.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${backHub.axisDiam ne null}">
                        <td>${backHub.axisDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${backHub.brakesType ne null}">
                        <td>${backHub.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${backHub.rotorFixType ne null}">
                        <td>${backHub.rotorFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                <c:when test="${backHub.spokeNumber ne null}">
                    <td>${backHub.spokeNumber.number}</td>
                </c:when>
                <c:otherwise>
                    <td>Default</td>
                </c:otherwise>
            </c:choose>

                <c:choose>
                    <c:when test="${backHub.backSprocketType ne null}">
                        <td>${backHub.backSprocketType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${backHub.backSprocketNumber ne null}">
                        <td>${backHub.backSprocketNumber.number}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${backHub.weight}</td>
                <td>${backHub.color}</td>
                <td>${backHub.description}</td>
                <td>${backHub.price}</td>

                <c:choose>
                    <c:when test="${backHub.maker ne null}">
                        <td>${backHub.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${backHub.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big>Спиці</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul id="groupList1" class="nav navbar-nav">
                    <li><button type="button" id="add_spoke" class="btn btn-default navbar-btn">Додати спиці</button></li>
                    <li><button type="button" id="add_spokeMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_spoke" class="btn btn-default navbar-btn">Видалити спиці</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Довжина</b></td>
            <td><b>Діаметр</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${spokes}" var="spoke">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${spoke.id}" id="checkbox_${spoke.id}"/></td>

                <td>${spoke.name}</td>
                <td>${spoke.length}</td>
                <td>${spoke.diameter}</td>
                <td>${spoke.material}</td>
                <td>${spoke.color}</td>
                <td>${spoke.description}</td>
                <td>${spoke.price}</td>

                <c:choose>
                    <c:when test="${spoke.maker ne null}">
                        <td>${spoke.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${spoke.way}"/></td>
            </tr>
        </c:forEach>
    </table>
    <big>Покришки</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-6">
                <ul id="groupList6" class="nav navbar-nav">
                    <li><button type="button" id="add_tire" class="btn btn-default navbar-btn">Додати покришку</button></li>
                    <li><button type="button" id="add_tireMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_tire" class="btn btn-default navbar-btn">Видалити покришку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${wheelMakers}" var="wheelMaker">
                                <li><a href="/wheelMaker/${wheelMaker.id}">${wheelMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Діаметр колеса</b></td>
            <td><b>Тип покришки</b></td>
            <td><b>Корд</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${tires}" var="tire">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${tire.id}" id="checkbox_${tire.id}"/></td>

                <td>${tire.name}</td>

                <c:choose>
                    <c:when test="${tire.wheelsDiam ne null}">
                        <td>${tire.wheelsDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${tire.tireType ne null}">
                        <td>${tire.tireType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${tire.cordType ne null}">
                        <td>${tire.cordType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${tire.color}</td>
                <td>${tire.description}</td>
                <td>${tire.price}</td>

                <c:choose>
                    <c:when test="${tire.maker ne null}">
                        <td>${tire.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${tire.way}"/></td>
            </tr>
        </c:forEach>
    </table>





    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_wheels?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/wheelMaker/${wheelMakerId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_wheel').click(function(){
        window.location.href='/admin/wheel_add_page';
    });

    $('#add_spoke').click(function(){
        window.location.href='/admin/spoke_add_page';
    });
    $('#add_rim').click(function(){
        window.location.href='/admin/rim_add_page';
    });
    $('#add_frontHub').click(function(){
        window.location.href='/admin/frontHub_add_page';
    });
    $('#add_backHub').click(function(){
        window.location.href='/admin/backHub_add_page';
    });
    $('#add_tire').click(function(){
        window.location.href='/admin/tire_add_page';
    });

    $('#add_wheelMaker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });

    $('#add_spokeMaker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });

    $('#add_rimMaker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });
    $('#add_frontHubMaker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });

    $('#add_backHubMaker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });
    $('#add_tireMakeraker').click(function(){
        window.location.href='/admin/wheelMaker_add_page';
    });

    $('#delete_wheel').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/wheel/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_rim').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/rim/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_spoke').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/spoke/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_frontHub').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/frontHub/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_backHub').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/backHub/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_tire').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/tire/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>