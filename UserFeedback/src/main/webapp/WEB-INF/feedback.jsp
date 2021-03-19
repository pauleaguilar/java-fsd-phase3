<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Feedback</title>
</head>
<body>
<div class="container">
  <form method="post" action="/feedback">
<label for="user">User</label>
    <input type="text" id="user" name="user" placeholder="Your Name" required>
<br>
    <label for="rating">Rating</label>
    <input type="text" id="rating" name="rating" placeholder="Your Rating" required>
<br>
<label for="comments">Comments</label>
    <input type="text" id="comments" name="comments" placeholder="Your Comments" required>
<br>
    <input type="submit" value="Submit">

  </form>
  </div>
</body>
</html>