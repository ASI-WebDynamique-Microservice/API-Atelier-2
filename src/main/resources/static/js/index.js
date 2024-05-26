$(document).ready(function() {

    var getUrl = 'http://localhost:8080/user/info'; // Stocke l'URL dans une variable

    $.ajax({
        url: getUrl,
        type: 'GET',
        headers: {
            "TOKEN": sessionStorage.getItem('sessionId'),
        },
        success: function(data) {
            sessionStorage.setItem('username', data.login);
            sessionStorage.setItem('surname', data.surname);
            sessionStorage.setItem('lastname', data.name);
        }
    }); 
    
    document.getElementById('sellButton').addEventListener('click', function() {
        window.location.href = '/pages/sell.html';
    });

    document.getElementById('buyButton').addEventListener('click', function() {
        window.location.href = '/pages/buy.html';
    });
});

