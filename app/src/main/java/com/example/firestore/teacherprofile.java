package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.firestore.chatwithinstudent_teacher.chatmain;
import com.example.firestore.feebback_abotuus.feedback;
import com.example.firestore.notification.notification;
import com.example.firestore.student_all_club.AllClub_studentActivity;
import com.example.firestore.teacher_create_club_only.teacherclub;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class teacherprofile extends AppCompatActivity implements View.OnClickListener{
    Button teacherclubg,messages,teachernotification;
    private ImageView createclb,buttonLogout,feedbackii;
    private FirebaseAuth firebaseAuth;
    DatabaseReference reffer;
    private TextView textViewUserEmail;
    long maxi;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherprofile);
        teachernotification=findViewById(R.id.teacherNotifications);
        feedbackii=findViewById(R.id.buttonfeedback);
        feedbackii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(teacherprofile.this, feedback.class);
                startActivity(intent);

            }
        });
        teachernotification.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(teacherprofile.this, notification.class);
                startActivity(intent);

            }
        });
        teacherclubg=findViewById(R.id.teacherClub);
        teacherclubg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacherprofile.this, teacherclub.class);
                startActivity(intent);
            }
        });
        messages=findViewById(R.id.teacherMessages);
        messages.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(teacherprofile.this, chatmain.class);
                startActivity(intent);

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
        FirebaseUser user = firebaseAuth.getCurrentUser();
        String id=user.getUid();


        //initializing views
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmailt);
        buttonLogout = (ImageView) findViewById(R.id.buttonLogoutt);
        final TextView nm=(TextView)findViewById(R.id.teachername);
        final TextView dob=(TextView)findViewById(R.id.teacherdob);
        final TextView college=(TextView)findViewById(R.id.teachercollege);
        final TextView depmntart=(TextView)findViewById(R.id.teacherdepartment);



        //displaying logged in user name
        textViewUserEmail.setText(user.getEmail());
        String uid=user.getUid();
        reffer= FirebaseDatabase.getInstance().getReference("teacherMember").child(uid);
        reffer.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String name=dataSnapshot.child("tname").getValue(String.class);
                String dobb=dataSnapshot.child("tdobg").getValue(String.class);
                String collegee=dataSnapshot.child("tcollegename").getValue(String.class);
                String departmnt=dataSnapshot.child("departemnt").getValue(String.class);

                nm.setText(name);
                dob.setText(dobb);
                college.setText(collegee);
                depmntart.setText(departmnt);




            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });





        //adding listener to button
        buttonLogout.setOnClickListener(this);
        teacherclubg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(teacherprofile.this,teacherclub.class);
                startActivity(intent);
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

            startActivity(new Intent(this, teacherlogin.class));
        }
    }

}

