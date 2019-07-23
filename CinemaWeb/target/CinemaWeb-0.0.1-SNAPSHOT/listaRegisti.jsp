<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Registi</title>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<style type="text/css">
<jsp:include page="frammenti/css/table.css"></jsp:include>
</style>
</head>
<body>

<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Regista</th>
<th>Nome Regista</th>
<th>Cognome Regista</th>
<th>Età Regista</th>
<th colspan=2>Action</th>
</tr>
</thead>

<tbody>
	<c:forEach  items= "${registi}" var="regista">
<tr>
	
	
					<td><c:out value="${regista.idRegista}" /></td>
					<td><c:out value="${regista.nomeRegista}" /></td>
					<td><c:out value="${regista.cognomeRegista}" /></td>
					<td><c:out value="${regista.etaRegista}" /></td>
					 <td><a href="load.doregista?idRegista=${regista.idRegista}">Update</a></td>
                    <td><a href="delete.doregista?idRegista=${regista.idRegista}"  onclick="return confirm('conferma cancellazione di ${regista.cognomeRegista}?')" >Delete</a></td>
					
</tr>

</c:forEach>
</tbody>
</table>
<a href="addRegista.jsp">Aggiungi Regista</a>
</body>
</html>