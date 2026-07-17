package org.example.entities;

public class User {
    private String login;
    private String password;

    public User(String log, String pass) {
        login = log;
        password = pass;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }
    public String getPassword() {
        return password;
    }
}