package com.trabalho.ifrs.appeventos;

/**
 * Created by marcos on 18/11/2017.
 */

public class User {
    private String name;
    private String pass;

    public String getNome() {
        return name;
    }

    public void setNome(String nome) {
        this.name = nome;
    }

    public String getSenha() {
        return pass;
    }

    public void setSenha(String senha) {
        this.pass = senha;
    }
    @Override
    public String toString() {
        return "User{" + "nome='" + name + " - Senha='"+pass+"'}";
    }
}
