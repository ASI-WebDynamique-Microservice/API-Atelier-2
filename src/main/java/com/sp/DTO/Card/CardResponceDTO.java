package com.sp.DTO.Card;

import com.sp.Entity.User;

public class CardResponceDTO {
    private Long id;
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
    private String login;

    public CardResponceDTO(
            Long id,
            String name,
            String description,
            String image,
            String family,
            String affinity,
            int hp,
            int energy,
            int attack,
            int defence,
            int price,
            boolean isForSell,
            String login
    ) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.image = image;
        this.family = family;
        this.affinity = affinity;
        this.hp = hp;
        this.energy = energy;
        this.attack = attack;
        this.defence = defence;
        this.price = price;
        this.isForSell = isForSell;
        this.login = login;
    }
    public CardResponceDTO()
    {
        this.id = null;
        this.name = "";
        this.description = "";
        this.image = "image";
        this.family = "family";
        this.affinity = "affinity";
        this.hp = 0;
        this.energy = 0;
        this.attack = 0;
        this.defence = 0;
        this.price = 0;
        this.isForSell = false;
        this.login = "";
    }

    public Long getId() {
        return id;
    }

    public CardResponceDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public CardResponceDTO setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public CardResponceDTO setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public CardResponceDTO setImage(String image) {
        this.image = image;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public CardResponceDTO setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getAffinity() {
        return affinity;
    }

    public CardResponceDTO setAffinity(String affinity) {
        this.affinity = affinity;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public CardResponceDTO setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getEnergy() {
        return energy;
    }

    public CardResponceDTO setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public CardResponceDTO setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getDefence() {
        return defence;
    }

    public CardResponceDTO setDefence(int defence) {
        this.defence = defence;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public CardResponceDTO setPrice(int price) {
        this.price = price;
        return this;
    }

    public boolean isForSell() {
        return isForSell;
    }

    public CardResponceDTO setForSell(boolean forSell) {
        isForSell = forSell;
        return this;
    }

    public String getLogin() {
        return login;
    }

    public CardResponceDTO setLogin(String login) {
        this.login = login;
        return this;
    }
}
