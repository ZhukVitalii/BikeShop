<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
    <title>New frame</title>
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
          action="/frame/add"
          method="post">
        <h3>Додати раму</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frameMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${frameMakers}" var="frameMaker">
                <option value="${frameMaker.id}">${frameMaker.name}</option>
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
            <c:forEach items="${bikeTypes}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="frameSize">
            <option value="-1">Розмір рами</option>
            <c:forEach items="${frameSizes}" var="frameSize">
                <option value="${frameSize.id}">${frameSize.size}</option>
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
        <input class="form-control"
               type="text"
               name="material"
               placeholder="Матеріал">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="bracketWide">
            <option value="-1">Ширина каретки</option>
            <c:forEach items="${bracketWides}" var="bracketWide">
                <option value="${bracketWide.id}">${bracketWide.wide}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="headsetType">
            <option value="-1">Тип рульової</option>
            <c:forEach items="${headsetTypes}" var="headsetType">
                <option value="${headsetType.id}">${headsetType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="tubeDiameter">
            <option value="-1">Діаметр рульової</option>
            <c:forEach items="${tubeDiameters}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="underSaddleTube">
            <option value="-1">Діаметр підсидільної труби</option>
            <c:forEach items="${underSaddleTubes}" var="underSaddleTube">
                <option value="${underSaddleTube.id}">${underSaddleTube.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="brakesType">
            <option value="-1">Тип гальм</option>
            <c:forEach items="${brakesTypes}" var="brakesType">
                <option value="${brakesType.id}">${brakesType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="trunkBinding">
            <option value="-1">Кріплення багажника</option>
            <c:forEach items="${trunkBindings}" var="trunkBinding">
                <option value="${trunkBinding.id}">${trunkBinding.trunk}</option>
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
               type="text" name="way"
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