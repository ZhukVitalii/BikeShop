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
                <td><b>Назва</b></td>
                <td><b>Тип</b></td>
                <td><b>Розмір колес</b></td>
                <td><b>Діаметр штока</b></td>
                <td><b>Довжина штока</b></td>
                <td><b>Тип гальм</b></td>
                <td><b>Матеріал</b></td>
                <td><b>Вага</b></td>
                <td><b>Колір</b></td>
                <td><b>Хід вилки</b></td>
                <td><b>Ціна</b></td>
                <td><b>Опис</b></td>
                <td><b>Виробник</b></td>
                <td><b>Зображення</b></td>
            </tr>
            </thead>
            <c:forEach items="${forks}" var="fork">
                <tr>
                    <td><input type="checkbox" name="toDelete[]" value="${fork.id}" id="checkbox_${fork.id}"/></td>
                    <td>${fork.name}</td>

                    <c:choose>
                        <c:when test="${fork.forkType ne null}">
                            <td>${fork.forkType.type}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>



                    <c:choose>
                        <c:when test="${fork.wheelsDiam ne null}">
                            <td>${fork.wheelsDiam.diam}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>

                    <c:choose>
                        <c:when test="${fork.tubeDiameter ne null}">
                            <td>${fork.tubeDiameter.diam}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${fork.stTubeLength}</td>

                    <c:choose>
                        <c:when test="${fork.brakesType ne null}">
                            <td>${fork.brakesType.type}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                    <td>${fork.forkMaterial}</td>
                    <td>${fork.weight}</td>
                    <td>${fork.color}</td>
                    <td>${fork.move}</td>
                    <td>${fork.price}</td>
                    <td>${fork.description}</td>
                    <c:choose>
                        <c:when test="${fork.forkMaker ne null}">
                            <td>${fork.forkMaker.name}</td>
                        </c:when>
                        <c:otherwise>
                            <td>Default</td>
                        </c:otherwise>
                    </c:choose>
                    <td><img height="80" width="80" src="${fork.way}"/></td>
                </tr>
            </c:forEach>
        </table>
        <li><button type="button" id="chooseFrame" class="btn btn-default navbar-btn">Продовжити</button></li>


        <nav aria-label="Page navigation">
            <ul class="pagination">
                <c:if test="${allPages ne null}">
                    <c:forEach var="i" begin="1" end="${allPages}">
                        <li><a href="/start_page?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
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
            window.location.href='/step_two_page';
        });
    });
</script>
</body>
</html>