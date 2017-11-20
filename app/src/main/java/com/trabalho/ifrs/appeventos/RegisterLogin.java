package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class RegisterLogin extends AppCompatActivity {
    private Context context;
    private TextInputEditText username;
    private TextInputEditText userpass;
    private TextInputLayout layoutTextUserName;
    private TextInputLayout layoutTextUserPass;
    private BDUtilLogin bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_login);
    }

    public void voltar(View view){
        Intent intencao = new Intent(this, MainActivity.class);
        startActivity(intencao);
    }

    public void cadastrar(View view){
        layoutTextUserName  = (TextInputLayout) findViewById(R.id.text_input_userName);
        layoutTextUserPass  = (TextInputLayout) findViewById(R.id.text_input_userpass);

        username = (TextInputEditText) findViewById(R.id.editUserName);
        userpass = (TextInputEditText) findViewById(R.id.editPass);

        if (username.length() > 0){
            if (userpass.length() > 0){
                User u = new User();
                u.setNome(username.getText().toString());
                u.setSenha(userpass.getText().toString());
                bd = new BDUtilLogin(this);
                if (bd.ifExistUser(u)){
                    message(view,"Erro ao cadastrar usuário já existe", 2000);
                }else{
                    if (bd.addUser(u)>0){
                        Intent intencao = new Intent(this, MainActivity.class);
                        intencao.putExtra("result", true);
                        startActivity(intencao);
                    }else{
                        message(view,"Erro ao cadastrar", 2000);
                    }
                }
            }else{
                layoutTextUserPass.setError("Senha não pode ser em branco");
            }
        }else{
            layoutTextUserName.setError("Nome de usuário não pode ficar em branco.");
        }
    }

    protected void message(View view, String message, int duracao){
        Snackbar snackbar = Snackbar
                .make(view, message, duracao);
        snackbar.show();
    }
}
