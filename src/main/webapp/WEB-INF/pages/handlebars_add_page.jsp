<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New handlebar</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="/resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal"
          action="/admin/handlebar/add"
          method="post">
        <h3>New handlebar</h3>
        <select class="btn btn-primary btn-select btn-select-light "
                name="handlebarMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                <option value="${handlebarMaker.id}">${handlebarMaker.name}</option>
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
               placeholder="назва керма">
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="bikeType">
            <option value="-1">Тип велосипеду</option>
            <c:forEach items="${bikeType}"
                       var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="handlebarWide"
               placeholder="Ширина керма">
        <br>
        <select class="btn btn-primary btn-select btn-select-light "
                name="handlebarDiameter">
            <option value="-1">Діаметр керма</option>
            <c:forEach items="${handlebarDiameter}" var="handlebarDiameter">
                <option value="${handlebarDiameter.id}">${handlebarDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="handlebarHeight"
               placeholder="Підйом керма">
        <br>
        <input class="form-control"
               type="text"
               name="material"
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
        <div class="numbers">
        <input class="form-control"
               type="number"
               name="price"
               placeholder="ціна">
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="опис керма">
        <br>
        <input class="form-control"
               type="text" name="way"
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