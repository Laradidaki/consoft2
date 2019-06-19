<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
	crossorigin="anonymous">
	
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.0/css/all.css" 
	integrity="sha384-aOkxzJ5uQz7WBObEZcHvV5JvRW3TUc2rNPA7pe3AwnsUohiw1Vj2Rgx2KSOkF5+h" 
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>List Employees</title>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>

</head>
<body>
	 <nav class="navbar navbar-expand-lg navbar-dark bg-dark">

  <div class="collapse navbar-collapse" id="navbarNavDropdown">
    <ul class="navbar-nav">
        <li class="nav-item active">
        <a class="nav-link" href="${pageContext.request.contextPath}/employee/home">Home</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/ticket/list">Ticket</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/employee/list">Dipendenti</a>
      </li>
       <li class="nav-item">
        <a class="nav-link" href="${pageContext.request.contextPath}/logout">Logout</a>
      </li>
   </ul>
        </div>
</nav>
	<div id="wrapper">
		<div id="header">
			<h2>ERM - Employee Relationship Manager</h2>
	
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		          <!--  add a search box -->
            <form:form action="search" method="GET">
                Search employee: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
		 	<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
	
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
            
		
		<input type="button" value="Add Employee"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
		/>
		
		</security:authorize>
		
		<table>
		<tr>
		<th>Last name</th>
		<th>First name</th>
		<th>Client</th>
		<th>Work hours</th>
		
			<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					
						<th>Action</th>
					
					</security:authorize>
		</tr>
		
		<c:forEach var="tempEmployee" items="${employees}">
		
		<!-- construct an "update" link with employee id -->
		<c:url var="updateLink" value="/employee/showFormForUpdate">
		<c:param name="employeeId" value="${tempEmployee.idEmployee}"/>
		</c:url>
		
		<!-- construct an "delete" link with employee id -->
		<c:url var="deleteLink" value="/employee/delete">
		<c:param name="employeeId" value="${tempEmployee.idEmployee}"/>
		</c:url>
		
		<tr>
		<td> ${tempEmployee.lastName} </td>
		<td> ${tempEmployee.firstName} </td>
		<td> ${tempEmployee.client} </td>
		<td> ${tempEmployee.workHours} </td>
		
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						
							<td>
								<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>
	
								<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false">Delete</a>
								</security:authorize>
							</td>

						</security:authorize>
		</tr>
		
		</c:forEach>
		</table>
	
		</div>
		
		<br>
		<hr>
		<a href="${pageContext.request.contextPath}/ticket/list" class=linkticket>Go to the ticket list</a>
		
		<br>
			<!-- add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout" class="logout"/>
	</form:form>
	
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