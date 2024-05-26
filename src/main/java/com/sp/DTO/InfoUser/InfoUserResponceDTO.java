package com.sp.DTO.InfoUser;

public class InfoUserResponceDTO {
    public InfoUserResponceDTO(
            String name,
            String surname,
            String login,
            int balance
    ) {
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.balance = balance;
    }

    public InfoUserResponceDTO() {
        this.name = "";
        this.surname = "";
        this.login = "";
        this.balance = 0;
    }
    private String name;
    private String surname;
    private String login;
    private int balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
