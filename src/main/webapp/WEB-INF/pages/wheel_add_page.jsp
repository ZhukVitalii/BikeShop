<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New wheel</title>
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
          action="/admin/wheel/add"
          method="post">
        <h3>New wheel</h3>
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
                name="wheelsDiam">
            <option value="-1">Діаметр</option>
            <c:forEach items="${wheelsDiam}" var="wheelsDiam">
                <option value="${wheelsDiam.id}">${wheelsDiam.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class=" btn btn-primary btn-select btn-select-light "
                name="bikeType">
            <option value="-1">Тип</option>
            <c:forEach items="${bikeType}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
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
                name="spokeNumber">
            <option value="-1">Кількість спиць</option>
            <c:forEach items="${spokeNumber}" var="spokeNumber">
                <option value="${spokeNumber.id}">${spokeNumber.number}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="rimName"
               placeholder="Обод">
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="rimWide">
            <option value="-1">Ширина обода</option>
            <c:forEach items="${rimWide}" var="rimWide">
                <option value="${rimWide.id}">${rimWide.wide}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="rimDescription"
               placeholder="Опис обода">
        <br>
        <input class="form-control"
               type="text"
               name="hubName"
               placeholder="втулка">
        <br>
        <input class="form-control"
               type="text"
               name="hubDescription"
               placeholder="Опис втулки">
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="Опис колеса">
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