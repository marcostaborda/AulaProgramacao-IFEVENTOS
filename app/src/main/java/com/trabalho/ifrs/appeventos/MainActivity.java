package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private TextInputEditText username;
    private TextInputEditText userpass;
    private BDUtilLogin bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intencao = getIntent();
        boolean msg = intencao.getBooleanExtra("result",false);
        if (msg){
            message(findViewById(android.R.id.content),"Cadastro realizado com sucesso");
        }
    }

    public void login(View view){
        username = (TextInputEditText) findViewById(R.id.editUserName);
        userpass = (TextInputEditText) findViewById(R.id.editPass);
        User u = new User();
        u.setNome(username.getText().toString());
        u.setSenha(userpass.getText().toString());
        bd = new BDUtilLogin(this);
        if (bd.Auth(u) != null){
            Intent intencao = new Intent(this, ListaEventosActivity.class);
            startActivity(intencao);
        }else{
            message(view,"Erro ao logar");
        }

    }

    public void registar(View view){
        Intent intencao = new Intent(this, RegisterLogin.class);
        startActivity(intencao);
    }

    protected void message(View view,String message){
        Snackbar snackbar = Snackbar
                .make(view, message, 3000);
        snackbar.show();
    }
}
