<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://fonts.googleapis.com/css?family=Akronim|Sofia|Stylish" rel="stylesheet">
<meta charset="ISO-8859-1">

<title>Registrazione</title>
<jsp:include page="frammenti/html/navbar.html"></jsp:include>
<jsp:include page="frammenti/html/bootstrap.html"></jsp:include>
<style type="text/css">

#tuodiv {
width: 100%; height: 100%; top: 0; left: 0;
background: url(immagini/inception.jpg) no-repeat center top; position: fixed; z-index: -1;
-webkit-background-size: cover;
-moz-background-size: cover;
-o-background-size: cover;
background-size: cover;
}
label{
color:white;
}

.needs-validation{
 	width:50%;
    position: absolute;
    top: 15%;
    left: 35%;
}
.password{
width:100%;
    position: relative;
    top: 250%;
    left:18%;
    
}
</style>
</head>
<body>
<div id="tuodiv">
<form class="needs-validation" action="<%= request.getContextPath()+"/registrazione" %>" method="post" novalidate>
  <div class="form-row">
    <div class="col-md-4 mb-3" id="nome">
      <label for="validationCustom01">Nome</label>
      <input type="text" class="form-control" name="nome" id="validationCustom01" placeholder="First name" value="" required>
    <div class="invalid-feedback">
          Please choose a name.
     
      </div>
    </div>
   
    <div class="col-md-4 mb-3" id="cognome">
      <label for="validationCustom02">Cognome</label>
      <input type="text" class="form-control" name="cognome" id="validationCustom02" placeholder="Last name" value="" required>
    <div class="invalid-feedback">
          Please choose a surname.
     
      </div>
    </div>
     <div class="password">
    <div class="col-md-4 mb-3" id="username">
      <label for="validationCustom02">Username</label>
      <input type="text" class="form-control" name="username" id="username" placeholder="Username" value="" required>     
      <div class="invalid-feedback">
          Please choose a username.         
      </div>
       <span id="controllo"></span>
    </div>
   
  <div class="col-md-4 mb-3" id="password1">
      <label for="validationCustom02">Password</label>
      <input type="text" class="form-control" name="password" id="password" placeholder="Password" value="" required>
      <div class="invalid-feedback">
          Please choose a password.
     </div>
      </div>
        <div class="col-md-4 mb-3" id="confpassword">
      <label for="validationCustom02"> Conferma Password</label>
      <input type="text" class="form-control" name="confPassword" id="confirm_password" placeholder="Password" value="" required>
      <div class="invalid-feedback">
          Le password devono coincidere.
     </div>
      </div>
    </div>


  <div class="form-group" style="position:relative; left:18%;">
    <div class="form-check">
      <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
      <label class="form-check-label" for="invalidCheck">
        Agree to terms and conditions
      </label>
      <div class="invalid-feedback">
        You must agree before submitting.
      </div>
    </div>
  </div>
  <button class="btn btn-primary" type="submit" style="position:absolute; left:26%; bottom:-10%;">Submit form</button>

</form>
</div>
<script>
// Example starter JavaScript for disabling form submissions if there are invalid fields
(function() {
  'use strict';
  window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
        if (form.checkValidity() === false) {
          event.preventDefault();
          event.stopPropagation();
        }
        form.classList.add('was-validated');
      }, false);
    });
  }, false);
})();
</script>
<script>
var password = document.getElementById("password")
, confirm_password = document.getElementById("confirm_password");

function validatePassword(){
if(password.value != confirm_password.value) {
  confirm_password.setCustomValidity("Passwords Don't Match");
} else {
  confirm_password.setCustomValidity('');
}
}

password.onchange = validatePassword;
confirm_password.onkeyup = validatePassword;
</script>
<script type="text/javascript">
$(document).ready(function(){
	$('#username').blur(function(){
		$.post("/CinemaWeb/VerificaUtente",{ username:$('#username').val()}, function(data, status){
			if(data==1){
				$('#controllo').html("Utente già registrato");
			}
			else{
				$('#controllo').html("diuwhri");
			}
		});
	});
});
</script>
<jsp:include page="frammenti/html/script.html"></jsp:include>
</body>
</html>