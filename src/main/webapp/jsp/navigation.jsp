<%@ page import="entities.User" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="auth-nav">
    <c:choose>
        <c:when test="${user != null}">
            <ul>
                <li>
                    <a href="logout?username=<%=((User)request.getSession().getAttribute("user")).getUsername()%>">
                        Logout
                    </a>
                </li>
                <li><a href="#">Hello, ${user.getUsername()}</a></li>
            </ul>
        </c:when>
        <c:when test="${user == null }">
            <ul>
                <li><a href="login">Login</a></li>
                <li><a href="register">Register</a></li>
            </ul>
        </c:when>
    </c:choose>
</nav>