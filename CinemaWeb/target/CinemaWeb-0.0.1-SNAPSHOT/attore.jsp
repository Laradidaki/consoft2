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
 <form method="POST" action='update.doattore'>
        ID Attore : <input type="hidden" readonly="readonly" name="idAttore"
            value="<c:out value="${attore.idAttore}" />" /> <br /> 
        Nome Attore : <input type="text" name="nomeAttore"
            value="<c:out value="${attore.nomeAttore}" />" /> <br /> 
        Cognome Attore : <input type="text" name="cognomeAttore"
            value="<c:out value="${attore.cognomeAttore}" />" /> <br /> 
        Età Attore : <input type="text" name="etaAttore"
            value="<c:out value="${attore.etaAttore}" />" /> <br /><input
            type="submit" value="Submit" />
    </form>
</body>
</html>