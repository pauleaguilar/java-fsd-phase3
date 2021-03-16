<html xmlns="http://www.w3.org/1999/xhtml"
    xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="utf-8" />
    <title>Edit User</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootswatch/4.5.2/cosmo/bootstrap.min.css" />
    <script src= "https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js" ></script>
</head>
<body>
<div align="center">
    <h1>Edit User</h1>
    <br />
     <div class="col-sm-4">
    <form action="#" th:action="/save" th:object="user" method="post">
 
      
 		<div alight="left">
            <tr>
                <label class="form-label" >Name</label>
                <td>
	                <input type="hidden" th:field="*{id}" />
	                <input type="text" th:field="*{name}" class="form-control" placeholder="Name" />
                </td>
            </tr>
         </div>   
            
          	<div alight="left">
          
            <tr>
                 <label class="form-label" >Email</label>
                <td><input type="text" th:field="*{email}" class="form-control" placeholder="Email" /></td>
            </tr>
            </div> 
            <div alight="left">
                 <tr>
                 <label class="form-label" >Password</label>
                <td><input type="text" th:field="*{password}" class="form-control" placeholder="Password" /></td>
            </tr>
            </div> 
			<br>
            <tr>
            <td colspan="2"><button type="submit" class="btn btn-info">Save</button> </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>