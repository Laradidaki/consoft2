<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="http://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script>
$.validator.setDefaults({
    submitHandler: function() {
      alert("boh");
    }
});
$().ready(function() {

  $("#signupForm").validate({
	    rules: {
	      firstname: "required",
	      lastname: "required",
	      username: {
	        required: true,
	        minlength: 2
	      },
	      password: {
	        required: true,
	        minlength: 5
	      },
	      confirm_password: {
	        required: true,
	        minlength: 5,
	        equalTo: "#password"
	      },
	      email: {
	        required: true,
	        email: true
	      },
	      "topic[]": {
	        required: "#newsletter:checked",
	        minlength: 2
	      },
	      agree: "required"
	    },
	    messages: {
	      firstname: "Lara",
	      lastname: "Corona",
	      username: {
	        required: "true",
	        minlength: "8"
	      },
	      password: {
	        required: "true",
	        minlength: "8"
	      },
	      confirm_password: {
	        required: "true",
	        minlength: "8",
	        equalTo: "password"
	      },
	      agree: "required",
	    }
	});
});
</script>
<style>
.error{
	color:red;
}
</style>
</head>
<body>

<form class="cmxform" id="signupForm" method="get" action="">
  <fieldset>
    <legend></legend>
    <p>
      <label for="firstname">nome</label>
      <input id="firstname" name="firstname" type="text">
    </p>
    <p>
      <label for="lastname">cognome</label>
      <input id="lastname" name="lastname" type="text">
    </p>
    <p>
      <label for="username">username</label>
      <input id="username" name="username" type="text">
    </p>
    <p>
      <label for="password">password</label>
      <input id="password" name="password" type="password">
    </p>
    <p>
      <label for="confirm_password">conferma password</label>
      <input id="confirm_password" name="confirm_password" type="password">
    </p>
    <p>
      <label for="email">Email</label>
      <input id="email" name="email" type="email">
    </p>
    <p>
      <label for="agree">consenso</label>
      <input type="checkbox" class="checkbox" id="agree" name="agree">
    </p>
    <p>
      <input class="submit" type="submit" value="invia">
    </p>
  </fieldset>
</form>

</body>
</html>