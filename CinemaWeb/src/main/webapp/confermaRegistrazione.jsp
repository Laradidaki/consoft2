<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<style type="text/css">
p{text-align:center;
margin-top: 20px}
.center{
margin-left:600px;
margin-top:150px
}
</style>
</head>
<body>
<img src="immagini/boh.jpg" class="center">
<p>La registrazione è andata a buon fine</p>
  <button class="btn btn-primary" type="submit" value="registrati" style="margin-left:645px;margin-top:30px;" onclick="location.href='homeCinema.jsp'">Home</button>

	<jsp:include page="frammenti/html/script.html"></jsp:include>

</body>
</html>