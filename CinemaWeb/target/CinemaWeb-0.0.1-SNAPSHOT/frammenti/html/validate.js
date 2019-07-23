$().ready(function() {
    // Selezione form e definizione dei metodi di validazione
    $(".needs-validation").validate({
        rules : {
            nome : {
              required : true
            },
            cognome : {
                required : true
              },
            username : {
                required : true,
                email : true
            },
            password : {
                required : true,
                minlength : 5,
                maxlength : 8
            }
        },
        
        messages: {
            usernameEmail: "Inserisci lo username o la email",
            password: {
                required: "Inserisci una password password",
                minlength: "La password deve essere lunga minimo 5 caratteri",
                maxlength: "La password deve essere lunga al massimo 8 caratteri"
            },
            email: "Inserisci la tua email"
        },
        submitHandler: function(form) {
            form.submit();
        }
    });
});