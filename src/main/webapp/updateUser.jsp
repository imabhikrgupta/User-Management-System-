<%@ page import="com.user.connection.User"%>
<%
User u = (User) request.getAttribute("user");
%><!DOCTYPE html>
<html>
<head>
<title>Update User</title>
<style>
body {
	font-family: Arial;
	background: #fff3e6;
}

.container {
	width: 350px;
	margin: 80px auto;
	padding: 20px;
	background: white;
	border-radius: 10px;
	box-shadow: 0 0 10px gray;
}

input {
	width: 100%;
	padding: 8px;
	margin: 10px 0;
}

button {
	width: 100%;
	padding: 10px;
	background: orange;
	color: white;
	border: none;
}
</style>

</head>
<body>

	<div class="container">
		<h2>Update User</h2>

		<form action="updateUser" method="post">
			<input type="hidden" name="id" value="<%=u.getId()%>" /> <input
				type="text" name="name" value="<%=u.getName()%>" required /> <input
				type="email" name="email" value="<%=u.getEmail()%>" required /> <input
				type="password" name="password" value="<%=u.getPassword()%>"
				required />
			<button type="submit">Update User</button>
		</form>

	</div>

</body>
</html>