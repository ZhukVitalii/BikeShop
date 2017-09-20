<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New winding</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/winding/add"
          method="post">

        <h3>New winding</h3>
        <select class="btn btn-primary btn-select btn-select-light"
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
               placeholder="назва обмотки">
        <br>
        <input class="form-control"
               type="text"
               name="length"
               placeholder="довжина">
        <br>
        <input class="form-control"
               type="text"
               name="wide"
               placeholder="ширина">
        <br>
        <input class="form-control"
               type="text"
               name="material"
               placeholder="матеріал">
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
            <div class="number-error">Доступний тільки ввід числових значень</div>
        </div>
        <br>
        <input class="form-control"
               type="text"
               name="description"
               placeholder="опис обмотки">
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