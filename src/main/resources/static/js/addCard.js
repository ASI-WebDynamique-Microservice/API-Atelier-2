$(document).ready(function(){
    var postUrl = 'http://localhost:8080/cards'; // Stocke l'URL dans une variable

    // Met à jour les valeurs initiales des curseurs
    $('#hpValue').text($('#hp').val());
    $('#energyValue').text($('#energy').val());
    $('#attackValue').text($('#attack').val());
    $('#defenceValue').text($('#defence').val());
    $('#priceValue').text($('#price').val());


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
            name: data['card-name'],
            description: data['card-description'],
            family: data['card-category'],
            affinity: data['card-affinity'],
            image: data['card-url'],
            energy: parseInt(data['energy']),
            hp: parseInt(data['hp']),
            defence: parseInt(data['defence']),
            attack: parseInt(data['attack']),
            price: parseInt(data['price']),
            isForSale: parseInt(data['isForSell']),
        };

        // Affiche les valeurs des champs dans la console
        console.log(JSON.stringify(apiData));

        // Envoi des données en POST
        $.ajax({
            url: postUrl,
            type: 'POST',
            data: JSON.stringify(apiData),
            contentType: 'application/json',
            headers: {
                "TOKEN": sessionStorage.getItem('sessionId'),
            },
            success: function(data){
                console.log(data);
                window.location.href = "http://localhost/card.html";
            },
            error: function(err){
                console.log('Erreur:', err);
                console.log('Détails de l\'erreur:', err.responseText);
            },
        });
    });

    // Met à jour les valeurs des curseurs lorsque l'utilisateur les déplace
    $('#hp').on('input', function() {
        $('#hpValue').text($(this).val());
    });
    $('#energy').on('input', function() {
        $('#energyValue').text($(this).val());
    });
    $('#attack').on('input', function() {
        $('#attackValue').text($(this).val());
    });
    $('#defence').on('input', function() {
        $('#defenceValue').text($(this).val());
    });
    $('#price').on('input', function() {
        $('#priceValue').text($(this).val());
    });
});