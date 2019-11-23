package com.example.firestore.fetchbyadd;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.firestore.R;

import java.util.List;

public class joinshow_eventadapter extends ArrayAdapter<event_mofel_ofstudnet> {
    private Activity Context;
    private List<event_mofel_ofstudnet> joinclublist;
    public joinshow_eventadapter(Activity context,List<event_mofel_ofstudnet> joinclub){
        super(context, R.layout.listview_artist,joinclub);
        this.Context=context;
        this.joinclublist=joinclub;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=Context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.listview_artist,null,true);
        TextView textViewnmae=(TextView)listviewitem.findViewById(R.id.name_injoinclub);
        TextView textViewdesc=(TextView)listviewitem.findViewById(R.id.clubdescriptionjoinclub);
        TextView textdate=(TextView)listviewitem.findViewById(R.id.date_injoinclubs);
        TextView textpuchid_join=(TextView)listviewitem.findViewById(R.id.puchid_i_injoinclubs);
        final event_mofel_ofstudnet event_mofel_ofstudnetl=joinclublist.get(position);

        textViewnmae.setText(event_mofel_ofstudnetl.getEvent_name());
        textViewdesc.setText(event_mofel_ofstudnetl.getEvent_description());
        textdate.setText(event_mofel_ofstudnetl.getEvent_date());
        textpuchid_join.setText(event_mofel_ofstudnetl.getClub_position());

        return listviewitem;

    }

}

