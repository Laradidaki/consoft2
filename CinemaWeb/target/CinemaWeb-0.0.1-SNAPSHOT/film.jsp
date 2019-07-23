<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <form method="POST" action='update.do'>
        Film ID : <input type="hidden" readonly="readonly" name="idFilm"
            value="<c:out value="${film.idFilm}" />" /> <br /> 
        Nome Film : <input type="text" name="nomeFilm"
            value="<c:out value="${film.nomeFilm}" />" /> <br /> 
        Durata Film : <input type="text" name="durataFilm"
            value="<c:out value="${film.durataFilm}" />" /> <br /> 
        Anno Film : <input type="text" name="annoFilm"
            value="<c:out value="${film.annoFilm}" />" /> <br /> 
        Costo Film : <input type="text" name="costoFilm"
            value="<c:out value="${film.costoFilm}" />" /> <br /><input
            type="submit" value="Submit" />
    </form>
</body>
</html>