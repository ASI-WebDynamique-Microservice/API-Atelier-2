package com.sp.DTO;

public class CardFormDTO {
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

    public CardFormDTO() {
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
        this.isForSell = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public void setAffinity(String affinity) {
        this.affinity = affinity;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public CardFormDTO(String name, String description, String image, String family, String affinity, int hp, int energy, int attack, int defence, int price, boolean isForSell) {
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

