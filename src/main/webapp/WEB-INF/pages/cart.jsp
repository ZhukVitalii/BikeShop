
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
    <script src="resources/js/my.js"></script>
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
    <script src="resources/js/ajax.js" type="text/javascript"></script>
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
            <h2 id="total-number">${total} <label> товарів в корзині</label></h2>

            <!----------------------------------------------------------------------->
            <c:forEach items="${objects}" var="products">
                <c:forEach items="${products}" var="product">
                    <div class="cart-header">
                        <div class="close1">
                            <button type="button"
                                    class="delete-from-cart"
                                    onclick="deleteFromCart('${product.getClass().getSimpleName()}',${product.article})">
                                <!--
                                onclick="deleteFromCart('/cartDel${product.getClass().getSimpleName()}/${product.article}',${product.article},${product.price} )"
                                 -->

                            </button>
                        </div>
                        <div class="cart-sec">
                            <div class="cart-item cyc">
                                <img src="${product.way}"/>
                            </div>
                            <div class="cart-item-info">
                                <div class="link-to-one">
                                    <a href="<c:url value="/${product.getClass().getSimpleName()}/${product.url}"/>"
                                       title="Перейти до <c:out value="${product.name}"/>">
                                        <h3>${product.name}</h3>
                                    </a>
                                </div>
                                <h4></h4>
                                <p>${product.price} <label> грн</label><a href="#"></a></p>
                                <p class="qty">Кількість ::</p>
                                <p id="${product.article}" class="form-control input-small" >
                                        ${productsNumber.get(product.article)}
                                </p>
                                <button type="button"
                                        class="add-number"
                                        onclick="add('/upPrice/${product.price}', ${product.price},${product.article})">
                                </button>
                                <button type="button"
                                        class="remove-number"
                                        onclick="remove('/downPrice/${product.price}',${product.price},${product.article})">
                                </button>
                            </div>
                            <div class="clearfix"></div>
                        </div>
                    </div>
                </c:forEach>
            </c:forEach>
        </div>
        <div class="col-md-3 cart-total">
            <h4 class="last-price">Загальна сума</h4>
            <div class="clearfix"></div>
            <span id="total-price" class="total final">${totalPrice} грн</span>
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

