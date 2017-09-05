<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>New fork</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/fork/add" method="post">
        <h3>New fork</h3>
        <select class="selectpicker form-control form-forkMaker" name="forkMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${forkMakers}" var="forkMaker">
                <option value="${forkMaker.id}">${forkMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="article" placeholder="Артикул">
        <br>
        <br>
        <input class="form-control " type="text" name="url" placeholder="url">
        <br>
        <input class="form-control form-forkMaker" type="text" name="name" placeholder="назва вилки">
        <select class="selectpicker form-control form-frame" name="bikeType">
            <option value="-1">Тип вилки</option>
            <c:forEach items="${bikeTypes}" var="bikeType">
                <option value="${bikeType.id}">${bikeType.type}</option>
            </c:forEach>
        </select>

        <select class="selectpicker form-control form-frame" name="wheelsDiam">
            <option value="-1">Розмір колес</option>
            <c:forEach items="${wheelsDiams}" var="wheelsDiam">
                <option value="${wheelsDiam.id}">${wheelsDiam.diam}</option>
            </c:forEach>
        </select>


        <select class="selectpicker form-control form-frame" name="tubeDiameter">
            <option value="-1">Діаметр штока</option>
            <c:forEach items="${tubeDiameters}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>

        <input class="form-control form-forkMaker" type="text" name="stTubeLength" placeholder="довжина штока">

        <select class="selectpicker form-control form-frame" name="brakesType">
            <option value="-1">тип гальм</option>
            <c:forEach items="${brakesTypes}" var="brakesType">
                <option value="${brakesType.id}">${brakesType.type}</option>
            </c:forEach>
        </select>

        <input class="form-control form-forkMaker" type="text" name="forkMaterial" placeholder="Матеріал">
        <input class="form-control form-forkMaker" type="text" name="weight" placeholder="вага">
        <input class="form-control form-forkMaker" type="text" name="color" placeholder="колір">
        <input class="form-control form-forkMaker" type="text" name="move" placeholder="хід вилки">
        <input class="form-control form-forkMaker" type="text" name="price" placeholder="ціна">
        <input class="form-control form-forkMaker" type="text" name="description" placeholder="опис вилки">
        <input class="form-control form-forkMaker" type="text" name="way" placeholder="фото">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>