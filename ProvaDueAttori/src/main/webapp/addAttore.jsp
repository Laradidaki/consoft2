<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
</head>
<body>
<a href="elencoAttori">Aggiungi Film</a>

<form action="addAttore" method="GET" id=add>
<input name="nomeAtt" id="nomeAtt">
<input name="cognomeAtt" id="cognomeAtt" >
<input name="etaAtt" id="etaeAtt" >
<button onclick="manda()" id="salva">Add</button>
</form>

<script type="text/javascript">
function manda() {
	document.forms['add'].submit();
	}	
</script>
</body>
</html>