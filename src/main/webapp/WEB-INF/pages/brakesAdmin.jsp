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
    <big>Дискові гідравлічні гальма</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_brakeDiscHydr" class="btn btn-default navbar-btn">Додати дискові гідравлічні гальма</button></li>
                    <li><button type="button" id="add_brakeMakerDiscHydr" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_brakeDiscHydr" class="btn btn-default navbar-btn">Видалити гальма</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${brakeMakers}" var="brakeMaker">
                                <li><a href="/brakeMakerAdmin/${brakeMaker.id}">${brakeMaker.name}</a></li>
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
            <td><b>Розташування</b></td>
            <td><b>Гальмівна рідина</b></td>
            <td><b>Матеріал ручок</b></td>
            <td><b>Довжина гідролінії</b></td>
            <td><b>Діаметр ротора</b></td>
            <td><b>Вага ротора</b></td>
            <td><b>Матеріал гальм</b></td>
            <td><b>Вага гальм(без ротора,ручок та ін.</b></td>
            <td><b>Фіксація ротора</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${brakeDiscHydraulics}" var="brakeDiscHydraulic">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${brakeDiscHydraulic.id}" id="checkbox_${brakeDiscHydraulic.id}"/></td>

                <td>${brakeDiscHydraulic.name}</td>

                <c:choose>
                    <c:when test="${brakeDiscHydraulic.location ne null}">
                        <td>${brakeDiscHydraulic.location.local}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${brakeDiscHydraulic.brakeLiquid ne null}">
                        <td>${brakeDiscHydraulic.brakeLiquid.liq}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeDiscHydraulic.materialHandle}</td>

                <c:choose>
                    <c:when test="${brakeDiscHydraulic.lengthHydroline ne null}">
                        <td>${brakeDiscHydraulic.lengthHydroline.length}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${brakeDiscHydraulic.rotorDiam ne null}">
                        <td>${brakeDiscHydraulic.rotorDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeDiscHydraulic.rotorWeight}</td>
                <td>${brakeDiscHydraulic.material}</td>
                <td>${brakeDiscHydraulic.brakeWeight}</td>
                <c:choose>
                    <c:when test="${brakeDiscHydraulic.rotorFixType ne null}">
                        <td>${brakeDiscHydraulic.rotorFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeDiscHydraulic.color}</td>
                <td>${brakeDiscHydraulic.description}</td>

                <td>${brakeDiscHydraulic.price}</td>

                <c:choose>
                    <c:when test="${brakeDiscHydraulic.maker ne null}">
                        <td>${brakeDiscHydraulic.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${brakeDiscHydraulic.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Дискові механічні гальма</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul id="groupList1" class="nav navbar-nav">
                    <li><button type="button" id="add_brakeDiscMech" class="btn btn-default navbar-btn">Додати дискові мехінічні гальма</button></li>
                    <li><button type="button" id="add_brakeMakerDiscMech" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_brakeDiscMech" class="btn btn-default navbar-btn">Видалити гальма</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${brakeMakers}" var="brakeMaker">
                                <li><a href="/brakeMakerAdmin/${brakeMaker.id}">${brakeMaker.name}</a></li>
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
            <td><b>Розташування</b></td>
            <td><b>Діаметр ротора</b></td>
            <td><b>Вага ротора</b></td>
            <td><b>Матеріал гальм</b></td>
            <td><b>Вага гальм(без ротора,ручок та ін.</b></td>
            <td><b>Фіксація ротора</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${brakeDiscMechaniks}" var="brakeDiscMechanik">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${brakeDiscMechanik.id}" id="checkbox_${brakeDiscMechanik.id}"/></td>

                <td>${brakeDiscMechanik.name}</td>

                <c:choose>
                    <c:when test="${brakeDiscMechanik.location ne null}">
                        <td>${brakeDiscMechanik.location.local}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>


                <c:choose>
                    <c:when test="${brakeDiscMechanik.rotorDiam ne null}">
                        <td>${brakeDiscMechanik.rotorDiam.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeDiscMechanik.rotorWeight}</td>
                <td>${brakeDiscMechanik.materialBrake}</td>
                <td>${brakeDiscMechanik.brakeWeight}</td>
                <c:choose>
                    <c:when test="${brakeDiscMechanik.rotorFixType ne null}">
                        <td>${brakeDiscMechanik.rotorFixType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeDiscMechanik.color}</td>
                <td>${brakeDiscMechanik.description}</td>

                <td>${brakeDiscMechanik.price}</td>

                <c:choose>
                    <c:when test="${brakeDiscMechanik.maker ne null}">
                        <td>${brakeDiscMechanik.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${brakeDiscMechanik.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big>Ободні гальма</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul id="groupList2" class="nav navbar-nav">
                    <li><button type="button" id="add_brakeVBrake" class="btn btn-default navbar-btn">Додати ободні гальма</button></li>
                    <li><button type="button" id="add_brakeMakerVBrake" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_brakeVBrake" class="btn btn-default navbar-btn">Видалити гальма</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${brakeMakers}" var="brakeMaker">
                                <li><a href="/braleMakerAdmin/${brakeMaker.id}">${brakeMaker.name}</a></li>
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
            <td><b>Розташування</b></td>
            <td><b>Матеріал гальм</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${brakeVBrakes}" var="brakeVBrake">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${brakeVBrake.id}" id="checkbox_${brakeVBrake.id}"/></td>

                <td>${brakeVBrake.name}</td>

                <c:choose>
                    <c:when test="${brakeVBrake.location ne null}">
                        <td>${brakeVBrake.location.local}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${brakeVBrake.material}</td>
                <td>${brakeVBrake.color}</td>
                <td>${brakeVBrake.description}</td>
                <td>${brakeVBrake.price}</td>

                <c:choose>
                    <c:when test="${brakeVBrake.maker ne null}">
                        <td>${brakeVBrake.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${brakeVBrake.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big>Гальмівні ручки</big>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                <ul id="groupList3" class="nav navbar-nav">
                    <li><button type="button" id="add_brakeHandle" class="btn btn-default navbar-btn">Додати гальмівні ручки</button></li>
                    <li><button type="button" id="add_brakeMakerHandle" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_brakeHandle" class="btn btn-default navbar-btn">Видалити гальмівні ручки</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник<span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${brakeMakers}" var="brakeMaker">
                                <li><a href="/brakeMakerAdmin/${brakeMaker.id}">${brakeMaker.name}</a></li>
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
            <td><b>Розташування</b></td>
            <td><b>Сумісність з гальмами</b></td>
            <td><b>Матеріал ручки</b></td>
            <td><b>Матеріал корпусу</b></td>
            <td><b>Сумісність з діаметром керма</b></td>
            <td><b>Ширина ручки</b></td>
            <td><b>Вага ручки</b></td>
            <td><b>Колір</b></td>
            <td><b>Опис</b></td>
            <td><b>Ціна</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${brakeHandles}" var="brakeHandle">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${brakeHandle.id}" id="checkbox_${brakeHandle.id}"/></td>

                <td>${brakeHandle.name}</td>

                <c:choose>
                    <c:when test="${brakeHandle.brakeHandleLocation ne null}">
                        <td>${brakeHandle.brakeHandleLocation.local}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${brakeHandle.brakeHandleCompatibility ne null}">
                        <td>${brakeHandle.brakeHandleCompatibility.comp}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeHandle.materialHandle}</td>
                <td>${brakeHandle.materialCorp}</td>

                <c:choose>
                    <c:when test="${brakeHandle.handlebarDiameter ne null}">
                        <td>${brakeHandle.handlebarDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${brakeHandle.brakeHandleWide ne null}">
                        <td>${brakeHandle.brakeHandleWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${brakeHandle.weight}</td>
                <td>${brakeHandle.color}</td>
                <td>${brakeHandle.description}</td>
                <td>${brakeHandle.price}</td>

                <c:choose>
                    <c:when test="${brakeHandle.maker ne null}">
                        <td>${brakeHandle.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${brakeHandle.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_brakes?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/brakeMakerAdmin/${brakeMakerId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_brakeDiscHydr').click(function(){
        window.location.href='/admin/brakeDiscHydr_add_page';
    });

    $('#add_brakeDiscMech').click(function(){
        window.location.href='/admin/brakeDiscMech_add_page';
    });
    $('#add_brakeVBrake').click(function(){
        window.location.href='/admin/brakeVBrake_add_page';
    });
    $('#add_brakeHandle').click(function(){
        window.location.href='/admin/brakeHandle_add_page';
    });

    $('#add_brakeMakerDiscHydr').click(function(){
        window.location.href='/admin/brakeMaker_add_page';
    });

    $('#add_brakeMakerDiscMech').click(function(){
        window.location.href='/admin/brakeMaker_add_page';
    });

    $('#add_brakeMakerVBrake').click(function(){
        window.location.href='/admin/brakeMaker_add_page';
    });
    $('#add_brakeMakerHandle').click(function(){
        window.location.href='/admin/brakeMaker_add_page';
    });


    $('#delete_brakeDiscHydr').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/brakeDiscHydr/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_brakeDiscMech').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/brakeDiscMech/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_brakeVBrake').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/brakeVBrake/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_brakeHandle').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/brakeHandle/delete", data, function(data, status) {
            window.location.reload();
        });
    });


</script>
</body>
</html>