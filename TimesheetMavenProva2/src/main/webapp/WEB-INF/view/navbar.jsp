<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<html>

<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/navbar.css"/>
 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
      <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/employee/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/ticket/list" style="position:relative; left:170%">Ticket</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/employee/list" style="position:relative; left:240%">Employee</a>
      </li>
      <li class="nav-item">
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" class="nav-link" id="logout"/>
	</form:form>
        
      </li>
   
        </div>
      </li>
    </ul>
  </div>
</nav>
</html>