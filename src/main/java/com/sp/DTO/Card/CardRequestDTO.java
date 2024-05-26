package com.sp.DTO.Card;

public class CardRequestDTO {
    private String name;
    private String description;
    private String image;
    private String family;
    private String affinity;
    private int hp;
    private int energy;
    private int attack;
    private int defence;
    private int price;
    private boolean isForSell;

    public CardRequestDTO() {
        this.name = "";
        this.description = "";
        this.image = "";
        this.family = "";
        this.affinity = "";
        this.hp = 0;
        this.energy = 0;
        this.attack = 0;
        this.defence = 0;
        this.price = 0;
        this.isForSell = false;
    }

    public CardRequestDTO setName(String name) {
        this.name = name;
        return this;
    }

    public CardRequestDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public CardRequestDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public CardRequestDTO setFamily(String family) {
        this.family = family;
        return this;
    }

    public CardRequestDTO setAffinity(String affinity) {
        this.affinity = affinity;
        return this;
    }

    public CardRequestDTO setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public CardRequestDTO setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public CardRequestDTO setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public CardRequestDTO setDefence(int defence) {
        this.defence = defence;
        return this;
    }

    public CardRequestDTO setPrice(int price) {
        this.price = price;
        return this;
    }

    public CardRequestDTO setForSall(boolean forSall) {
        isForSell = forSall;
        return this;
    }


    public CardRequestDTO(String name, String description, String image, String family, String affinity, int hp, int energy, int attack, int defence,int price, boolean isForSell) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defence = defence;
        this.price=price;
        this.isForSell = isForSell;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getImage() {
        return image;
    }

    public String getFamily() {
        return family;
    }

    public String getAffinity() {
        return affinity;
    }

    public int getHp() {
        return hp;
    }

    public int getEnergy() {
        return energy;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefence() {
        return defence;
    }

    public int getPrice() {
        return price;
    }

    public boolean isForSell() {
        return isForSell;
    }

}

