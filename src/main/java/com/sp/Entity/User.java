package com.sp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cardUser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String token;
    private String name;
    private String surname;
    private String login;
    private String password;
    private int balance;

    public User(
            String token,
            String name,
            String surname,
            String login,
            String password,
            int balance
    ) {
        this.token = token;
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.balance = balance;
    }

    public User() {
        this.token = "";
        this.name = "";
        this.surname = "";
        this.login = "";
        this.password = "";
        this.balance = 0;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}

