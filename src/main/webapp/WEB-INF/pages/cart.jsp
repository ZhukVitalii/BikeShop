
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Cart</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <link href="resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
    <!-- jQuery (Bootstrap's JavaScript plugins) -->
    <script src="resources/js/jquery.min.js"></script>
    <!-- Custom Theme files -->
    <link href="resources/css/form.css" rel="stylesheet" type="text/css" media="all" />
    <link href="resources/css/style.css" rel="stylesheet" type="text/css" media="all" />
    <!-- Custom Theme files -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="keywords" content="bike Shop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,
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
<!--banner-->
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
<!--/banner-->
<div class="cart">
    <div class="container">
        <div class="cart-top">
            <a href="/"><< home</a>
        </div>

        <div class="col-md-9 cart-items">
            <h2>${total} <label> товарів в корзині</label></h2>
            <script>$(document).ready(function(c) {
                $('.close1').on('click', function(c){
                    $('.cart-header').fadeOut('slow', function(c){
                        $('.cart-header').remove();
                    });
                });
            });
            </script>
<!-- Frames----------------------------------------------------------------------------------- -->
<c:forEach items="${frames}" var="frame">
            <div class="cart-header">
                <div class="close1"> </div>
                <div class="cart-sec">
                    <div class="cart-item cyc">
                        <img src="${frame.way}"/>
                    </div>
                    <div class="cart-item-info">
                        <div class="link-to-one">
                            <a href="<c:url value="/frame/${frame.url}"/>"
                               title="Перейти до <c:out value="${frame.name}"/>">
                                <h3>${frame.name}</h3>
                            </a>
                        </div>
                        <h4></h4>
                        <p>${frame.price}<label>грн</label><a href="#"></a></p>
                        <p class="qty">Qty ::</p>
                        <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                    </div>
                    <div class="clearfix"></div>
                </div>
            </div>
            <script>$(document).ready(function(c) {
                $('.close2').on('click', function(c){
                    $('.cart-header2').fadeOut('slow', function(c){
                        $('.cart-header2').remove();
                    });
                });
            });
            </script>
    </c:forEach>
<!-- Forks ----------------------------------------------------------------------------------- -->
            <c:forEach items="${forks}" var="fork">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${fork.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/fork/${fork.url}"/>"
                                   title="Перейти до <c:out value="${fork.name}"/>">
                                    <h3>${fork.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${fork.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
<!-- Handlebars Components ----------------------------------------------------------------------------------- -->
            <c:forEach items="${handlebars}" var="handlebar">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${handlebar.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/handlebar/${handlebar.url}"/>"
                                   title="Перейти до <c:out value="${handlebar.name}"/>">
                                    <h3>${handlebar.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${handlebar.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${stems}" var="stem">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${stem.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/stem/${stem.url}"/>"
                                   title="Перейти до <c:out value="${stem.name}"/>">
                                    <h3>${stem.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${stem.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${grips}" var="grips">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${grips.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/grips/${grips.url}"/>"
                                   title="Перейти до <c:out value="${grips.name}"/>">
                                    <h3>${grips.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${grips.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${headsets}" var="headset">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${headset.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/headset/${headset.url}"/>"
                                   title="Перейти до <c:out value="${headset.name}"/>">
                                    <h3>${headset.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${headset.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${windings}" var="winding">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${winding.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/winding/${winding.url}"/>"
                                   title="Перейти до <c:out value="${winding.name}"/>">
                                    <h3>${winding.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${winding.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
<!-- Brakes Components ----------------------------------------------------------------------------------- -->
            <c:forEach items="${brakeHandles}" var="brakeHandle">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${brakeHandle.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/brakeHandle/${brakeHandle.url}"/>"
                                   title="Перейти до <c:out value="${brakeHandle.name}"/>">
                                    <h3>${brakeHandle.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${brakeHandle.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${brakeDiscHydraulics}" var="brakeDiscHydraulic">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${brakeDiscHydraulic.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/brakeDiscHydraulic/${brakeDiscHydraulic.url}"/>"
                                   title="Перейти до <c:out value="${brakeDiscHydraulic.name}"/>">
                                    <h3>${brakeDiscHydraulic.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${brakeDiscHydraulic.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${brakeDiscMechaniks}" var="brakeDiscMechanik">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${brakeDiscMechanik.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/brakeDiscMechanik/${brakeDiscMechanik.url}"/>"
                                   title="Перейти до <c:out value="${brakeDiscMechanik.name}"/>">
                                    <h3>${brakeDiscMechanik.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${brakeDiscMechanik.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${brakeVBrakes}" var="brakeVBrake">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${brakeVBrake.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/brakeVBrake/${brakeVBrake.url}"/>"
                                   title="Перейти до <c:out value="${brakeVBrake.name}"/>">
                                    <h3>${brakeVBrake.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${brakeVBrake.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
<!-- Wheels Components ----------------------------------------------------------------------------------- -->
            <c:forEach items="${wheels}" var="wheel">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${wheel.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/wheel/${wheel.url}"/>"
                                   title="Перейти до <c:out value="${wheel.name}"/>">
                                    <h3>${wheel.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${wheel.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${tires}" var="tire">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${tire.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/tire/${tire.url}"/>"
                                   title="Перейти до <c:out value="${tire.name}"/>">
                                    <h3>${tire.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${tire.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${spokes}" var="spoke">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${spoke.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/spoke/${spoke.url}"/>"
                                   title="Перейти до <c:out value="${spoke.name}"/>">
                                    <h3>${spoke.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${spoke.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${rims}" var="rim">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${rim.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/rim/${rim.url}"/>"
                                   title="Перейти до <c:out value="${rim.name}"/>">
                                    <h3>${rim.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${rim.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${frontHubs}" var="frontHub">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${frontHub.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/frontHub/${frontHub.url}"/>"
                                   title="Перейти до <c:out value="${frontHub.name}"/>">
                                    <h3>${frontHub.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${frontHub.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${backHubs}" var="backHub">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${backHub.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/backHub/${backHub.url}"/>"
                                   title="Перейти до <c:out value="${backHub.name}"/>">
                                    <h3>${backHub.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${backHub.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
<!--Transmission ----------------------------------------------------------------------------------- -->
            <c:forEach items="${backDerailleurs}" var="backDerailleur">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${backDerailleur.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/backDerailleur/${backDerailleur.url}"/>"
                                   title="Перейти до <c:out value="${backDerailleur.name}"/>">
                                    <h3>${backDerailleur.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${backDerailleur.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${backGearKass}" var="backGearKas">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${backGearKas.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/backGearKas/${backGearKas.url}"/>"
                                   title="Перейти до <c:out value="${backGearKas.name}"/>">
                                    <h3>${backGearKas.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${backGearKas.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${backGearTrs}" var="backGearTr">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${backGearTr.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/backGearTr/${backGearTr.url}"/>"
                                   title="Перейти до <c:out value="${backGearTr.name}"/>">
                                    <h3>${backGearTr.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${backGearTr.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${brackets}" var="bracket">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${bracket.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/bracket/${bracket.url}"/>"
                                   title="Перейти до <c:out value="${bracket.name}"/>">
                                    <h3>${bracket.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${bracket.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${chains}" var="chain">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${chain.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/chain/${chain.url}"/>"
                                   title="Перейти до <c:out value="${chain.name}"/>">
                                    <h3>${chain.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${chain.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${cranks}" var="crank">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${crank.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/crank/${crank.url}"/>"
                                   title="Перейти до <c:out value="${crank.name}"/>">
                                    <h3>${crank.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${crank.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${frontDerailleurs}" var="frontDerailleur">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${frontDerailleur.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/frontDerailleur/${frontDerailleur.url}"/>"
                                   title="Перейти до <c:out value="${frontDerailleur.name}"/>">
                                    <h3>${frontDerailleur.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${frontDerailleur.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
            <c:forEach items="${pedals}" var="pedal">
                <div class="cart-header">
                    <div class="close1"> </div>
                    <div class="cart-sec">
                        <div class="cart-item cyc">
                            <img src="${pedal.way}"/>
                        </div>
                        <div class="cart-item-info">
                            <div class="link-to-one">
                                <a href="<c:url value="/pedal/${pedal.url}"/>"
                                   title="Перейти до <c:out value="${pedal.name}"/>">
                                    <h3>${pedal.name}</h3>
                                </a>
                            </div>
                            <h4></h4>
                            <p>${pedal.price}<label>грн</label><a href="#"></a></p>
                            <p class="qty">Qty ::</p>
                            <input min="1" type="number" id="quantity" name="quantity" value="1" class="form-control input-small">
                        </div>
                        <div class="clearfix"></div>
                    </div>
                </div>
                <script>$(document).ready(function(c) {
                    $('.close2').on('click', function(c){
                        $('.cart-header2').fadeOut('slow', function(c){
                            $('.cart-header2').remove();
                        });
                    });
                });
                </script>
            </c:forEach>
        </div>
        <div class="col-md-3 cart-total">
            <h4 class="last-price">Загальна сума</h4>
            <div class="clearfix"></div>
            <span class="total final">${totalPrice}</span>
            <div class="clearfix"></div>
            <a class="order" href="#">Оформити замовлення</a>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/"><img src="resources/images/logo.png"
                             alt="logo"
                             width="60"
                             height="62"/>
            </a>
        </div>
        <div class="ftr-menu">
            <ul>
                <li><a href="#chooseBike">ЗІБРАТИ ВЕЛОСИПЕД</a></li>
                <li><a href="#cate">КОМПОНЕНТИ</a></li>
                <li><a href="#">ДОДАТКОВІ КОМПЛЕКТУЮЧІ</a></li>
            </ul>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
</body>
</html>

