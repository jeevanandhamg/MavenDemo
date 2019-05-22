<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="/MavenDemo/app/login" method="post">
		<div>
			<br> <br> <input type="text" name="uname"
				placeholder="uname" required><br> <br> <input
				type="password" name="pass" placeholder="Password" required><br>
			<br>
			<button type="submit" class="button" value="login">login</button>
			<br />


		</div>
	</form>

</body>
</html>