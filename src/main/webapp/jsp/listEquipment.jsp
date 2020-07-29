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
    <link rel="stylesheet" type="text/css" href="static/styles/list-item-style.css"/>
</head>
<body>
<div class='container'>
    <jsp:include page="./navigation.jsp"/>
     <jsp:include page="./home-nav.jsp"/>
    <main id="pageWrapper">
        <jsp:include page="./mainPageNav.jsp"/>
        <div class="all-items">
            <c:forEach var="i" begin="${0}" end="${equipments.size() - 1}">
            <div class="single-item" data-href="singleEquipment/${equipments.get(i).getId()}">
                <div class="item-name"><c:out value="${equipments.get(i).getName()}"/></div>
                <div class="item-price"><c:out value="${equipments.get(i).getPrice()}"/>EUR</div>
                <div class="item-description"><c:out value="${equipments.get(i).getDescription()}"/></div>
                <div class="item-seller"><c:out value="${equipments.get(i).getSeller()}"/></div>         
            </div>
            </c:forEach>
        </div>
    </main>
</div>
<script src="./lib/jquery-3.5.1.min.js"></script>
<script> 
$(".single-item").click(function() {
	const href=$(this).attr("data-href");
	console.log(href);
	fetch(href).then(response => console.log(response));
	
	
})
</script>
</body>
</html>