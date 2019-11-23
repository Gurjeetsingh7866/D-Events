package com.example.firestore.teacher_create_club_only;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.firestore.Club_data_modl;
import com.example.firestore.R;
import com.example.firestore.fetchbyadd.joinclub_model;
import com.example.firestore.fetchbyadd.joinvlublist;
import com.example.firestore.fetchbyadd.techerclubkey;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class onlyteacher_club extends AppCompatActivity {
    ListView listViewcolnyteacher_club;
    DatabaseReference databaseReferencejoinclub;
    List<Club_data_modl> list;
    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onlyteacher_club);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        String userid=firebaseUser.getUid();
        databaseReferencejoinclub= FirebaseDatabase.getInstance().getReference("Clubs");
        final Query query=FirebaseDatabase.getInstance().getReference("Joinclubs")
                .orderByChild("club_id")
                .equalTo(userid);
        query.addListenerForSingleValueEvent(valueEventListener);



        listViewcolnyteacher_club=findViewById(R.id.listin_onlycreate);
        list=new ArrayList<>();




    }
    ValueEventListener valueEventListener=new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            list.clear();
            for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){
                Club_data_modl club_data_modl=aSnapshot1.getValue(Club_data_modl.class);
                list.add(club_data_modl);
            }
            create_club_adapter create_club_adapter=new create_club_adapter(onlyteacher_club.this,list);

            listViewcolnyteacher_club.setAdapter(create_club_adapter);

        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    };


}
