<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New tire</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>



<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/tire/add" method="post">
        <h3>New tire</h3>
        <select class="btn btn-primary btn-select btn-select-light" name="wheelMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${wheelMakers}" var="wheelMaker">
                <option value="${wheelMaker.id}">${wheelMaker.name}</option>
            </c:forEach>
        </select>


        <input class="form-control form-handlebarMaker" type="text" name="name" placeholder="назва">

        <select class=" btn btn-primary btn-select btn-select-light "  name="wheelsDiam">
            <option value="-1">Діаметр</option>
            <c:forEach items="${wheelsDiam}" var="wheelsDiam">
                <option value="${wheelsDiam.id}">${wheelsDiam.diam}</option>
            </c:forEach>
        </select>
        <br>

        <select class=" btn btn-primary btn-select btn-select-light "  name="tireType">
            <option value="-1">Тип</option>
            <c:forEach items="${tireType}" var="tireType">
                <option value="${tireType.id}">${tireType.type}</option>
            </c:forEach>
        </select>
        <br>

        <select class="btn btn-primary btn-select btn-select-light "  name="cordType">
            <option value="-1">Корд</option>
            <c:forEach items="${cordType}" var="cordType">
                <option value="${cordType.id}">${cordType.type}</option>
            </c:forEach>
        </select>
        <br>

        <select class="btn btn-primary btn-select btn-select-light "  name="tireWide">
            <option value="-1">Ширина покришки</option>
            <c:forEach items="${tireWide}" var="tireWide">
                <option value="${tireWide.id}">${tireWide.wide}</option>
            </c:forEach>
        </select>

        <input class="form-control form-forkMaker" type="text" name="color" placeholder="Колір">
        <input class="form-control form-forkMaker" type="text" name="description" placeholder="Опис колеса">
        <input class="form-control form-forkMaker" type="text" name="price" placeholder="Ціна">
        <input class="form-control form-forkMaker" type="text" name="way" placeholder="Зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>