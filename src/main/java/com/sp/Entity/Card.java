package com.sp.Entity;

import jakarta.persistence.*;

@Entity
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    public Card(
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
            boolean isForSell
    ) {
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
    }

    public Card() {
        this.name = "";
        this.description = "";
        this.image = "";
        this.family = "";
        this.affinity = "";
        this.hp = 0;
        this.energy = 0;
        this.attack = 0;
        this.defence = 0;
        int price = 0;
        boolean isForSell = false;
    }

    public Long getId() {
        return id;
    }

    public Card setId(Long id) {
        this.id = id;
        return this;
    }


    public String getName() {
        return name;
    }

    public Card setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Card setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getImage() {
        return image;
    }

    public Card setImage(String image) {
        this.image = image;
        return this;
    }

    public String getFamily() {
        return family;
    }

    public Card setFamily(String family) {
        this.family = family;
        return this;
    }

    public String getAffinity() {
        return affinity;
    }

    public Card setAffinity(String affinity) {
        this.affinity = affinity;
        return this;
    }

    public int getHp() {
        return hp;
    }

    public Card setHp(int hp) {
        this.hp = hp;
        return this;
    }

    public int getEnergy() {
        return energy;
    }

    public Card setEnergy(int energy) {
        this.energy = energy;
        return this;
    }

    public int getAttack() {
        return attack;
    }

    public Card setAttack(int attack) {
        this.attack = attack;
        return this;
    }

    public int getDefence() {
        return defence;
    }

    public Card setDefence(int defence) {
        this.defence = defence;
        return this;
    }

    public User getUser() {
        return user;
    }

    public Card setUser(User user) {
        
        this.user = user;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Card setPrice(int price) {
        this.price = price;
        return this;
    }

    public boolean isForSell() {
        return isForSell;
    }

    public Card setForSell(boolean forSell) {
        isForSell = forSell;
        return this;
    }
}
