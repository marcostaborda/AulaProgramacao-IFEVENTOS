package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Context context;
    private EditText username;
    private EditText userpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){
        username = (EditText) findViewById(R.id.editUserName);
        userpass = (EditText) findViewById(R.id.editPass);
        User u = new User();
        u.setNome(username.getText().toString());
        u.setSenha(userpass.getText().toString());
    }

    protected void message(String message){
        Toast.makeText(this, message,
                Toast.LENGTH_LONG).show();
    }
}
