// window.history.pushState({}, null, '/login');

$(document).ready(function(){
    var postUrl = 'http://localhost:8080/login'; // Stocke l'URL dans une variable

    $(".ui.form").on('submit', function(event){
        event.preventDefault();
        
        // Récupère toutes les valeurs du formulaire
        var formData = $(this).serializeArray();

        // Transforme le tableau en objet pour une utilisation plus facile
        var data = {};
        $(formData).each(function(index, obj){
            data[obj.name] = obj.value;
        });

        // Crée un nouvel objet avec le format attendu par l'API
        var apiData = {
            login: data['username'],
            password: data['pwd'],
        };
        console.log(apiData);

        // Envoi des données en POST
        $.ajax({
            url: postUrl,
            type: 'POST',
            data: JSON.stringify(apiData),
            contentType: 'application/json',
            success: function(data) {
                sessionStorage.setItem('sessionId', data.token);
                window.location.href = "/index.html";
            },
            error: function(err){
                console.log('Erreur:', err);

                // Affiche un message d'erreur
                document.getElementById('errorMessage').textContent = "Login ou mot de passe incorrect";
                // Réinitialise le formulaire
                $(".ui.form").trigger('reset');
                // console.log('Détails de l\'erreur:', err.responseText);
            },
        });
    });
});