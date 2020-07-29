<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ghost Store</title>
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
        <jsp:include page="./mainPageNav.jsp"/>
        <jsp:include page="./addEquipmentForm.jsp"/>
    </main>
</div>
<script src="./lib/jquery-3.5.1.min.js"></script>
</body>
</html>