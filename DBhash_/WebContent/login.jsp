<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta charset="ISO-8859-1">
<title>Login or Register</title>
</head>
<body>
<h1>Login:</h1>
<form method="post" action="db/LoginCheck">
	Username: <input type="text" name="user"><br>
	Password: <input type="password" name="pwd"><br>
	<button type="submit">login</button>
</form>
<br>

<h1>Register:</h1>
<form method="post" action="db/Register">
	Username: <input type="text" name="user"><br>
	Password: <input type="password" name="pwd"><br>
	<button type="submit">register</button>
</form>
</body>
</html>