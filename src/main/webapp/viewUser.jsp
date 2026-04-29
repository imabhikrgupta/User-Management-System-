<%@ page import="java.util.List"%>
<%@ page import="com.user.connection.User"%>
<!DOCTYPE html>
<html>
<head>
<title>View Users</title>
<style>
body {
	font-family: Arial;
	background: #f2f2f2;
	text-align: center;
}

table {
	margin: 50px auto;
	border-collapse: collapse;
	width: 70%;
	background: white;
}

th, td {
	padding: 10px;
	border: 1px solid #ddd;
}

th {
	background: #333;
	color: white;
}

a {
	color: red;
	text-decoration: none;
}
</style>
</head>
<body>

	<h2>User List</h2>

	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>Email</th>
			<th>Password</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>

		<!-- Static Example Row -->

		<!--  <tr>
        <td>1</td>
        <td>Abhi</td>
        <td>abhi@gmail.com</td>
        <td>1234</td>
        <td><a href="#">Delete</a></td>
    </tr>
     -->

		<!-- Dynamic Page  -->

		<%
        List<User> users=(List<User>) request.getAttribute("userList");
      
       if(users !=null){
          for(User u:users){
         %>
              <tr>
        <td><%=u.getId()%></td>
		<td><%=u.getName()%></td>
		<td><%=u.getEmail()%></td>
		<td><%=u.getPassword()%></td>
		<td><a href="deleteUser?id=<%= u.getId() %>">Delete</a></td>
		<td><a href="updateUser?id=<%= u.getId()%>">Update</a></td>
		</tr>
        <%
		} 
     }
     %>


	</table>

</body>
</html>