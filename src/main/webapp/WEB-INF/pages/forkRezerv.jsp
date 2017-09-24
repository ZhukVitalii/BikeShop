<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>VitaliiZhuk</title>
    <link rel="shortcut icon"
          href="resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>

<body>

<div class="container">
    <h3><img height="50" width="55" src="<c:url value="/static/logo.png"/>"/><a href="/">Contacts List</a></h3>
    <img height="50" width="55" src="<c:url value="/static/DSCN8243.png"/>"/><a href="/">Contacts List</a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_fork" class="btn btn-default navbar-btn">Додати вилку</button></li>
                    <li><button type="button" id="add_forkMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_fork" class="btn btn-default navbar-btn">Видалити вилку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Groups <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${forkMakers}" var="forkMaker">
                                <li><a href="/forkMaker/${forkMaker.id}">${forkMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>




            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>

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


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_forks?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/forkMaker/${forkMakerId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_fork').click(function(){
        window.location.href='/fork_add';
    });

    $('#add_forkMaker').click(function(){
        window.location.href='/forkMaker_add_page';
    });

    $('#delete_fork').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/fork/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>