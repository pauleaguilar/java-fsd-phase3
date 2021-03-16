<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<head>
<style>
table, th, td {
  border: 1px solid black;
  
  .content {
   max-width: 500px;
  margin: auto;
  
  }
}
</style>
</head>
<body>
<div class="content">
<h2>Users</h2>

<table style="float:left">
   <tr><th>ID</th><th>Name</th><th>Email</th><th>Password</th></tr>
   <c:forEach items="${users}" var="user" varStatus="count">
    <tr id="${count.index}">
    	<td>${user.id}</td>
        <td>${user.name}</td>
        <td>${user.email}</td>
        <td>${user.password}</td>
    </tr>
  </c:forEach>
</table>
<br/>
<br/>
<br>
<br>
<br>
<br>
<br>
<a href="new.jsp">Edit User</a>
<a href="index.jsp">Go Home</a>

</div>
</body>
</html>

