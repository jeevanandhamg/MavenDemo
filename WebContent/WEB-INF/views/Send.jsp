<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.cognizant.message.controller.MessageController"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">

  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<title>send message</title>
<style>

body{

<%
			Object s = session.getAttribute("id");

			

			if (s == null) {
				response.sendRedirect("home");

			} else {

			}
		%>
<%-- 		<% response.setIntHeader("Refresh", 60);%> --%>


  background-image: url("../images/a.png");
  background-color: white;

background-repeat: no-repeat;
background-size: 100% 100%;
}
.borderless table {
    border-top-style: none;
    border-left-style: none;
    border-right-style: none;
    border-bottom-style: none;
}
.senddiv{
color:white;background-color:#ff4dd2;width:100%;border-radius: 25px;padding: 5px;
}
.receivediv{
background-color:#f2f2f2;width:80%;border-radius: 25px;padding: 5px;
}

#msg
{
border-radius: 25px;
 background-color:white;
  height:700px;
 overflow:scroll;overflow-x:hidden;overflow-y:auto;
  padding: 5px;  
   
 
}
.f
{
border-radius: 25px;
 background-color:white;
  padding: 5px; 
}
.form-rounded {
border-radius: 1rem;
width:350px;
height:40px;
border-color:#e6e6e6;
}


</style>




</head>
<body>

<p id="d">Welcome</p>

<div class="">
<div class="row">
<div class="col-sm-12">



<div class="row">
<div class="col-sm-3 "></div>
<div class="col-sm-6 ">

<div class="row">
<div class="col-sm-0 "></div>
<div class="col-sm-11 ">
<div  id="msg">

<div class="row">
<div class="col-sm-2 "></div>
<div class="col-sm-8 ">

<table style="width:100%; table-layout: auto;" class="">

<c:forEach items="${messageList}" var="ml">
  <tr>
  
 <c:choose>
 
    <c:when test="${ml.fromid.id eq fid}">
       <td><div class="senddiv"> <c:out value="${ml.message}"> </c:out></div>
        <br /></td>
    </c:when>    
    
    <c:otherwise>
     <td ></td>  <td> <div class="receivediv" ><c:out value="${ml.message}"> </c:out></div>
        <br /></td>
    </c:otherwise>
</c:choose></tr>


</c:forEach>
</table>



</div>
<div class="col-sm-2 "></div></div>
</div>










<div class="f">
<div class="row">

<div class="col-sm-12 ">
<div class="form-group" style="padding-left: 20px;">

<form action="/MavenDemo/app/sending" method="post">
<input type="text" name="msg"  class="form-rounded">
<button type="submit"  class="btn btn-primary" >send</button>
</form>

</div>
</div>
</div>
</div>

</div></div>
<div class="col-sm-2 "></div>
</div>

<div class="col-sm-3 "></div>

</div></div></div></div>
<script>
function myFunction() {
  var elmnt = document.getElementById("msg");
  
  elmnt.scrollTop = 10000;
}
document.getElementById("d").innerHTML = myFunction();
</script>
</body>
</html>