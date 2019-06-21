<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
	crossorigin="anonymous">
	
<style type="text/css">
p{
position:relative;
left:38%;
font-size:20px;
color:white;
}
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
left:40%;
}

.linkhome:hover{
text-decoration:none;
color:orange;
}

.container{
margin-top:14%;}
.secondlink{
margin-top:70px;}
</style>
</head>
<body class="back">
 <jsp:include page="navbar.jsp" />
<div class="container">
<a href="${pageContext.request.contextPath}/employee/list" class="linkhome">Employees' List</a>
<p>Visualize the entire employees' list</p> 
<div class="secondlink">
<a href="${pageContext.request.contextPath}/ticket/list" class="linkhome" style="left:42%;">Tickets' List</a>
<p style="left:40%;">Visualize the available tickets</p>
</div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"
	integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
	integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
	crossorigin="anonymous"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
	integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
	crossorigin="anonymous"></script>
</body>
</html>