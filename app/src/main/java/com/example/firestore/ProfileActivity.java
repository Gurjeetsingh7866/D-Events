package com.example.firestore;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firestore.chatwithinstudent_teacher.chatmain;
import com.example.firestore.feebback_abotuus.feedback;
import com.example.firestore.fetchbyadd.techerclubkey;
import com.example.firestore.notification.notification;
import com.example.firestore.student_all_club.AllClub_studentActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProfileActivity extends AppCompatActivity implements View.OnClickListener {
    Button studentnoti,studentclubs,joinclub;
    TextView studentidd,dobb,collegenamee,coursee,group;
    //firebase auth object
    private FirebaseAuth firebaseAuth;
    DatabaseReference reffer;



    //view objects
    private TextView textViewUserEmail;

    ImageView buttonLogout,feedbacck,studentmessages;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        studentmessages=findViewById(R.id.Messagesstudent);
        joinclub=findViewById(R.id.join_club);
        feedbacck=findViewById(R.id.feedbackbutton);
        feedbacck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, feedback.class));

            }
        });
        joinclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ProfileActivity.this, techerclubkey.class));

            }
        });
        studentnoti=findViewById(R.id.Notifications);

        studentnoti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, notification.class));
            }
        });
        studentclubs=findViewById(R.id.Club);
        studentclubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, AllClub_studentActivity.class));
            }
        });
        studentmessages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, chatmain.class));
            }
        });



        //initializing firebase authentication object
        firebaseAuth = FirebaseAuth.getInstance();



        //if the user is not logged in
        //that means current user will return null
        if(firebaseAuth.getCurrentUser() == null){
            //closing this activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }

        //getting current user
        final FirebaseUser user = firebaseAuth.getCurrentUser();

        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);
        buttonLogout = (ImageView) findViewById(R.id.buttonLogout);
        //displaying logged in user name
        textViewUserEmail.setText(user.getEmail());
        final TextView sidd=(TextView)findViewById(R.id.studentids);
        final TextView sdobd=(TextView)findViewById(R.id.DOBs);
        final TextView scollegee=(TextView)findViewById(R.id.collegename);
        final TextView scoursee=(TextView)findViewById(R.id.course);
        final TextView sgroupp=(TextView)findViewById(R.id.Group);

        //adding listener to button
        buttonLogout.setOnClickListener(this);
        String uid=user.getUid();
        reffer=FirebaseDatabase.getInstance().getReference("Member").child(uid);
        reffer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                final String sid=dataSnapshot.child("studentfullname").getValue(String.class);
                String sdob=dataSnapshot.child("studentdob").getValue(String.class);
                String scollege=dataSnapshot.child("studentcollege").getValue(String.class);
                String scourse=dataSnapshot.child("studnetcoure").getValue(String.class);
                String sgroup=dataSnapshot.child("studentgroup").getValue(String.class);

                sidd.setText(sid);
                sdobd.setText(sdob);
                scollegee.setText(scollege);
                scoursee.setText(scourse);
                sgroupp.setText(sgroup);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

    @Override
    public void onClick(View view) {
        //if logout is pressed
        if(view == buttonLogout){
            //logging out the user
            firebaseAuth.signOut();
            //closing activity
            finish();
            //starting login activity
            startActivity(new Intent(this, LoginActivity.class));
        }
    }

    }
