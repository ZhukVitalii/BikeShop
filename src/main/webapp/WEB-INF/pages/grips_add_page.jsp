<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New grips</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/grips/add" method="post">
        <h3>New grips</h3>
        <select class="selectpicker form-control form-handlebarMaker" name="handlebarMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                <option value="${handlebarMaker.id}">${handlebarMaker.name}</option>
            </c:forEach>
        </select>
        <input class="form-control form-handlebarMaker" type="text" name="name" placeholder="назва обмотки">
        <input class="form-control form-forkMaker" type="text" name="length" placeholder="довжина">
        <input class="form-control form-forkMaker" type="text" name="weight" placeholder="вага">
        <input class="form-control form-forkMaker" type="text" name="material" placeholder="матеріал">
        <input class="form-control form-forkMaker" type="text" name="color" placeholder="колір">
        <input class="form-control form-forkMaker" type="text" name="price" placeholder="ціна">
        <input class="form-control form-forkMaker" type="text" name="description" placeholder="опис ">
        <input class="form-control form-forkMaker" type="text" name="way" placeholder="зображення">


        <input type="submit" class="btn btn-primary" value="Add">
    </form>

</div>

<script>
    $('.selectpicker').selectpicker();
</script>
</body>
</html>