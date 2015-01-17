<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/home.css"/>"/>
</head>
<body>


<table id="table-tweets" class="table">
    <thead>
    <tr>
        <th>Tweet Author</th>
        <th>Tweet Date</th>
        <th>Tweet Content</th>
    </tr>
    </thead>
    <c:forEach items="${tweets}" var="tweet">
        <tr>
            <th> ${tweet.authorName} </th>
            <th> ${tweet.date} </th>
            <th> ${tweet.message} </th>
        </tr>
    </c:forEach>
</table>

<script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
<script type="text/javascript" src="<c:url value="/static/js/navbar.js"/>"></script>

</body>
</html>