package com.model;

public class User {
    private String cpf;
    private String nome;
    private String email;
    private String phone;
    private String profile;
    private String password;

    public User() {
        super();
    }

    public User(String cpf, String nome, String email, String phone, String profile, String password) {
        super();    
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.phone = phone;
        this.profile = profile;
        this.password = password;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
