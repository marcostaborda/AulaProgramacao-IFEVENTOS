package com.trabalho.ifrs.appeventos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class EventAboutFragment extends Fragment {

    public EventAboutFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_event_about, container, false);
    }

    public void setText(Event e) {
        TextView titleEventName = (TextView) getView().findViewById(R.id.titleEventName);
        TextView sobreEvento = (TextView) getView().findViewById(R.id.titleSobreEvent);
        titleEventName.setText("Evento - "+ e.getName());
        sobreEvento.setText(e.sobre);
    }

}
