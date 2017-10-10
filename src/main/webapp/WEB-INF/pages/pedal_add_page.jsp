<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New front pedals</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="/resources/css/my.css"  type="text/css" media="all" />
    <script src="/resources/js/my.js"></script>
</head>
<body>
<div class="container">
    <form role="form"
          class="form-horizontal"
          action="/admin/pedal/add"
          method="post">
        <h3>Додати педалі</h3>
        <select class="btn btn-primary btn-select btn-select-light"
                name="transmissionMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${transmissionMakers}"
                       var="transmissionMaker">
                <option value="${transmissionMaker.id}">${transmissionMaker.name}</option>
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
                name="pedalType">
            <option value="-1">Тип педалей</option>
            <c:forEach items="${pedalType}"
                       var="pedalType">
                <option value="${pedalType.id}">${pedalType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <select class="btn btn-primary btn-select btn-select-light"
                name="bearingType">
            <option value="-1">Тип підшипників</option>
            <c:forEach items="${bearingType}"
                       var="bearingType">
                <option value="${bearingType.id}">${bearingType.type}</option>
            </c:forEach>
        </select>
        <br>
        <br>
        <input class="form-control"
               type="text"
               name="sizes"
               placeholder="Розміри">
        <br>
        <input class="form-control"
               type="text"
               name="material"
               placeholder="Матеріал">
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