<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New bracket</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/bracket/add" method="post">
        <h3>Додати каретку</h3>
        <select class="btn btn-primary btn-select btn-select-light" name="transmissionMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${transmissionMakers}" var="transmissionMaker">
                <option value="${transmissionMaker.id}">${transmissionMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="name" placeholder="Назва">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="bracketAxisLength">
            <option value="-1">Довжина осі</option>
            <c:forEach items="${bracketAxisLength}" var="bracketAxisLength">
                <option value="${bracketAxisLength.id}">${bracketAxisLength.length}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="bracketWide">
            <option value="-1">Діаметр каретки</option>
            <c:forEach items="${bracketWide}" var="bracketWide">
                <option value="${bracketWide.id}">${bracketWide.wide}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="bracketType">
            <option value="-1">Тип каретки</option>
            <c:forEach items="${bracketType}" var="bracketType">
                <option value="${bracketType.id}">${bracketType.type}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="bearingType">
            <option value="-1">Тип підшипників</option>
            <c:forEach items="${bearingType}" var="bearingType">
                <option value="${bearingType.id}">${bearingType.type}</option>
            </c:forEach>
        </select>
        <select class="btn btn-primary btn-select btn-select-light" name="carvingType">
            <option value="-1">Тип різьби</option>
            <c:forEach items="${carvingType}" var="carvingType">
                <option value="${carvingType.id}">${carvingType.type}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="axisMaterial" placeholder="Матеріал осі">
        <br>
        <input class="form-control " type="text" name="color" placeholder="Колір">
        <br>
        <input class="form-control " type="text" name="description" placeholder="Опис">
        <br>
        <input class="form-control " type="text" name="price" placeholder="Ціна">
        <br>
        <input class="form-control " type="text" name="way" placeholder="зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>