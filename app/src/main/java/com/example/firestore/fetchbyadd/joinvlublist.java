package com.example.firestore.fetchbyadd;



import android.app.Activity;
import android.content.Context;
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
import com.example.firestore.teacher_create_club_only.create_event_of_teacher;


import java.util.List;

    public class joinvlublist extends ArrayAdapter<joinclub_model> {
        private Activity  Context;
        private List<joinclub_model> joinclublist;
        public joinvlublist(Activity context,List<joinclub_model> joinclub){
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
            final joinclub_model joinclub_model=joinclublist.get(position);

            textViewnmae.setText(joinclub_model.getClub_name());
            textViewdesc.setText(joinclub_model.getDescription());
            textdate.setText(joinclub_model.getDate_club());
            textpuchid_join.setText(joinclub_model.getClubpuchid());

            listviewitem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    opendetai(joinclub_model.getClub_name(),joinclub_model.getDescription(),joinclub_model.getDate_club(),joinclub_model.getClubpuchid());

                }
            });
            return listviewitem;

        }
        private  void  opendetai(String...details){
           Intent i=new Intent(Context,showevents_students.class);
            i.putExtra("name",details[0]);
            i.putExtra("description",details[1]);
            i.putExtra("date",details[2]);
            i.putExtra("id",details[3]);
            Context.startActivity(i);

        }
    }


