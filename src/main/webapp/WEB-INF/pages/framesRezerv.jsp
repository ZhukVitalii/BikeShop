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
    <h3><img height="200" width="1200" src="<c:url value="/static/panorama.png"/>"/><a href="/"></a></h3>
    <li><button type="button" id="main_page" class="btn btn-default navbar-btn">На головну</button></li>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

                <ul id="groupList" class="nav navbar-nav">
                    <li><button type="button" id="add_frame" class="btn btn-default navbar-btn">Додати раму</button></li>
                    <li><button type="button" id="add_frameMaker" class="btn btn-default navbar-btn">Додати виробника</button></li>
                    <li><button type="button" id="delete_frame" class="btn btn-default navbar-btn">Видалити раму</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Виробник <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/">Default</a></li>
                            <c:forEach items="${frameMakers}" var="frameMaker">
                                <li><a href="/frameMaker/${frameMaker.id}">${frameMaker.name}</a></li>
                            </c:forEach>
                        </ul>
                    </li>

                </ul>


            </div>
        </div>
    </nav>
    <table class="table table-bordered" width="100%">

        <tr valign="top">
            <td colspan="3">Ячейка 1</td>
        </tr>

        <tr valign="top">
            <td rowspan="2" align="center" valign="middle">Ячейка 2</td>
            <td>Ячейка 3</td>
            <td rowspan="2" align="center" valign="middle">Ячейка 4</td>
        </tr>

        <tr valign="top">
            <td>Ячейка 5</td>
        </tr>

    </table>

    <table class="table table-bordered">
        <thead>
        <tr>
            <td></td>
            <td><b>Назва</b></td>
            <td><b>Тип</b></td>
            <td><b>Розмір рами</b></td>
            <td><b>Матеріал рами</b></td>
            <td><b>Ширина каретки</b></td>
            <td><b>Тип рульової</b></td>
            <td><b>Діаметр рульової</b></td>
            <td><b>Діаметр підсидільної труби</b></td>
            <td><b>Сумісність з типом гальм</b></td>
            <td><b>Кріплення багажника</b></td>
            <td><b>Вага</b></td>
            <td><b>Колір</b></td>
            <td><b>Ціна</b></td>
            <td><b>Опис</b></td>
            <td><b>Виробник</b></td>
            <td><b>Зображення</b></td>
        </tr>
        </thead>
        <c:forEach items="${frames}" var="frame">

            <tr>
                <td><input type="checkbox" name="toDelete[]" value="${frame.id}" id="checkbox_${frame.id}"/></td>

                <table class="tbglav" width="100%">

                    <tr valign="top">
                        <td colspan="3">Ячейка 1</td>
                    </tr>

                    <tr valign="top">
                        <td rowspan="2" align="center" valign="middle">Ячейка 2</td>
                        <td>Ячейка 3</td>
                        <td rowspan="2" align="center" valign="middle">Ячейка 4</td>
                    </tr>

                    <tr valign="top">
                        <td>Ячейка 5</td>
                    </tr>

                </table>


                <td>${frame.name}</td>
                <c:choose>
                    <c:when test="${frame.bikeType ne null}">
                        <td>${frame.bikeType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.frameSize ne null}">
                        <td>${frame.frameSize.size}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frame.material}</td>
                <c:choose>
                    <c:when test="${frame.bracketWide ne null}">
                        <td>${frame.bracketWide.wide}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.headsetType ne null}">
                        <td>${frame.headsetType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.tubeDiameter ne null}">
                        <td>${frame.tubeDiameter.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.underSaddleTube ne null}">
                        <td>${frame.underSaddleTube.diam}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.brakesType ne null}">
                        <td>${frame.brakesType.type}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <c:choose>
                    <c:when test="${frame.trunkBinding ne null}">
                        <td>${frame.trunkBinding.trunk}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td>${frame.weight}</td>
                <td>${frame.color}</td>
                <td>${frame.price}</td>
                <td>${frame.description}</td>
                <c:choose>
                    <c:when test="${frame.frameMaker ne null}">
                        <td>${frame.frameMaker.name}</td>
                    </c:when>
                    <c:otherwise>
                        <td>Default</td>
                    </c:otherwise>
                </c:choose>
                <td><img height="80" width="80" src="${frame.way}"/></td>
            </tr>
        </c:forEach>
    </table>


    <nav aria-label="Page navigation">
        <ul class="pagination">
            <c:if test="${allPages ne null}">
                <c:forEach var="i" begin="1" end="${allPages}">
                    <li><a href="/show_frames?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
            <c:if test="${byGroupPages ne null}">
                <c:forEach var="i" begin="1" end="${byGroupPages}">
                    <li><a href="/frameMaker/${groupId}?page=<c:out value="${i - 1}"/>"><c:out value="${i}"/></a></li>
                </c:forEach>
            </c:if>
        </ul>
    </nav>
</div>

<script>
    $('.dropdown-toggle').dropdown();
    $('#main_page').click(function(){
        window.location.href='/';
    });

    $('#add_frame').click(function(){
        window.location.href='/frame_add_page';
    });

    $('#add_frameMaker').click(function(){
        window.location.href='/frameMaker_add_page';
    });

    $('#delete_frame').click(function(){
        var data = { 'toDelete[]' : []};
        $(":checked").each(function() {
            data['toDelete[]'].push($(this).val());
        });
        $.post("/frame/delete", data, function(data, status) {
            window.location.reload();
        });
    });
</script>
</body>
</html>