package com.example.firestore.teacher_create_club_only;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.firestore.R;

import java.util.List;

public class create_event_adapter extends ArrayAdapter<create_event_model> {
    private Activity Context;
    private List<create_event_model> createevent;
    public create_event_adapter(Activity context,List<create_event_model> createevent){
        super(context, R.layout.clublist,createevent);
        this.Context=context;
        this.createevent=createevent;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=Context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.eventlist,null,true);
        TextView textViewnmae=(TextView)listviewitem.findViewById(R.id.nameevent);
        TextView textViewdesc=(TextView)listviewitem.findViewById(R.id.on_event_description);
        TextView textdate=(TextView)listviewitem.findViewById(R.id.date_event);
        create_event_model create_event_model =createevent.get(position);

        textViewnmae.setText(create_event_model.getEvent_name());
        textViewdesc.setText(create_event_model.getEvent_description());
        textdate.setText(create_event_model.getEvent_date());
        return listviewitem;

    }
}
