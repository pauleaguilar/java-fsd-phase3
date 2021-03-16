
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<style>
table, th, td {
  border: 1px solid black;
}
</style>
</head>
<body>
<h2>Users</h2>
<br>
<form action ="/go" method="get">
  <label for="id">Id:</label><br>
  <input type="text" id="id" name="id"><br>
  <label for="name">Name:</label><br>
  <input type="text" id="name" name="name"><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="email"><br>
  <label for="password">Password:</label><br>
  <input type="text" id="password" name="password"><br>
  <input type="submit" value="Update">
</form>
<br>
<a href="index.jsp">Go Home</a>
</body>
</html>