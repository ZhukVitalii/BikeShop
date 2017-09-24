<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New crank</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/crank/add"
          method="post">
        <h3>Додати шатуни</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="transmissionMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${transmissionMakers}"
                       var="transmissionMaker">
                <option value="${transmissionMaker.id}">${transmissionMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <div class="numbers">
            <input class="form-control"
                   type="number"
                   name="article"
                   placeholder="Артикул">
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="url"
               placeholder="url">
        <br>
        <input class="form-control"
               type="text"
               name="name"
               placeholder="Назва">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="bikeType">
            <option value="-1">Тип велосипеду</option>
            <c:forEach items="${bikeType}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="backSprocketNumber">
            <option value="-1">Сумісність з кількістю задніх зірок</option>
            <c:forEach items="${backSprocketNumber}"
                       var="backSprocketNumber">
                <option value="${backSprocketNumber.id}">${backSprocketNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frontSprocketNumber">
            <option value="-1">Кількість зірок</option>
            <c:forEach items="${frontSprocketNumber}"
                       var="frontSprocketNumber">
                <option value="${frontSprocketNumber.id}">${frontSprocketNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frontSprocketSize">
            <option value="-1">Набір зірок</option>
            <c:forEach items="${frontSprocketSize}"
                       var="frontSprocketSize">
                <option value="${frontSprocketSize.id}">${frontSprocketSize.size}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frontSprocketMax">
            <option value="-1">Найбільша зірка</option>
            <c:forEach items="${frontSprocketMax}"
                       var="frontSprocketMax">
                <option value="${frontSprocketMax.id}">${frontSprocketMax.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frontSprocketMin">
            <option value="-1">Найменша зірка</option>
            <c:forEach items="${frontSprocketMin}"
                       var="frontSprocketMin">
                <option value="${frontSprocketMin.id}">${frontSprocketMin.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="crankLength">
            <option value="-1">Довжина шатуна</option>
            <c:forEach items="${crankLength}"
                       var="crankLength">
                <option value="${crankLength.id}">${crankLength.length}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="sprocketMaterial"
               placeholder="Матеріал зірок">
        <br>
        <input class="form-control"
               type="text"
               name="crankMaterial"
               placeholder="Матеріал шатунів">
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="bracketType">
            <option value="-1">Тип каретки</option>
            <c:forEach items="${bracketType}"
                       var="bracketType">
                <option value="${bracketType.id}">${bracketType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="color"
               placeholder="Колір">
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="Опис">
        <br>
        <div class="numbers">
            <input class="form-control"
                   type="number"
                   name="price"
                   placeholder="ціна">
            <div class="number-error">Доступний тільки ввід числових значень</div>
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="way"
               placeholder="зображення">
        <br>
        <input type="submit"
               class="btn btn-primary"
               value="Add">
    </form>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>