package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ListRecyclerEvent extends AppCompatActivity {

    private RecyclerView recycler = (RecyclerView) findViewById(R.id.recyclerView);
    Context mcontext;
    private static final String URL_eventos = "http://localhost:8080/ServicoREST/rest/events";
    List<Event> eventList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recycler.setHasFixedSize(true);
        recycler.setLayoutManager(new LinearLayoutManager(this));

        eventList = new ArrayList<>();
        EventAdapter adapter = new EventAdapter(this, EventService.events());

        recycler.setAdapter(adapter);
    }

}
