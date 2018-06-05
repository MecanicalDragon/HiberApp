<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        My Web App
    </title>
    <meta name="viewpoint" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" integrity="sha384-WskhaSGFgHYWDcbwN70/dfYBj47jz9qbsMId/iRN3ewGhXQFZCSftd1LZCfmhktB" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <div class="jumbotron" style="margin-top: 20px;">
        <div class="text-center">
            <h1>My Web App</h1>
            <p class="lead">My Web App - is a template for my first web app.</p>
            <c:choose>
            <c:when test="${pageContext.request.userPrincipal.name != null}">
                <form method="post" action="logout">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                    <div class="text-primary">
                        You signed in as a ${pageContext.request.userPrincipal.name}
                    </div>
                    <div>
                        <button class="btn btn-danger">Logout</button>
                    </div>
                </form>
            </c:when>
            <c:otherwise>
                <form class="form-signin" method="post" action="loginDone">
                    <div class="row justify-content-sm-center">
                        <input name="username" placeholder="Enter your login"
                               class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
                    </div>
                    <div class="row justify-content-center">
                        <input type="password" name="password" placeholder="...and password to"
                               class="form-control col-8 col-sm-8 col-md-6 col-lg-4 col-xl-2">
                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                    </div>
                    <div class="row justify-content-center">
                        <div class="secondary-text text-center text-danger">
                            <div class="font-italic">
                                <span>${error}</span>
                            </div>
                        </div>
                    </div>
                    <br>
                    <button class="btn btn-success">Sign in</button>
                    <br>
                    <div class="text-primary text-right">
                        <a href="register">...or register if it's your first time here.</a>
                    </div>
                </form>
            </c:otherwise>
            </c:choose>
            <div class="row justify-content-start">
                <a href="adm1" class="btn btn-info btn-sm col-2" type="button">1 admin page</a>

                <a href="adm2" class="btn btn-info btn-sm col-2" type="button">2 admin page</a>
            </div>
            <div class="row justify-content-start">
                <a href="usr1" class="btn btn-warning btn-sm col-2" type="button">1 users page</a>

                <a href="usr2" class="btn btn-warning btn-sm col-2" type="button">2 users page</a>
            </div>
        </div>
    </div>
    <div class="footer">
        <p><a href="dbfs">&copy; DBFS 20!8</a></p>
    </div>
</div>
</body>
</html>
