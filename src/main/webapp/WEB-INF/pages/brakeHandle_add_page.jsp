<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New brakeHandle</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/brakeHandle/add" method="post">
        <h3>New brakeHandle</h3>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${brakeMakers}" var="brakeMaker">
                <option value="${brakeMaker.id}">${brakeMaker.name}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="name" placeholder="Назва">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeHandleLocation">
            <option value="-1">Розташування</option>
            <c:forEach items="${brakeHandleLocations}" var="brakeHandleLocation">
                <option value="${brakeHandleLocation.id}">${brakeHandleLocation.local}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeHandleCompatibility">
            <option value="-1">Сумісність з типом гальм</option>
            <c:forEach items="${brakeHandleCompatibilitys}" var="brakeHandleCompatibility">
                <option value="${brakeHandleCompatibility.id}">${brakeHandleCompatibility.comp}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="materialHandle" placeholder="Матеріал ручки">
        <br>
        <input class="form-control " type="text" name="materialCorp" placeholder="Матеріал корпусу">
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="handlebarDiameter">
            <option value="-1">Сумісність з діаметром керма</option>
            <c:forEach items="${handlebarDiameters}" var="handlebarDiameter">
                <option value="${handlebarDiameter.id}">${handlebarDiameter.diam}</option>
            </c:forEach>
        </select>
        <br>
        <select class="btn btn-primary btn-select btn-select-light" name="brakeHandleWide">
            <option value="-1">Ширина ручки</option>
            <c:forEach items="${brakeHandleWides}" var="brakeHandleWide">
                <option value="${brakeHandleWide.id}">${brakeHandleWide.wide}</option>
            </c:forEach>
        </select>
        <br>
        <input class="form-control " type="text" name="weight" placeholder="Вага ручок">
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