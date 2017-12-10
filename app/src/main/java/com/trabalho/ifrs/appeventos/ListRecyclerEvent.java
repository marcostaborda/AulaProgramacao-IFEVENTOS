package com.trabalho.ifrs.appeventos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ListRecyclerEvent extends AppCompatActivity {

    RecyclerView recycler;
    EventAdapter eventAdapter;

    List<Event> eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_recycler_eventos);

        recycler = (RecyclerView) findViewById(R.id.recyclerView);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        eventAdapter = new EventAdapter(this, Event.eventos());

        recycler.setAdapter(eventAdapter);

    }
}
