package com.trabalho.ifrs.appeventos;

/**
 * Created by marcos on 18/11/2017.
 */

public class User {
    private long _ID;
    private String name;
    private String pass;

    public User(long _ID, String name, String pass) {
        this._ID = _ID;
        this.name = name;
        this.pass = pass;
    }

    public User(){}
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

    public long get_ID() {
        return _ID;
    }

    public void set_ID(long _ID) {
        this._ID = _ID;
    }
}
