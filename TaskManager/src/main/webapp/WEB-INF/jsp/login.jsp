<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<jsp:include page="page-header.html" />
	<div class="container">
		<form action="login" method="post">
			<label for="username">Username</label> <input type="text"
				id="username" name="username" placeholder="Your Username" required>
			<label for="password">Password</label> <input type="password"
				id="password" name="password" placeholder="Your Password" required>
			<input type="submit" value="Submit">
		</form>
	</div>
	<a href="/">Go Home</a>
	<br>
	<jsp:include page="page-footer.jsp" />
</body>
</html>