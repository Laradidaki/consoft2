<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Tickets</title>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>
</head>
<body>
<div id="wrapper">
		<div id="header">
			<h2>Tickets' list</h2>
	
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
		          <!--  add a search box -->
            <form:form action="searchT" method="GET">
                Search ticket: <input type="text" name="theSearchName" />
                
                <input type="submit" value="Search" class="add-button" />
            </form:form>
		
		 	<p>
				User: <security:authentication property="principal.username" />, Role(s): <security:authentication property="principal.authorities" />
			</p>
	
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
            
		
		<input type="button" value="Add Ticket"
		onclick="window.location.href='showFormForAdd'; return false;"
		class="add-button"
		/>
		
		</security:authorize>
		
		<table>
		<tr>
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
		
		
			<%-- Only show "Action" column for managers or admin --%>
					<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
					
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
		
			<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
						
							<td>
								<security:authorize access="hasAnyRole('MANAGER', 'ADMIN')">
									<!-- display the update link -->
									<a href="${updateLink}">Update</a>
								</security:authorize>
	
								<security:authorize access="hasAnyRole('MANAGER','ADMIN')">
									<a href="${deleteLink}"
									   onclick="if (!(confirm('Are you sure you want to delete this ticket?'))) return false">Delete</a>
								</security:authorize>
							</td>

						</security:authorize>
		</tr>
		
		</c:forEach>
		</table>
	
		</div>
		
		<br>
			<!-- add a logout button -->
	
	<form:form action="${pageContext.request.contextPath}/logout" method="POST">
	<input type="submit" value="Logout"/>
	</form:form>
	
	</div>
</body>
</html>