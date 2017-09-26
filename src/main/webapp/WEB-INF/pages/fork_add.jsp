<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New fork</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="resources/js/my.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/fork/add"
          method="post">

        <h3>New fork</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="forkMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${forkMakers}" var="forkMaker">
                <option value="${forkMaker.id}">${forkMaker.name}</option>
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
               placeholder="назва вилки">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="bikeType">
            <option value="-1">Тип вилки</option>
            <c:forEach items="${bikeTypes}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="wheelsDiam">
            <option value="-1">Розмір колес</option>
            <c:forEach items="${wheelsDiams}" var="wheelsDiam">
                <option value="${wheelsDiam.id}">${wheelsDiam.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="tubeDiameter">
            <option value="-1">Діаметр штока</option>
            <c:forEach items="${tubeDiameters}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="stTubeLength"
               placeholder="Довжина штока">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="brakesType">
            <option value="-1">тип гальм</option>
            <c:forEach items="${brakesTypes}" var="brakesType">
                <option value="${brakesType.id}">${brakesType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="forkMaterial"
               placeholder="Матеріал">
        <br>
        <input class="form-control"
               type="text"
               name="weight"
               placeholder="вага">
        <br>
        <input class="form-control"
               type="text"
               name="color"
               placeholder="колір">
        <br>
        <input class="form-control"
               type="text"
               name="move"
               placeholder="хід вилки">
        <div class="numbers">
        <br>
        <input class="form-control"
               type="number"
               name="price"
               placeholder="ціна">
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="опис вилки">
        <br>
        <input class="form-control"
               type="text"
               name="way"
               placeholder="фото">
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