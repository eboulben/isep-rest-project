<%@ taglib prefix="decorator" uri="http://www.opensymphony.com/sitemesh/decorator" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Read Tweets</title>

    <link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/bootstrap/css/bootstrap-theme.min.css"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/theme.css"/>"/>

    <decorator:head/>
</head>

<body>

<div class="container">
    <nav role="navigation" class="navbar navbar-inverse">
        <div class="navbar-header">
            <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a href="<c:url value="/home" />" class="navbar-brand">Read Tweets</a>
        </div>
        <div id="navbarCollapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li id="button_dropdown" class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="">Filter authors<b
                            class="caret"></b></a>
                    <ul id="authors_box" role="menu" class="dropdown-menu">
                        <c:forEach var="user" items="${users}">
                            <li id="filter_${user}"><a href="" onclick="return false">${user}</a></li>
                        </c:forEach>
                    </ul>

                </li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li id="update_button"><a>Update Database</a></li>
            </ul>
        </div>
    </nav>

    <div class="main-content">
        <decorator:body/>
    </div>


    <footer class="footer modal-footer">
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12">
                <a href="<c:url value="/about"/>">About us</a>
            </div>
            <div class="clearfix visible-xs-block"></div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <a href="https://github.com/eboulben/isep-rest-project">Github</a>
            </div>
            <div class="clearfix visible-sm-block visible-xs-block"></div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <a href="">Jenkins</a>
            </div>
            <div class="clearfix visible-xs-block"></div>
            <div class="col-md-3 col-sm-6 col-xs-12">
                <a href="">Sonar</a>
            </div>
        </div>
    </footer>
</div>

<script type="text/javascript" src="<c:url value="/static/js/theme.js"/>"></script>
</body>

</html>
