package com.example.firestore.fetchbyadd;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.firestore.R;
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

public class techerclubkey extends AppCompatActivity {
    private ListView listViewjoinclub;
    private DatabaseReference databaseReferencejoinclub;
    private List<joinclub_model> list;
    private FirebaseAuth firebaseAuth;
    private  String userid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_techerclubkey);
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
        userid=firebaseUser.getUid();
        listViewjoinclub=findViewById(R.id.listview_u_joinclub);
        list=new ArrayList<joinclub_model>();
        databaseReferencejoinclub= FirebaseDatabase.getInstance().getReference("Joinclubs");
    }

    @Override
    protected void onStart() {
        super.onStart();
        final Query query=FirebaseDatabase.getInstance().getReference("Joinclubs")
                .orderByChild("club_id")
                .equalTo(userid);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){
                    joinclub_model joinclub_model=aSnapshot1.getValue(joinclub_model.class);
                    list.add(joinclub_model);

                }
                final  joinvlublist joinvlublist=new joinvlublist(techerclubkey.this,list);

                listViewjoinclub.setAdapter(joinvlublist);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
