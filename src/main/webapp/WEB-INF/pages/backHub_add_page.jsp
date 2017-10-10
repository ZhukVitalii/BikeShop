<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New backHub</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="/resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/admin/backHub/add"
          method="post">
        <h3>New backHub</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="wheelMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${wheelMakers}" var="wheelMaker">
                <option value="${wheelMaker.id}">${wheelMaker.name}</option>
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
               placeholder="назва">
        <br>
        <select class=" btn btn-primary btn-select btn-select-light "
                name="hubFixType">
            <option value="-1">Кріплення втулки</option>
            <c:forEach items="${hubFixType}" var="hubFixType">
                <option value="${hubFixType.id}">${hubFixType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class=" btn btn-primary btn-select btn-select-light "
                name="bearingType">
            <option value="-1">Тип підшипника</option>
            <c:forEach items="${bearingType}" var="bearingType">
                <option value="${bearingType.id}">${bearingType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control "
               type="text"
               name="material"
               placeholder="матеріал">
        <br>
        <select class=" btn btn-primary btn-select btn-select-light "
                name="axisLength">
            <option value="-1">Довжина осі</option>
            <c:forEach items="${axisLength}" var="axisLength">
                <option value="${axisLength.id}">${axisLength.length}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class=" btn btn-primary btn-select btn-select-light "
                name="axisDiam">
            <option value="-1">Діаметер осі</option>
            <c:forEach items="${axisDiam}" var="axisDiam">
                <option value="${axisDiam.id}">${axisDiam.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="brakesType">
            <option value="-1">Тип гальм</option>
            <c:forEach items="${brakesType}" var="brakesType">
                <option value="${brakesType.id}">${brakesType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="rotorFixType">
            <option value="-1">Кріплення ротора</option>
            <c:forEach items="${rotorFixType}" var="rotorFixType">
                <option value="${rotorFixType.id}">${rotorFixType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="spokeNumber">
            <option value="-1">Кількість спиць</option>
            <c:forEach items="${spokeNumber}" var="spokeNumber">
                <option value="${spokeNumber.id}">${spokeNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="backSprocketType">
            <option value="-1">Сумісність з типом передачі</option>
            <c:forEach items="${backSprocketType}" var="backSprocketTyper">
                <option value="${backSprocketType.id}">${backSprocketType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="backSprocketNumber">
            <option value="-1">Сумісність з кількістю передачі</option>
            <c:forEach items="${backSprocketNumber}" var="backSprocketNumber">
                <option value="${backSprocketNumber.id}">${backSprocketNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="weight"
               placeholder="Вага">
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
               placeholder="Зображення">
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