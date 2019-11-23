package com.example.firestore.fetchbyadd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firestore.R;
import com.example.firestore.teacher_create_club_only.create_event_adapter;
import com.example.firestore.teacher_create_club_only.create_event_model;
import com.example.firestore.teacher_create_club_only.create_event_of_teacher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class showevents_students extends AppCompatActivity {
    private List<event_mofel_ofstudnet> list_event;
    private ListView list_ofevents_join;

    private FirebaseAuth firebaseAuth;
    private DatabaseReference eventreference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showevents_students);
        Intent intent=this.getIntent();
        String intName=intent.getExtras().getString("name");
        String intdesc=intent.getExtras().getString("description");
        String intdare=intent.getExtras().getString("date");
        String intid=intent.getExtras().getString("id");

        list_event=new ArrayList<>();
        list_ofevents_join=findViewById(R.id.list_of_studentjoinevent);


        firebaseAuth= FirebaseAuth.getInstance();
        eventreference= FirebaseDatabase.getInstance().getReference("Events");
        Query query=FirebaseDatabase.getInstance().getReference("Events")
                .orderByChild("club_position")
                .equalTo(intid);

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_event.clear();

                for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){
                    event_mofel_ofstudnet event_mofel_ofstudnet=aSnapshot1.getValue(event_mofel_ofstudnet.class);

                    list_event.add(event_mofel_ofstudnet);


                }
                joinshow_eventadapter joinshow_eventadapter=new joinshow_eventadapter(showevents_students.this,list_event);
               //joinvlublist joinvlublist=new joinvlublist(showevents_students.this,list_event);

                list_ofevents_join.setAdapter(joinshow_eventadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}
