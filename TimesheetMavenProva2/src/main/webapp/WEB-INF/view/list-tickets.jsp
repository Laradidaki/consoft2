<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" 
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" 
	integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" 
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>List Tickets</title>
<style type="text/css">

</style>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<jsp:include page="navbar.jsp" />
<div id="wrapper">
		<div id="header" >
			<h2>Tickets' list</h2>
	
		</div>
	</div>
	
	<div id="container">
	
		<div id="content" >
		
		          <!--  add a search box -->
            <form:form action="searchT" method="GET">
                Search ticket: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
		 	<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
	
			<security:authorize access="hasAnyRole('MANAGER', 'S_EMPLOYEE')">
            
		
		<input type="button" value="Add Ticket"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
		/>
		
		</security:authorize>
		
		<table>
		<tr>
		<th>ID Ticket</th>
		<th>client</th>
		<th>Start Date</th>
		<th>Release Date</th>
		<th>Reference Application</th>
		<th>Priority</th>
		<th>Estimate</th>
		<th>Description</th>
		<th>Total Working Hours</th>
		<th>Production Order</th>
		<th>Note</th>
		<th>Ticket Status</th>
		<th>Ticket Source</th>
		<th>Ticket Type</th>
		<th>ID Manager</th>
		
		
			<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasAnyRole('MANAGER', 'S_EMPLOYEE', 'EMPLOYEE')">
					
						<th>Action</th>
					
					</security:authorize>
		</tr>
		
		<c:forEach var="tempTicket" items="${tickets}">
		
		<!-- construct an "update" link with ticket id -->
		<c:url var="updateLink" value="/ticket/showFormForUpdate">
		<c:param name="ticketId" value="${tempTicket.idTicket}"/>
		</c:url>
		
		<!-- construct an "delete" link with ticket id -->
		<c:url var="deleteLink" value="/ticket/delete">
		<c:param name="ticketId" value="${tempTicket.idTicket}"/>
		</c:url>
		
		<tr>
		<td> ${tempTicket.idTicket} </td>
		<td> ${tempTicket.client} </td>
		<td> ${tempTicket.startDate} </td>
		<td> ${tempTicket.releaseDate} </td>
		<td> ${tempTicket.referenceApplication} </td>
		<td> ${tempTicket.priority} </td>
		<td> ${tempTicket.estimate} </td>
		<td> ${tempTicket.description} </td>
		<td> ${tempTicket.totWorkingHours} </td>
		<td> ${tempTicket.productionOrder} </td>
		<td> ${tempTicket.note} </td>
		<td> ${tempTicket.ticketStatus} </td>
		<td> ${tempTicket.ticketSource} </td>
		<td> ${tempTicket.ticketType} </td>
		<td> ${tempTicket.manager} </td>
		
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						
							<td>
								<security:authorize access="hasAnyRole('MANAGER', 'S_EMPLOYEE')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>
	
								<security:authorize access="hasAnyRole('MANAGER','S_EMPLOYEE')">
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">Delete</a>
								</security:authorize>
							</td>

						</security:authorize>
		</tr>
		
		</c:forEach>
		</table>
	
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