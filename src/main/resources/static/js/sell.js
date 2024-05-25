$(document).ready(function() {
    var getUserInfo = 'http://localhost:8080/user/info';
    var getCardsList = 'http://localhost:8080/cards';
    var username = sessionStorage.getItem('username');

    document.getElementById('userNameId').textContent = username

    $.ajax({
        url: getUserInfo,
        type: 'GET',
        headers: {
            "TOKEN": sessionStorage.getItem('sessionId'),
        },
        success: function(data) {
            document.getElementById('userMoney').textContent = data.balance;
        }
    }); 

    $.ajax({
        url: getCardsList,
        type: 'GET',
        headers: {
            "TOKEN": sessionStorage.getItem('sessionId'),
        },
        success: function(data) {
            console.log(data)
            cardList = data 
            spawnCards(cardList)
        }
    });

    function spawnCards(cardList){
        let template = document.querySelector("#row");
    
        for(const card of cardList){
            if(card.login == username){
                let clone = document.importNode(template.content, true);
    
                newContent= clone.firstElementChild.innerHTML
                            .replace(/{{family_src}}/g, card.family_src)
                            .replace(/{{family_name}}/g, card.family)
                            .replace(/{{img_src}}/g, card.img_src)
                            .replace(/{{name}}/g, card.name)
                            .replace(/{{description}}/g, card.description)
                            .replace(/{{hp}}/g, card.hp)
                            .replace(/{{energy}}/g, card.energy)
                            .replace(/{{attack}}/g, card.attack)
                            .replace(/{{defence}}/g, card.defence)
                            .replace(/{{price}}/g, card.price);
                clone.firstElementChild.innerHTML= newContent;

                // Si la carte est en vente
                if(card.forSell) {
                    let sellButton = clone.firstElementChild.querySelector("#sellButton");
                    sellButton.className = "ui button";
                    sellButton.innerHTML = "En vente";
                } else {
                    // Ajoutez un écouteur d'événements "mouseover" à la carte
                    clone.firstElementChild.addEventListener("mouseover", function() {
                        // Charge le contenu de la page card-full.html
                        $("#card").load("../part/card.html", function() {
                            // Remplit les éléments de la carte avec les données spécifiques de la carte
                            document.querySelector("#cardHPId").textContent = card.hp;
                            document.querySelector("#energyId").textContent = card.energy;
                            document.querySelector("#cardNameId").textContent = card.name;
                            document.querySelector("#cardDescriptionId").textContent = card.description;
                            document.querySelector("#cardAttackId").textContent = "Attack " + card.attack;
                            document.querySelector("#cardDefenceId").textContent = "Defense " + card.defense;
                            document.querySelector("#cardPriceId").textContent = card.price + "$";
                            //document.querySelector("#cardImgId").src = card.img_src;
                        });
                    });
                }

                clone.firstElementChild.querySelector("#sellButton").addEventListener("click", function() {
                    if(!card.forSell) {
                        var sellCardUrl = 'http://localhost:8080/sellCard/'+ card.id;
                
                        $.ajax({
                            url: sellCardUrl,
                            type: 'GET',
                            headers: {
                                "TOKEN": sessionStorage.getItem('sessionId'),
                            },
                            success: function(data) {
                                alert("Carte mise en vente avec succès !");
                                window.location.reload();
                            }
                        });
                    }
                });

                let cardContainer= document.querySelector("#tableContent");
                cardContainer.appendChild(clone);
            }
        }
    }
});



