<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Aggiungi Regista</title>
</head>
<body>
<form method="POST" action='update.doregista'>
        Regista ID : <input type="hidden" readonly="readonly" name="idRegista"
            value="<c:out value="${regista.idRegista}" />" /> <br /> 
        Nome Regista : <input
            type="text" name="nomeRegista"
            value="<c:out value="${regista.nomeRegista}" />" /> <br /> 
        Cognome Regista : <input
            type="text" name="cognomeRegista"
            value="<c:out value="${regista.cognomeRegista}" />" /> <br /> 
        Età Regista : <input type="text" name="etaRegista"
            value="<c:out value="${regista.etaRegista}" />" /> <br />
             <input type="submit" value="Submit" />
    </form>

</body>
</html>