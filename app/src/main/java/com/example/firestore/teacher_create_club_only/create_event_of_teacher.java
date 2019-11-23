package com.example.firestore.teacher_create_club_only;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
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

public class create_event_of_teacher extends AppCompatActivity {
    private DatabaseReference clubreference,reference_foe_id;
    private FirebaseAuth clubauth;
    private  String uid;
    List<create_event_model> list_event;
    private FloatingActionButton Floatling_event;
    FirebaseAuth firebaseAuth;
    ListView listViewcolnyteacher_event;
    EditText eventnam,event_date,eventdescritpion;
    private String intid;
    private String club_position;
    private create_club_adapter create_club_adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_event_of_teacher);
        Floatling_event=findViewById(R.id.floatingActionButton_teacher_Event);
        clubauth=FirebaseAuth.getInstance();
        FirebaseUser user=clubauth.getCurrentUser();
        uid=user.getUid();

        Intent intent=this.getIntent();
        String intName=intent.getExtras().getString("name");
        String intdesc=intent.getExtras().getString("description");
        String intdare=intent.getExtras().getString("date");
        intid=intent.getExtras().getString("id");





        firebaseAuth=FirebaseAuth.getInstance();
        clubreference= FirebaseDatabase.getInstance().getReference("Events");
        Floatling_event.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder my_clubdialog = new AlertDialog.Builder(create_event_of_teacher.this);
                LayoutInflater Inflater = LayoutInflater.from(create_event_of_teacher.this);
                final View myview = Inflater.inflate(R.layout.custom_of_event, null);
                my_clubdialog.setView(myview);

                final AlertDialog dialog = my_clubdialog.create();
                Button club_button = myview.findViewById(R.id.createclub_button);
                club_button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eventnam = myview.findViewById(R.id.event___name);
                        eventdescritpion = myview. findViewById(R.id.event_Description);
                        event_date=myview.findViewById(R.id.EVENT_date);
                        String finalnam = eventnam.getText().toString().trim();
                        String finaldescritpion = eventdescritpion.getText().toString().trim();
                        String event__Date_string = event_date.getText().toString().trim();
                        clubreference.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                                for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){
                                    Club_data_modl clubjoins=aSnapshot1.getValue(Club_data_modl.class);
                                    club_position=clubjoins.getClub_puchid();
                                }
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {

                            }
                        });
                        Toast.makeText(create_event_of_teacher.this, "club puchid"+club_position, Toast.LENGTH_SHORT).show();


                        if (TextUtils.isEmpty(finalnam)) {
                            eventnam.setError("fill club name");
                            return;
                        }
                        if (TextUtils.isEmpty(finaldescritpion)) {
                            eventdescritpion.setError("fill club Description");
                            return;
                        }
                        String id=clubreference.push().getKey();
                        String dates = DateFormat.getDateInstance().format(new Date());
                        create_event_model create_event_model= new create_event_model(id,intid,finalnam,event__Date_string,finaldescritpion);
                        clubreference.child(id).setValue(create_event_model);
                        Toast.makeText(create_event_of_teacher.this, "Eventn is Created", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }


                });
                dialog.show();
            }
        });



        Query query=FirebaseDatabase.getInstance().getReference("Events")
                .orderByChild("club_position")
                .equalTo(intid);



        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                list_event.clear();
                for(DataSnapshot aSnapshot1:dataSnapshot.getChildren()){

                    create_event_model create_event_model=aSnapshot1.getValue(create_event_model.class);
                    list_event.add(create_event_model);
                }
                create_event_adapter create_event_adapter=new create_event_adapter(create_event_of_teacher.this,list_event);

                listViewcolnyteacher_event.setAdapter(create_event_adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        listViewcolnyteacher_event=findViewById(R.id.createidlist_of_event);
        list_event=new ArrayList<>();


    }
}
