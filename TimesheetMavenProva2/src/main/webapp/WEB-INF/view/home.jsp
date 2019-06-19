<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">

.back{background-image:url("${pageContext.request.contextPath}/resources/images/astratto5.jpg");
	   background-repeat: no-repeat;
  	 background-size: cover;
    background-attachment: fixed !important;
    width: 100%; height: 100%;
}
.linkhome{
text-decoration:none;
font-size: 35px;
color:white;
position: relative;

left:40%;}

.linkhome:hover{
color:violet;
}

.container{
margin-top:14%;}
.secondlink{
margin-top:70px;}
</style>
</head>
<body class="back">
<div class="container">
<a href="${pageContext.request.contextPath}/employee/list" class="linkhome">Employees' List</a>
<br>
<div class="secondlink">
<a href="${pageContext.request.contextPath}/ticket/list" class="linkhome">Tickets' List</a>
</div>
</div>
</body>
</html>