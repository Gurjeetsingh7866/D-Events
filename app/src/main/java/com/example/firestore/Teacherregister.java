package com.example.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Teacherregister extends AppCompatActivity implements View.OnClickListener {

    EditText teachername,teacheridtext,teachercollege,teacherdepartment,teacherdobt;

    //defining view objects
    EditText teditTextEmail;
    EditText teditTextPassword;
    EditText tedittextconfirm;
    Button tSignup;
    long maxid;



    ProgressDialog progressDialog;


    //defining firebaseauth object
    FirebaseAuth firebaseAutht;

    DatabaseReference referenc;
    teachermember teachermember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherregister);
        teacheridtext=(EditText) findViewById(R.id.teacherid);
        teachername=(EditText) findViewById(R.id.teacherFull_Name);
        teacherdobt=(EditText) findViewById(R.id.teacherdob);
        teachercollege=(EditText) findViewById(R.id.teacherCollegename);
        teacherdepartment=(EditText) findViewById(R.id.teacherdepartment);
        referenc= FirebaseDatabase.getInstance().getReference().child("teacherMember");
        teachermember=new teachermember();
        firebaseAutht = FirebaseAuth.getInstance();
        referenc.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if(dataSnapshot.exists()){
                    maxid=(dataSnapshot.getChildrenCount());
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //initializing views
        teditTextEmail = (EditText) findViewById(R.id.teacherTextEmail);
        teditTextPassword = (EditText) findViewById(R.id.teacherTextPassword);
        tedittextconfirm=(EditText)findViewById(R.id.teacherconfirmpassword);

        tSignup = (Button) findViewById(R.id.teacherSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        tSignup.setOnClickListener(this);








    }

    private void teacherregisterUser() {

        //getting email and password from edit texts
        String email = teditTextEmail.getText().toString().trim();
        String password = teditTextPassword.getText().toString().trim();


        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        String tconfrmpass=tedittextconfirm.getText().toString().trim();





            //if the email and password are not empty
            //displaying a progress dialog

            progressDialog.setMessage("Registering Please Wait...");
            progressDialog.show();



            firebaseAutht.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            //checking if success
                            if (task.isSuccessful()) {
                                finish();
                                FirebaseUser user=firebaseAutht.getCurrentUser();
                                String temail=teditTextEmail.getText().toString().trim();
                                String tname=teachername.getText().toString().trim();
                                String tid=teacheridtext.getText().toString().trim();
                                String tdobg=teacherdobt.getText().toString().trim();
                                String tcollegename=teachercollege.getText().toString().trim();
                                String departemnt=teacherdepartment.getText().toString().trim();


                                teachermember.setTemail(temail);
                                teachermember.setTname(tname);
                                teachermember.setTid(tid);
                                teachermember.setTdobg(tdobg);
                                teachermember.setTcollegename(tcollegename);
                                teachermember.setDepartemnt(departemnt);
                                String id=user.getUid();

                                referenc.child(id).setValue(teachermember);
                               // String idd=referenc.push().getKey();
                                Toast.makeText(Teacherregister.this, "successfully saved", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(getApplicationContext(), teacherprofile.class));
                            } else {
                                //display some message here
                                Toast.makeText(Teacherregister.this, "Registration Error", Toast.LENGTH_LONG).show();
                            }
                            progressDialog.dismiss();

                        }
                    });



    }

    @Override
    public void onClick(View view) {
        if(view == tSignup){
            teacherregisterUser();
        }



    }
}
