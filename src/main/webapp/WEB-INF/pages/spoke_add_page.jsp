<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New wheel</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/spoke/add" method="post">
        <h3>New spoke</h3>
        <select class="btn btn-primary btn-select btn-select-light" name="wheelMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${wheelMakers}" var="wheelMaker">
                <option value="${wheelMaker.id}">${wheelMaker.name}</option>
            </c:forEach>
        </select>
        <input class="form-control " type="text" name="name" placeholder="Назва">
        <input class="form-control " type="text" name="length" placeholder="Довжина спиць">
        <input class="form-control " type="text" name="diameter" placeholder="Діаметер спиць">
        <input class="form-control " type="text" name="material" placeholder="Матеріал">
        <br>
        <input class="form-control " type="text" name="color" placeholder="Колір">
        <input class="form-control " type="text" name="description" placeholder="Опис">
        <input class="form-control " type="text" name="price" placeholder="Ціна">
        <input class="form-control form-forkMaker" type="text" name="way" placeholder="зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>