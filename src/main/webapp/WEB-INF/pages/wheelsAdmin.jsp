<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Wheels</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>

<body>

<div class="container">

    <h3><img height="200" width="1000" src="<c:url value="/static/panorama.png"/>"/><a href="/"></a></h3>

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
                    <c:when test="${wheel.wheelMaker ne null}">
                        <td>${wheel.wheelMaker.name}</td>
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
                    <c:when test="${rim.wheelMaker ne null}">
                        <td>${rim.wheelMaker.name}</td>
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
                    <c:when test="${frontHub.wheelMaker ne null}">
                        <td>${frontHub.wheelMaker.name}</td>
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
                    <c:when test="${backHub.wheelMaker ne null}">
                        <td>${backHub.wheelMaker.name}</td>
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
                    <c:when test="${spoke.wheelMaker ne null}">
                        <td>${spoke.wheelMaker.name}</td>
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
                    <c:when test="${tire.wheelMaker ne null}">
                        <td>${tire.wheelMaker.name}</td>
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
        window.location.href='/wheel_add_page';
    });

    $('#add_spoke').click(function(){
        window.location.href='/spoke_add_page';
    });
    $('#add_rim').click(function(){
        window.location.href='/rim_add_page';
    });
    $('#add_frontHub').click(function(){
        window.location.href='/frontHub_add_page';
    });
    $('#add_backHub').click(function(){
        window.location.href='/backHub_add_page';
    });
    $('#add_tire').click(function(){
        window.location.href='/tire_add_page';
    });





    $('#add_wheelMaker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });

    $('#add_spokeMaker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });

    $('#add_rimMaker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });
    $('#add_frontHubMaker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });

    $('#add_backHubMaker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });
    $('#add_tireMakeraker').click(function(){
        window.location.href='/wheelMaker_add_page';
    });

    $('#delete_wheel').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/wheel/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_rim').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/rim/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_spoke').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/spoke/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_frontHub').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/frontHub/delete", data, function(data, status) {
            window.location.reload();
        });
    });

    $('#delete_backHub').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/backHub/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_tire').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/tire/delete", data, function(data, status) {
            window.location.reload();
        });
    });

</script>
</body>
</html>