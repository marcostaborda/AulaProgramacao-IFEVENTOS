package com.trabalho.ifrs.appeventos;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListRecyclerEvent extends AppCompatActivity {
    ProgressDialog dialog;
    private RecyclerView recycler;
    List<Event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler_eventos);
        recycler = findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();

        AcessRestEvent acess = AcessRestEvent.retrofit.create(AcessRestEvent.class);
        final Call<List<Event>> callEvent = acess.getEvents();

        dialog = new ProgressDialog(this);
        dialog.setMessage("Carregando...");
        dialog.setCancelable(false);
        dialog.show();


        callEvent.enqueue(new Callback<List<Event>>() {
            @Override
            public void onResponse(Call<List<Event>> call, Response<List<Event>> response) {
                if (dialog.isShowing())
                    dialog.dismiss();
                int statusCode = response.code();
                if (statusCode == 200){
                    List<Event> listaEvents = response.body();
                    EventAdapter adapter = new EventAdapter(listaEvents);
                    recycler.setAdapter(adapter);
                    for(Event e : listaEvents){
                        Log.d("Evento:", e.toString());
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Event>> call, Throwable t) {
                if (dialog.isShowing())
                    dialog.dismiss();
                Log.d("Evento:", t.toString());
            }
        });

        eventList = Event.eventsLocal();



    }

}
