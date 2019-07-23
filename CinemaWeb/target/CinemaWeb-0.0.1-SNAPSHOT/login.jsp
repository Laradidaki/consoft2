<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<style type="text/css">

h1{
font-size: 45px;
margin-left:630px;
margin-top: 40px;
color:white}
.back {
  background-image: url("immagini/drive2.jpg");
   background-repeat: no-repeat;
   background-size: cover;
    background-attachment: fixed !important;
    width: 100%; height: 100%;
}
label{
color: white !important;}
</style>
</head>
<body class="back">
<h1>Login</h1>
<form action="<%= request.getContextPath()+"/login" %>" method="post">
    <div class="col-md-3 mb-3" style="margin-left:530px; margin-top: 50px;">
      <label for="validationCustomUsername">Username</label>
      <input type="text" class="form-control"  name="username" id="validationCustomUsername" placeholder="Inserisci il tuo username" required>
    </div>
    <div class="col-md-3 mb-3" style="margin-left:530px;">
      <label for="validationCustomPassword">Password</label>
      <input type="password" class="form-control"  name="password" id="validationCustomPassword" placeholder="Inserisci la tua password" required>
    
    </div>
   <button class="btn btn-primary" type="submit" name="login" value="Login" style="margin-left:660px;margin-top:30px;">Login</button>
<jsp:include page="frammenti/html/script.html"></jsp:include>
</form>
</body>
</html>