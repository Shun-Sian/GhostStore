<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@500&display=swap" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="static/styles/reset-css.css" />
    <link rel="stylesheet" type="text/css" href="static/styles/home-style.css" />
    <link rel="stylesheet" type="text/css" href="static/styles/navigation.css" />
    <link rel="stylesheet" type="text/css" href="static/styles/form-style.css" />
</head>
<body>
<div class='container'>
    <jsp:include page="./navigation.jsp" />
	<jsp:include page="./home-nav.jsp"/>
    <main id="pageWrapper">
        <div class="auth-container">
            <form class="form" action="register" method="post">
                
                 <c:choose>
                    <c:when test='${registerError != null}'>
                        <span class="form-error">${registerError}</span>
                    </c:when>
                </c:choose>
                
                <div class="form-control">
                    <label for="username">Please, enter your username</label>
                    <input id="username"
                           type="text"
                           name="username"
                           placeholder="username"/>
                </div>
                <div class="form-control">
                    <label for="password">Please, enter your password</label>
                    <input id="password"
                           type="password"
                           name="password"
                           placeholder="password"/>
                </div>
                <button class="btn" id="submitRegister">Register</button>
            </form>
        </div>
    </main>
</div>
</body>
</html>



