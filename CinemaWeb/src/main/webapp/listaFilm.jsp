<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<title>Film</title>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<style type="text/css">
<jsp:include page="frammenti/css/table.css"></jsp:include>

.center {
margin-left: 600px;
font-size: 30px;}
</style>

</head>
<body>
	
<table class="blueTable" style="height: 150px;" width="406">
<thead>
<tr>
<th>Id Film</th>
<th>Nome Film</th>
<th>Durata Film</th>
<th>Anno Film</th>
<th>Costo Film</th>
<th>Modifica</th>
<th>Elimina</th>
<th>Dettaglio</th>
</tr>
</thead>

<tbody>
	<c:forEach  items= "${movies}" var="movie">
<tr>
	
				<td><c:out value="${movie.idFilm}" /></td>
				<td><c:out value="${movie.nomeFilm}" /></td>
					<td><c:out value="${movie.durataFilm}" /></td>
					<td><c:out value="${movie.annoFilm}" /></td>
					<td><c:out value="${movie.costoFilm}" /></td>
					 <td><a href="load.do?idFilm=${movie.idFilm}">Update</a></td>
                    <td><a href="delete.do?idFilm=${movie.idFilm}"  onclick="return confirm('conferma cancellazione di ${movie.nomeFilm}?')" >Delete</a></td>
                    <td><a href="dettaglioFilm.jsp">Detail</a></td>
					
</tr>

</c:forEach>
</tbody>
</table>
<a href="addFilm.jsp">Aggiungi Film</a>
</body>
</html>