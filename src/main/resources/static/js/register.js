// window.history.pushState({}, null, '/register');

$(document).ready(function(){
    var postUrl = 'http://localhost:8080/user/new'; // Stocke l'URL dans une variable

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
            name: data['name'],
            surname: data['surname'],
            password: data['pwd']
        };

        // Envoi des données en POST
        $.ajax({
            url: postUrl,
            type: 'POST',
            data: JSON.stringify(apiData),
            contentType: 'application/json',
            success: function(data){
                console.log(data);
                window.location.href = "/pages/login.html";
            },
            error: function(err){
                console.log('Erreur:', err);
                console.log('Détails de l\'erreur:', err.responseText);
            },
        });
    });
});