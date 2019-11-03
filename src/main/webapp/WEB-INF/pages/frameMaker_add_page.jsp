<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New frame manufacturer</title>
    <link rel="shortcut icon"
          href="/resources/images/logo_brauser.png" >
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.1/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <form role="form" class="form-horizontal" action="/admin/frameMaker/add" method="post">
        <div class="form-frameGroup"><h3>Додати виробника</h3></div>
        <div class="form-frameGroup"><input type="text" class="form-control" name="name" placeholder="Name"></div>
        <div class="form-frameGroup"><input type="submit" class="btn btn-primary" value="Add"></div>
    </form>
</div>
</body>
</html>