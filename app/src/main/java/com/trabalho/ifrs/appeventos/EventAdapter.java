package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by marcos on 09/12/2017.
 * Adapter e ViewHolder
 */

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {
    private Context contexto;
    private List<Event> eventsList;

    public EventAdapter(Context contexto, List<Event> eventsList) {
        this.contexto = contexto;
        this.eventsList = eventsList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(contexto);
        View view = inflater.inflate(R.layout.layout_card_events,null);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder,final int position) {
        final Event event = eventsList.get(position);

        holder.textTitleEvent.setText(event.getName());
        holder.textDescEvent.setText(event.getUrl());

        Picasso.with(contexto).load(event.getImg()).into(holder.imageEvent);

        holder.btnEntrar.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 entrarEvento(v, event);
             }
        });
    }
    protected void message(View view,String message){
        Snackbar snackbar = Snackbar
                .make(view, message, 3000);
        snackbar.show();
    }

    public void entrarEvento(View v,Event event){
        message(v, (event.getName()));
        //Intent intencao = new Intent(this, ListRecyclerEvent.class);
        //startActivity(intencao);
    }

    @Override
    public int getItemCount() {
        return eventsList != null ? eventsList.size() : 0;
    }

    class EventViewHolder extends RecyclerView.ViewHolder{
        ImageView imageEvent;
        TextView textTitleEvent;
        TextView textDescEvent;
        Button btnEntrar;

        public EventViewHolder(View view){
            super(view);
            imageEvent = view.findViewById(R.id.imgEvent);
            textTitleEvent = view.findViewById(R.id.txtTitleEvent);
            textDescEvent = view.findViewById(R.id.txtDescEvent);
            btnEntrar = view.findViewById(R.id.btnEnterEvent);
        }
    }

}
