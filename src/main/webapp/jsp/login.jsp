<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>

    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/reset-css.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/navigation.css"/>
    <link rel="stylesheet" type="text/css" href="static/styles/form-style.css"/>
</head>
<body>
<div class='container'>
    <jsp:include page="./navigation.jsp"/>
    <jsp:include page="./home-nav.jsp"/>
    <main id="pageWrapper">
        <div class='auth-container'>
            <form class="form form-login" action="login" id="loginForm" method="post">
                <c:choose>
                    <c:when test='${loginError != null}'>
                        <span class="form-error">${loginError}</span>
                    </c:when>
                </c:choose>
                <div class="form-control">
                    <label for="username">Please, enter your username</label>
                    <input type="text" id="username" name="username" placeholder="Enter username"/>
                </div>
                <div class="form-control">
                    <label for="password">Please, enter your password</label>
                    <input type="password" id="password" name="password" placeholder="Enter password"/>
                </div>
                <button class="btn" id="submitLogin">Login</button>
            </form>
        </div>
    </main>
</div>
</body>
</html>

