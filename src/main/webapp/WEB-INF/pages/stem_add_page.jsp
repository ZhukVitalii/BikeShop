<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New stem</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/stem/add" method="post">
        <h3>New stem</h3>
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
               placeholder="назва">
        <br>
        <input class="form-control"
               type="text"
               name="angle"
               placeholder="нахил">
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="handlebarDiameter">
            <option value="-1">Діаметр керма</option>
            <c:forEach items="${handlebarDiameter}" var="handlebarDiameter">
                <option value="${handlebarDiameter.id}">${handlebarDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="tubeDiameter">
            <option value="-1">Діаметр штока</option>
            <c:forEach items="${tubeDiameter}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="material"
               placeholder="матеріал">
        <br>
        <input class="form-control"
               type="text"
               name="length"
               placeholder="довжина">
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
               placeholder="опис ">
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