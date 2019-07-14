<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
        <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Save Ticket</title>

<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/style.css"/>
<link type="text/css" rel="stylesheet" 
href="${pageContext.request.contextPath}/resources/css/add-employee-style.css"/>
<style type="text/css">

</style>
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Add Ticket </h2>
		</div>
	</div>
	
	<div id="container">
		<h3>Save Ticket</h3>
		
		<form:form action="saveTicket" modelAttribute="ticket" method="POST">
		
		<!-- need to associate this data with ticket id -->
		<form:hidden path="idTicket"/>
		
		
		<table>
			<tbody>
				<tr>
					<td><label>Client:</label></td>
					<td><form:input path="client"/></td>
				</tr>
				<tr>
					<td><label>Start Date:</label></td>
					<td><form:input path="startDate"/></td>
				</tr>
				<tr>
					<td><label>Release Date:</label></td>
					<td><form:input path="releaseDate"/></td>
				</tr>
				<tr>
					<td><label>Reference Application:</label></td>
					<td><form:input path="referenceApplication"/></td>
				</tr>
					<tr>
					<td><label>Priority:</label></td>
					<td><form:input path="priority"/></td>
				</tr>
					<tr>
					<td><label>Estimate:</label></td>
					<td><form:input path="estimate"/></td>
				</tr>
					<tr>
					<td><label>Description:</label></td>
					<td><form:input path="description"/></td>
				</tr>
					<tr>
					<td><label>Total Working Hours:</label></td>
					<td><form:input path="totWorkingHours"/></td>
				</tr>
					<tr>
					<td><label>Production Order:</label></td>
					<td><form:input path="productionOrder"/></td>
				</tr>
					<tr>
					<td><label>Note:</label></td>
					<td><form:input path="note"/></td>
				</tr>
					<tr>
					<td><label>Ticket Status:</label></td>
					<td><form:input path="ticketStatus"/></td>
				</tr>
					<tr>
					<td><label>Ticket Source:</label></td>
					<td><form:input path="ticketSource"/></td>
				</tr>
					<tr>
					<td><label>Ticket Type:</label></td>
					<td><form:input path="ticketType"/></td>
				</tr>
				
				<tr>
					<td><label></label></td>
					<td><input type="submit" value="Save" class="save"/></td>
				</tr>
		
			</tbody>
		
		</table>
		
		</form:form>
			
		<div style=""clear; both;"></div>
		
			<p>
				<a href="${pageContext.request.contextPath}/ticket/list">Back to the tickets list</a>
			</p>
	
	</div>

</body>
</html>