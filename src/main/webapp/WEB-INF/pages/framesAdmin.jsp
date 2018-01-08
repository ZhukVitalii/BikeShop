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
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_frame" class="btn btn-default navbar-btn">Додати раму</button></li>
                    <li><button type="button" id="add_frameMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_frame" class="btn btn-default navbar-btn">Видалити раму</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${frameMakers}" var="frameMaker">
                                <li><a href="/FrameMaker/${frameMaker.id}">${frameMaker.name}</a></li>
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
            <td><b>Розмір рами</b></td>
            <td><b>Матеріал рами</b></td>
            <td><b>Ширина каретки</b></td>
            <td><b>Тип рульової</b></td>
            <td><b>Діаметр рульової</b></td>
            <td><b>Діаметр підсидільної труби</b></td>
            <td><b>Сумісність з типом гальм</b></td>
            <td><b>Кріплення багажника</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${frames}" var="frame">

            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${frame.id}" id="checkbox_${frame.id}"/></td>


                <td>${frame.name}</td>
                <c:choose>
                    <c:when test="${frame.bikeType ne null}">
                        <td>${frame.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.frameSize ne null}">
                        <td>${frame.frameSize.size}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frame.material}</td>
                <c:choose>
                    <c:when test="${frame.bracketWide ne null}">
                        <td>${frame.bracketWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.headsetType ne null}">
                        <td>${frame.headsetType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.tubeDiameter ne null}">
                        <td>${frame.tubeDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.underSaddleTube ne null}">
                        <td>${frame.underSaddleTube.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.brakesType ne null}">
                        <td>${frame.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.trunkBinding ne null}">
                        <td>${frame.trunkBinding.trunk}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frame.weight}</td>
                <td>${frame.color}</td>
                <td>${frame.price}</td>
                <td>${frame.description}</td>
                <c:choose>
                    <c:when test="${frame.maker ne null}">
                        <td>${frame.maker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${frame.way}"/></td>
            </tr>
        </c:forEach>
    </table>
    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_framesAdmin?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/FrameMaker/${groupId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();
    $('#main_page').click(function(){
        window.location.href='/';
    });

    $('#add_frame').click(function(){
        window.location.href='/admin/frame_add_page';
    });

    $('#add_frameMaker').click(function(){
        window.location.href='/admin/frameMaker_add_page';
    });

    $('#delete_frame').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/admin/frame/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>