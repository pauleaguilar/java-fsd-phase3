<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>
<jsp:include page="show-tasks" />
<form action="/delete-task" method="POST">
		<label for="id">Enter User ID:</label><br> 
		<input type="number" name="id"><br>
		<br><input type="submit" value ="Search">
</form>

</body>
</html>


