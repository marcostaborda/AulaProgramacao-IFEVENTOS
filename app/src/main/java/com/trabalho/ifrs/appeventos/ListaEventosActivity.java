package com.trabalho.ifrs.appeventos;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ListaEventosActivity extends AppCompatActivity implements
        EventFragmentList.EventListListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_eventos);
    }


    @Override
    public void onClickEvent(Event evento){
        View fragmentConteiner = findViewById(R.id.detalhe);
            EventFragmentDetail fragmento = EventFragmentDetail.novaInstancia(evento);
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.detalhe, fragmento, EventFragmentDetail.TAG_DETALHE);
            ft.commit();
    }
}
