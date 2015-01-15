<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<table id="table-authors" class="table">
    <thead>
    <tr>
        <th>Tweet Author</th>
    </tr>
    </thead>
<c:forEach items="${authors}" var="author">
    <tr>
        <td>${author}</td>
        <td><button id="${author}-button" type="button" class="btn btn-default">View tweets</button></td>
    </tr>
</c:forEach>
</table>

<script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/navbar.js"/>"></script>

<script type="text/javascript">
    var navbar = new navbar();
    navbar.activateMenu("#menu-users");
    $(".btn").click(function() {
        switch (this.id) {
            case "AltoLabs-button" :
                window.location.href = "<c:url value="/user/altoLabs"/>";
                break;

            case "GlassFrance-button" :
                window.location.href = "<c:url value="/user/glassFrance"/>";
                break;

            case "StartupVillage-button" :
                window.location.href = "<c:url value="/user/startupVillage"/>";
                break;

            default:
                break;
        }
    });
</script>

</body>
</html>