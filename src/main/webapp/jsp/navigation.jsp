<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav>
	<c:choose>
		<c:when test="${user != null}">
			<ul>
				<li><a href="home">Home</a></li>
				<li><a href="logout">Logout</a></li>
				<li><a href="#">Hello, ${user.getUsername()}</a></li>
			</ul>
		</c:when>
		<c:when test="${user == null }">
			<ul>
				<li><a href="home">Home</a></li>
				<li><a href="login">Login</a></li>
				<li><a href="register">Register</a></li>
			</ul>
		</c:when>
	</c:choose>
</nav>