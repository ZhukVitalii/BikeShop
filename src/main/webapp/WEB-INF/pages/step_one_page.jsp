<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>VitaliiZhuk</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>

<body>

<div class="container">
    <li><button type="button" id="main_page" class="btn btn-default navbar-btn">На головну</button></li>
    <h3><img height="200" width="1200" src="<c:url value="/static/panorama.png"/>"/><a href="/"></a></h3>

    <form role="form" class="form-horizontal" action="/frame/choose" method="post">

    <br>
    <br>
    <br>



    <big>Вибір типу велосипеда</big>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Тип</b></td>
        </tr>
        </thead>
        <c:forEach items="${bikeTypes}" var="bikeType">
            <tr>
                <td><input type="checkbox" name="toChoose[]" value="${bikeType.id}" id="checkbox_${bikeType.id}"/></td>
                <td>${bikeType.type}</td>
            </tr>
        </c:forEach>
    </table>

        <li><button type="button" id="chooseFrame" class="btn btn-default navbar-btn">Вибрати</button></li>
        <li><button type="button" id="next" class="btn btn-default navbar-btn">Продовжити</button></li>


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/step_one_page?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>

        </ul>
    </nav>
    </form>
  </div>

<script>
    $('.dropdown-toggle').dropdown();
    $('#main_page').click(function(){
        window.location.href='/';
    });

    $('.dropdown-toggle').dropdown();
    $('#next').click(function(){
        window.location.href='/step_two_page';
    });

    $('#chooseFrame').click(function(){
        var data = ${ 'toChoose[]' };
        $.post("/frame/choose", data, function(data) {
            window.location.reload();
        });
    });
</script>
</body>
</html>