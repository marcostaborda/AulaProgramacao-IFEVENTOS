package com.trabalho.ifrs.appeventos;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragmentDetail extends Fragment {
    private Event objEvent;
    public static final String TAG_DETALHE = "tagDetalhe";

    public static EventFragmentDetail novaInstancia(Event evento){
        Bundle parametros = new Bundle();
        parametros.putSerializable("evento", evento);
        EventFragmentDetail fragment = new EventFragmentDetail();
        fragment.setArguments(parametros);
        return fragment;
    }
    public EventFragmentDetail() {

    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        objEvent = (Event) getArguments().getSerializable("evento");
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Context c = getActivity().getApplicationContext();
        View layout = inflater.inflate(R.layout.fragment_event_fragment_detail, container, false);
        TextView txtNome = (TextView) layout.findViewById(R.id.txtNomeEvento);
        Button site = (Button) layout.findViewById(R.id.btnSite);
        ImageView imgEvent = (ImageView) layout.findViewById(R.id.eventImage);
        if(objEvent != null){
            txtNome.setText(objEvent.getName());
            Picasso.with(c).load(objEvent.getImg()).into(imgEvent);
        }
        site.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(objEvent.getUrl()));
                getActivity().startActivity(intent);
            }
        });
        return layout;
    }

}
