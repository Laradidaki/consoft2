<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Attore</th>
<th>Nome Attore</th>
<th>Cognome Attore</th>
<th>Età Attore</th>
<th colspan=2>Action</th>
</tr>
</thead>

<tbody>
	<c:forEach  items= "${elencoAttori}" var="attore">
<tr>
	
	
					<td><c:out value="${attore.idAttore}" /></td>
					<td><c:out value="${attore.nomeAttore}" /></td>
					<td><c:out value="${attore.cognomeAttore}" /></td>
						<td><c:out value="${attore.etaAttore}" /></td>
				 <td><a href="loadAttore?idAttore=${attore.idAttore}">Update</a></td>
                    <td><a href="deleteAttore?idAttore=${attore.idAttore}"  onclick="return confirm('conferma cancellazione di ${attore.cognomeAttore}?')" >Delete</a></td>
					
</tr>

</c:forEach>
</tbody>
</table>
 <p><a href="addAttore.jsp">Aggiungi Attore</a></p>
</body>
</html>