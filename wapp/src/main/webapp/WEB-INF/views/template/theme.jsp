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
                <li id="menu-home"><a href="<c:url value="/home" />">Home</a></li>
                <li id="menu-user"><a href="<c:url value="/user" />">User</a></li>
                <li id="menu-follow"><a href="<c:url value="/follow"/>">Following</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a data-toggle="dropdown" class="dropdown-toggle" href="">Login<b
                            class="caret"></b></a>
                    <ul role="menu" class="dropdown-menu">
                        <li>
                            <form>
                                <div class="input-group">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-user"></span></span>
                                    <input type="text" class="form-control" placeholder="Username">
                                </div>
                                <div class="input-group">
                                    <span class="input-group-addon"><span
                                            class="glyphicon glyphicon-pencil"></span></span>
                                    <input type="password" class="form-control" placeholder="Password">
                                </div>
                                <button type="button" class="btn btn-default btn-sm "><span
                                        class="glyphicon glyphicon-cloud-upload"></span> Login
                                </button>
                            </form>
                        </li>
                        <li class="divider"></li>
                        <li><a href="<c:url value="/signin"/>">Sign in</a></li>
                    </ul>

                </li>
            </ul>
            <form role="search" class="navbar-form navbar-right">
                <div class="form-group">
                    <input type="text" placeholder="Search" class="form-control">
                </div>
            </form>
        </div>
    </nav>

    <script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/bootstrap/js/bootstrap.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/static/js/jquery-2.1.1.min.js"/>"></script>

    <div class="">
        <decorator:body/>
    </div>


    <footer class="footer">
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



</body>

</html>
