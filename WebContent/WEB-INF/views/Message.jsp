<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
			Object s = session.getAttribute("id");
			if (s == null) {
				response.sendRedirect("home");

			} else {

			}
		%>

<c:forEach items="${userList}" var="ul">
<form action="/MavenDemo/app/msg" method="post">
<input type="hidden" value="${ul.id}" name="toid" readonly="readonly">
<input type="submit" value="${ul.uname}">
</form>
</c:forEach>

</body>
</html>