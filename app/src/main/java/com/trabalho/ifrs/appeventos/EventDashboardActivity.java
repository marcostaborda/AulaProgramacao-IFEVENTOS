package com.trabalho.ifrs.appeventos;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class EventDashboardActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_dashboard);
        Event event = (Event) getIntent().getExtras().getSerializable("event");
        TextView title1 = (TextView) findViewById(R.id.txtTitle);
        title1.setText("Evento - "+event.getName());
        setEvent(event);

        //title.setText("Evento - "+event.getName());
        //Picasso.with(this).load(event.getImg()).into((ImageView) findViewById(R.id.eventImgAbout));

        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);
        //getSupportActionBar().setDisplayShowTitleEnabled(false);

    }

    private void setEvent(final Event e)
    {
        //set Onclick Cards
        CardView cardSobre = (CardView) findViewById(R.id.sobreCard);
        CardView cardSite = (CardView) findViewById(R.id.siteCard);
        CardView cardEquipe = (CardView) findViewById(R.id.equipeCard);
        CardView cardPalestrantes = (CardView) findViewById(R.id.palestrantesCard);
        CardView cardNews = (CardView) findViewById(R.id.newsCard);
        CardView cardGit = (CardView) findViewById(R.id.gitHubCard);

        cardSobre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intencao = new Intent(view.getContext(), AboutActivity.class);
                intencao.putExtra("event", e);
                view.getContext().startActivity(intencao);
            }
        });
        cardSite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(e.getUrl()));
                startActivity(intent);
            }
        });
        cardEquipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDashboardActivity.this, "Não temos equipe", Toast.LENGTH_SHORT).show();
            }
        });
        cardPalestrantes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDashboardActivity.this, "Não temos palestrante", Toast.LENGTH_SHORT).show();
            }
        });
        cardNews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDashboardActivity.this, "Não temos novidades", Toast.LENGTH_SHORT).show();
            }
        });
        cardGit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EventDashboardActivity.this, "Não temos GitHub", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
