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
<h2>View Tasks</h2>

<table>
   <tr><th>ID</th><th>Description</th><th>Email</th><th>Start Date</th><th>End Date</th><th>Name of task</th><th>Severity</th></tr>
   <c:forEach items="${task}" var="task" varStatus="count">
    <tr id="${count.index}">
        <td>${task.id}</td>
        <td>${task.description}</td>
        <td>${task.email}</td>
        <td>${task.startDate}</td> 
        <td>${task.endDate}</td>
        <td>${task.name}</td>
        <td>${task.severity}</td> 
        <td>${task.user}</td>
    </tr>
 </c:forEach>
</table>
<hr><hr><hr>

<br><a href="/tasks">Back to options</a><br>



</body>
</html>