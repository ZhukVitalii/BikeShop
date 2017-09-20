<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New handlebar</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/handlebar/add" method="post">
        <h3>New handlebar</h3>
        <select class="btn btn-primary btn-select btn-select-light "  name="handlebarMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                <option value="${handlebarMaker.id}">${handlebarMaker.name}</option>
            </c:forEach>
        </select>
        <div class="numbers">
        <input class="form-control " type="number" name="article" placeholder="Артикул">
        </div>
        <input class="form-control " type="text" name="url" placeholder="URL">
        <input class="form-control " type="text" name="name" placeholder="назва керма">
        <select class="btn btn-primary btn-select btn-select-light "  name="bikeType">
            <option value="-1">Тип велосипеду</option>
            <c:forEach items="${bikeType}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>
        <input class="form-control " type="text" name="handlebarWide" placeholder="Ширина керма">
        <select class="btn btn-primary btn-select btn-select-light "  name="handlebarDiameter">
            <option value="-1">Діаметр керма</option>
            <c:forEach items="${handlebarDiameter}" var="handlebarDiameter">
                <option value="${handlebarDiameter.id}">${handlebarDiameter.diam}</option>
            </c:forEach>
        </select>
        <input class="form-control form-handlebarMaker" type="text" name="handlebarHeight" placeholder="Підйом керма">
        <input class="form-control " type="text" name="material" placeholder="Матеріал">
        <input class="form-control " type="text" name="weight" placeholder="вага">
        <input class="form-control " type="text" name="color" placeholder="колір">
        <div class="numbers">
        <input class="form-control"
               type="number"
               name="price"
               placeholder="ціна">
        </div>
        <input class="form-control " type="text" name="description" placeholder="опис керма">
        <input class="form-control " type="text" name="way" placeholder="зображення">
        <input type="submit" class="btn btn-primary" value="Add">
    </form>
</div>
<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>