package com.trabalho.ifrs.appeventos;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class EventFragmentList extends ListFragment {


    public EventFragmentList(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle args = getActivity().getIntent().getExtras();
        //Event event = (Event) args.getString("event");
        ArrayAdapter<Event> adapter = new ArrayAdapter<Event>(inflater.getContext(), android.R.layout.simple_list_item_1, Event.eventsLocal());
        setListAdapter(adapter);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onListItemClick(ListView list, View view, int position, long id){
        super.onListItemClick(list, view, position, id);
        Activity activity = getActivity();

        if(activity instanceof EventListListener){
            Event event = (Event) list.getItemAtPosition(position);
            EventListListener listener = (EventListListener)activity;
            listener.onClickEvent(event);
        }
    }
    public interface EventListListener{
        public void onClickEvent(Event hotel);
    }

}
