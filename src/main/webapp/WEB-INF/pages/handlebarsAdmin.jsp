<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Handlebars</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

</head>

<body>

<div class="container">

    <h3><img height="50" width="200" src="<c:url value="/static/DSCN8243.png"/>"/><a href="/"></a></h3>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_handlebar" class="btn btn-default navbar-btn">Додати кермо</button></li>
                    <li><button type="button" id="add_handlebarMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_handlebar" class="btn btn-default navbar-btn">Видалити кермо</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Groups <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                                <li><a href="/handlebarMaker/${handlebarMaker.id}">${handlebarMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>




            </div>
        </div>
    </nav>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип</b></td>
            <td><b>Ширина руля</b></td>
            <td><b>Діаметер руля</b></td>
            <td><b>Підйом руля</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${handlebars}" var="handlebar">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${handlebar.id}" id="checkbox_${handlebar.id}"/></td>

                <td>${handlebar.name}</td>

                <c:choose>
                    <c:when test="${handlebar.bikeType ne null}">
                        <td>${handlebar.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${handlebar.handlebarWide}</td>

                <c:choose>
                    <c:when test="${handlebar.handlebarDiameter ne null}">
                        <td>${handlebar.handlebarDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <td>${handlebar.handlebarHeight}</td>
                <td>${handlebar.material}</td>
                <td>${handlebar.weight}</td>
                <td>${handlebar.color}</td>
                <td>${handlebar.price}</td>
                <td>${handlebar.description}</td>
                <c:choose>
                    <c:when test="${handlebar.handlebarMaker ne null}">
                        <td>${handlebar.handlebarMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${handlebar.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big> Обмотки керма</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-2">
                <ul id="windingList" class="nav navbar-nav">
                    <li><button type="button" id="add_winding" class="btn btn-default navbar-btn">Додати обмотку</button></li>
                    <li><button type="button" id="delete_winding" class="btn btn-default navbar-btn">Видалити обмотку</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                                <li><a href="/handlebarMaker/${handlebarMaker.id}">${handlebarMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>

            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Довжина</b></td>
            <td><b>Ширина</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${windings}" var="winding">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${winding.id}" id="checkbox_${winding.id}"/></td>

                <td>${winding.name}</td>
                <td>${winding.length}</td>
                <td>${winding.wide}</td>
                <td>${winding.material}</td>
                <td>${winding.color}</td>
                <td>${winding.price}</td>
                <td>${winding.description}</td>
                <c:choose>
                    <c:when test="${winding.handlebarMaker ne null}">
                        <td>${winding.handlebarMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${winding.way}"/></td>
            </tr>
        </c:forEach>
    </table>

    <big> Рульова колонка</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-4">
                <ul id="headsetList" class="nav navbar-nav">
                    <li><button type="button" id="add_headset" class="btn btn-default navbar-btn">Додати рульову</button></li>
                    <li><button type="button" id="delete_headset" class="btn btn-default navbar-btn">Видалити рульову</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                                <li><a href="/handlebarMaker/${handlebarMaker.id}">${handlebarMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>

            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип</b></td>
            <td><b>Діаметр штока</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Розмір</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${headsets}" var="headset">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${headset.id}" id="checkbox_${headset.id}"/></td>

                <td>${headset.name}</td>
                <c:choose>
                    <c:when test="${headset.headsetType ne null}">
                        <td>${headset.headsetType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${headset.tubeDiameter ne null}">
                        <td>${headset.tubeDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${headset.material}</td>
                <td>${headset.size}</td>
                <td>${headset.color}</td>
                <td>${headset.price}</td>
                <td>${headset.description}</td>
                <c:choose>
                    <c:when test="${headset.handlebarMaker ne null}">
                        <td>${headset.handlebarMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${headset.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <big> Винос</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-5">
                <ul id="stemList" class="nav navbar-nav">
                    <li><button type="button" id="add_stem" class="btn btn-default navbar-btn">Додати винос</button></li>
                    <li><button type="button" id="delete_stem" class="btn btn-default navbar-btn">Видалити винос</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                                <li><a href="/handlebarMaker/${handlebarMaker.id}">${handlebarMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>

            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Нахил</b></td>
            <td><b>Діаметр керма</b></td>
            <td><b>Діаметр штока</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Довжина</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${stems}" var="stem">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${stem.id}" id="checkbox_${stem.id}"/></td>

                <td>${stem.name}</td>
                <td>${stem.angle}</td>

                <c:choose>
                    <c:when test="${stem.handlebarDiameter ne null}">
                        <td>${stem.handlebarDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>

                <c:choose>
                    <c:when test="${stem.tubeDiameter ne null}">
                        <td>${stem.tubeDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${stem.material}</td>
                <td>${stem.length}</td>
                <td>${stem.color}</td>
                <td>${stem.price}</td>
                <td>${stem.description}</td>
                <c:choose>
                    <c:when test="${stem.handlebarMaker ne null}">
                        <td>${stem.handlebarMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${stem.way}"/></td>
            </tr>
        </c:forEach>
    </table>



    <big> Гріпси</big>
    <nav class="navbar navbar-default">
        <div class="container-fluid">

            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-3">
                <ul id="gripsList" class="nav navbar-nav">
                    <li><button type="button" id="add_grips" class="btn btn-default navbar-btn">Додати гріпси</button></li>
                    <li><button type="button" id="delete_grips" class="btn btn-default navbar-btn">Видалити гріпси</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${handlebarMakers}" var="handlebarMaker">
                                <li><a href="/handlebarMaker/${handlebarMaker.id}">${handlebarMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>

            </div>
        </div>
    </nav>
    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Довжина</b></td>
            <td><b>Вага</b></td>
            <td><b>Матеріал</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${grips}" var="grips">
            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${grips.id}" id="checkbox_${grips.id}"/></td>

                <td>${grips.name}</td>
                <td>${grips.length}</td>
                <td>${grips.weight}</td>
                <td>${grips.material}</td>
                <td>${grips.color}</td>
                <td>${grips.price}</td>
                <td>${grips.description}</td>
                <c:choose>
                    <c:when test="${grips.handlebarMaker ne null}">
                        <td>${grips.handlebarMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${grips.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_handlebars?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/handlebarMaker/${handlebarMakerId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();

    $('#add_handlebar').click(function(){
        window.location.href='/handlebars_add_page';
    });

    $('#add_winding').click(function(){
        window.location.href='/winding_add_page';
    });
    $('#add_grips').click(function(){
        window.location.href='/grips_add_page';
    });
    $('#add_headset').click(function(){
        window.location.href='/headset_add_page';
    });
    $('#add_stem').click(function(){
        window.location.href='/stem_add_page';
    });

    $('#add_handlebarMaker').click(function(){
        window.location.href='/handlebarMaker_add_page';
    });

    $('#delete_handlebar').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/handlebar/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_winding').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/winding/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_grips').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/grips/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_headset').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/headset/delete", data, function(data, status) {
            window.location.reload();
        });
    });
    $('#delete_stem').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/stem/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>