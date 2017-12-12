package com.trabalho.ifrs.appeventos;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AboutActivity extends AppCompatActivity {
    private Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        event = (Event) getIntent().getExtras().getSerializable("event");
        EventAboutFragment fragment = (EventAboutFragment) getSupportFragmentManager().findFragmentById(R.id.frag);
        fragment.setText(event);
    }

    public Event getEvent(){
        return event;
    }
}
