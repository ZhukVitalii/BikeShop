
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Bike Shop a Ecommerce Category Flat Bootstarp Responsive Website Template| Cart :: w3layouts</title>
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
                    <li class="dropdown1"><a href="bicycles.html">BICYCLES</a>
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
                    <li class="dropdown1"><a href="404.html">EXTRAS</a>
                        <ul class="dropdown2">
                            <li><a href="404.html">CLASSIC BELL</a></li>
                            <li><a href="404.html">BOTTLE CAGE</a></li>
                            <li><a href="404.html">TRUCK GRIP</a></li>
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
            <h2>My Shopping Bag (2)</h2>
            <script>$(document).ready(function(c) {
                $('.close1').on('click', function(c){
                    $('.cart-header').fadeOut('slow', function(c){
                        $('.cart-header').remove();
                    });
                });
            });
            </script>
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
                    <div class="delivery">
                        <p>Service Charges:: Rs.100.00</p>
                        <span>Delivered in 2-3 bussiness days</span>
                        <div class="clearfix"></div>
                    </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
                        <div class="delivery">
                            <p>Service Charges:: Rs.100.00</p>
                            <span>Delivered in 2-3 bussiness days</span>
                            <div class="clearfix"></div>
                        </div>
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
            <a class="continue" href="#">Continue to basket</a>
            <div class="price-details">
                <h3>Price Details</h3>
                <span>Total</span>
                <span class="total">6200.00</span>
                <span>Discount</span>
                <span class="total">---</span>
                <span>Delivery Charges</span>
                <span class="total">150.00</span>
                <div class="clearfix"></div>
            </div>
            <h4 class="last-price">TOTAL</h4>
            <span class="total final">6350.00</span>
            <div class="clearfix"></div>
            <a class="order" href="#">Place Order</a>
            <div class="total-item">
                <h3>OPTIONS</h3>
                <h4>COUPONS</h4>
                <a class="cpns" href="#">Apply Coupons</a>
                <p><a href="#">Log In</a> to use accounts - linked coupons</p>
            </div>
        </div>
    </div>
</div>
<div class="footer">
    <div class="container wrap">
        <div class="logo2">
            <a href="/"><img src="resources/images/logo2.png" alt=""/></a>
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
</body>
</html>

