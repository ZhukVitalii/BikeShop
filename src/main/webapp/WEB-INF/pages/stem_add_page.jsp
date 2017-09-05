<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New stem</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>


<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/stem/add" method="post">
        <h3>New stem</h3>
        <select class="selectpicker form-control form-handlebarMaker" name="handlebarMaker">
            <option value="-1">Виробник</option>
            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                <option value="${handlebarMaker.id}">${handlebarMaker.name}</option>
            </c:forEach>
        </select>
        <input class="form-control form-handlebarMaker" type="text" name="name" placeholder="назва">
        <input class="form-control form-handlebarMaker" type="text" name="angle" placeholder="нахил">
        <select class="selectpicker form-control form-frame" name="handlebarDiameter">
            <option value="-1">Діаметр керма</option>
            <c:forEach items="${handlebarDiameter}" var="handlebarDiameter">
                <option value="${handlebarDiameter.id}">${handlebarDiameter.diam}</option>
            </c:forEach>
        </select>
        <select class="selectpicker form-control form-tubeDiameter" name="tubeDiameter">
            <option value="-1">Діаметр штока</option>
            <c:forEach items="${tubeDiameter}" var="tubeDiameter">
                <option value="${tubeDiameter.id}">${tubeDiameter.diam}</option>
            </c:forEach>
        </select>
        <select class="selectpicker form-control form-handlebarMaker" name="handlebarMaterial">
            <option value="-1">Матеріал</option>
            <c:forEach items="${handlebarMaterial}" var="handlebarMaterial">
                <option value="${handlebarMaterial.id}">${handlebarMaterial.material}</option>
            </c:forEach>
        </select>
        <input class="form-control form-forkMaker" type="text" name="length" placeholder="довжина">
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