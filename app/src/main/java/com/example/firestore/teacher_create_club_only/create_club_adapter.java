package com.example.firestore.teacher_create_club_only;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;


import com.example.firestore.Club_data_modl;
import com.example.firestore.R;
import com.example.firestore.fetchbyadd.joinclub_model;

import java.util.List;

public class create_club_adapter extends ArrayAdapter<Club_data_modl> {
    private Activity Context;
    private List<Club_data_modl> createclub;

    public create_club_adapter(Activity context,List<Club_data_modl> createclub){
        super(context,R.layout.clublist,createclub);
        this.Context=context;
        this.createclub=createclub;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=Context.getLayoutInflater();
        View listviewitem=inflater.inflate(R.layout.clublist,null,true);
        TextView textViewnmae=(TextView)listviewitem.findViewById(R.id.name);
        TextView textViewdesc=(TextView)listviewitem.findViewById(R.id.on_club_description);
        TextView textdate=(TextView)listviewitem.findViewById(R.id.date);
        TextView textclubpushid=(TextView)listviewitem.findViewById(R.id.clubpuchid);
        final Club_data_modl club_data_modl=createclub.get(position);

        textViewnmae.setText(club_data_modl.getClub_name());
        textViewdesc.setText(club_data_modl.getDescription());
        textdate.setText(club_data_modl.getDate_club());
        textclubpushid.setText(club_data_modl.getClub_puchid());
        listviewitem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendetail(club_data_modl.getClub_name(),club_data_modl.getDescription(),club_data_modl.getDate_club(),club_data_modl.getClub_puchid());

            }
        });
        return listviewitem;

    }
    private void opendetail(String...details){
        Intent intent=new Intent(Context,create_event_of_teacher.class);
        intent.putExtra("name",details[0]);
        intent.putExtra("description",details[1]);
        intent.putExtra("date",details[2]);
        intent.putExtra("id",details[3]);
        Context.startActivity(intent);

    }
}
