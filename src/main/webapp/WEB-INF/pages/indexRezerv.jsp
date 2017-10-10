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
    <img height="50" width="55" src="<c:url value="/static/DSCN8243.png"/>"/><a href="/">VitaliiZhuk</a></h3>
    <li><button type="button" id="start" class="btn btn-default navbar-btn">Почати збір!</button></li>
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul id="groupList" class="nav navbar-nav">

                    <li><button type="button" id="show_frames" class="btn btn-default navbar-btn">Рами</button></li>
                    <li><button type="button" id="show_forks" class="btn btn-default navbar-btn">Вилки</button></li>
                    <li><button type="button" id="show_handlebars" class="btn btn-default navbar-btn">Рульове управління</button></li>
                    <li><button type="button" id="show_wheels" class="btn btn-default navbar-btn">Колеса та комплектуючі</button></li>
                    <li><button type="button" id="show_brakes" class="btn btn-default navbar-btn">Гальма</button></li>
                    <li><button type="button" id="show_transmissions" class="btn btn-default navbar-btn">Трансмісія</button></li>
                    <li><button type="button" id="all_bike_page" class="btn btn-default navbar-btn">Зібрати весь велосипед</button></li>
                    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>


                </ul>




            </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
    </nav>
</div>

<script>
    $('#start').click(function(){
        window.location.href='/start_page';
    });

    $('#show_frames').click(function(){
        window.location.href='/show_frames';
    });
    $('#show_forks').click(function(){
        window.location.href='/show_forks';
    });
    $('#show_handlebars').click(function(){
        window.location.href='/show_handlebars';
    });
    $('#show_wheels').click(function(){
        window.location.href='/show_wheels';
    });
    $('#show_brakes').click(function(){
        window.location.href='/show_brakes';
    });
    $('#show_transmissions').click(function(){
        window.location.href='/show_transmissions';
    });
    $('.dropdown-toggle').dropdown();
    $('#all_bike_page').click(function(){
        window.location.href='/step_one_page';
    });


</script>
</body>
</html>