$(document).ready(function() {
    var getUserInfo = 'http://localhost:8080/user/info';
    var getCardsList = 'http://localhost:8080/cards';

    document.getElementById('userNameId').textContent = sessionStorage.getItem('username');

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
    
        for(const card of cardList) {
            if (card.forSell) {
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
                            .replace(/{{defense}}/g, card.defence)
                            .replace(/{{price}}/g, card.price);
                clone.firstElementChild.innerHTML= newContent;
    
                // Ajoutez un écouteur d'événements "mouseover" à la carte
                clone.firstElementChild.addEventListener("mouseover", function() {
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
            
                // Ajoutez un écouteur d'événements "click" sur le bouton "Buy"
                clone.firstElementChild.querySelector("#buyButton").addEventListener("click", function() {
                    
                    var buyCardUrl = 'http://localhost:8080/buyCard/'+ card.id;
            
                    $.ajax({
                        url: buyCardUrl,
                        type: 'GET',
                        headers: {
                            "TOKEN": sessionStorage.getItem('sessionId'),
                        },
                        success: function(data) {
                            alert("Carte achetée avec succès, vous pouvez la retrouver dans votre collection !");
                            window.location.reload();
                        }
                    });
                });

                let cardContainer= document.querySelector("#tableContent");
                cardContainer.appendChild(clone);
            }
        }
    }
});
