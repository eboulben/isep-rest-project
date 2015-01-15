<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/home.css"/>"/>
</head>
<body>

<button id="update_button" type="button" class="btn btn-default" ${buttonUpdateState}>
    ${update}
</button>
<br>

<script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/navbar.js"/>"></script>

<script type="text/javascript">
    var navbar = new navbar();
    navbar.activateMenu('#menu-home');
    $('#update_button').click(function() {
       window.location.href = "<c:url value="/home/update"/>";
    });
</script>

</body>
</html>