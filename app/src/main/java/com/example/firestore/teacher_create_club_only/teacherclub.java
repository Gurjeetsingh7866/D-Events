package com.example.firestore.teacher_create_club_only;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firestore.Club_data_modl;
import com.example.firestore.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class teacherclub extends AppCompatActivity {
    FirebaseDatabase firebaseDatabase;
   private DatabaseReference clubreference,event_clubreference;
    private FirebaseAuth clubauth;
    private  String id;

    ListView listViewcolnyteacher_club;
    DatabaseReference databaseReferencejoinclub;
    List<Club_data_modl> list;
    FirebaseAuth firebaseAuth;
    private  String pushid;
    private FloatingActionButton Floatltn;
   private String uid;
   private RecyclerView recyclerView_club_main;

    EditText clubdanam,clubdidescritpion;
    private create_club_adapter create_club_adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherclub);
        Floatltn=findViewById(R.id.floatingActionButtonteacherclub);

        clubauth=FirebaseAuth.getInstance();
        FirebaseUser user=clubauth.getCurrentUser();
        uid=user.getUid();
        firebaseAuth=FirebaseAuth.getInstance();
        FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();

        clubreference= FirebaseDatabase.getInstance().getReference("Clubs");
        event_clubreference=FirebaseDatabase.getInstance().getReference("Evens_clubId");


        id = clubreference.push().getKey();



        listViewcolnyteacher_club=findViewById(R.id.createidlist);
        list=new ArrayList<Club_data_modl>();


        Floatltn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder my_clubdialog = new AlertDialog.Builder(teacherclub.this);
                LayoutInflater Inflater = LayoutInflater.from(teacherclub.this);
                final View myview = Inflater.inflate(R.layout.custominputof_club, null);
                my_clubdialog.setView(myview);

                final AlertDialog dialog = my_clubdialog.create();
                Button club_button = myview.findViewById(R.id.createclub_button);
                club_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        clubdanam = (EditText) myview.findViewById(R.id.club_name);
                        clubdidescritpion = myview. findViewById(R.id.club_Description);
                        String finalclubnam = clubdanam.getText().toString().trim();
                        String finalclubdescritpion = clubdidescritpion.getText().toString().trim();
                        if (TextUtils.isEmpty(finalclubnam)) {
                            clubdanam.setError("fill club name");
                            return;
                        }
                        if (TextUtils.isEmpty(finalclubdescritpion)) {
                            clubdidescritpion.setError("fill club Description");
                            return;
                        }
                        String dates = DateFormat.getDateInstance().format(new Date());
                        Club_data_modl club_data_modl = new Club_data_modl(id,uid, finalclubnam, dates, finalclubdescritpion);
                        clubreference.child(id).setValue(club_data_modl);
                        event_clubreference.child(id).setValue(finalclubnam);

                        Toast.makeText(teacherclub.this, "Club Created", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }


                });
                dialog.show();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Query query=FirebaseDatabase.getInstance().getReference("Clubs")
                .orderByChild("club_id")
                .equalTo(uid);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){
                    Club_data_modl clubjoins=aSnapshot1.getValue(Club_data_modl.class);

                    list.add(clubjoins);
                }
                final create_club_adapter create_club_adapter=new create_club_adapter(teacherclub.this,list);

                listViewcolnyteacher_club.setAdapter(create_club_adapter);
//                listViewcolnyteacher_club.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//                    @Override
//                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//
//                    }
//                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
