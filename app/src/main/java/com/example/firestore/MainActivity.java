package com.example.firestore;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
      EditText studentname,studentidtext,studentcollege,studentcourse,studentgroup,studentdob;

    //defining view objects
     EditText editTextEmail;
     EditText editTextPassword;
     EditText edittextconfirm;
     Button buttonSignup;
     long maxidstudent;

    TextView textViewSignin;

     ProgressDialog progressDialog;


    //defining firebaseauth object
    FirebaseAuth firebaseAuth;

    DatabaseReference reference;
    Member member;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        studentidtext=(EditText) findViewById(R.id.Studentid);
        studentname=(EditText) findViewById(R.id.Full_Name);
        studentdob=(EditText) findViewById(R.id.Studentdob);
        studentcollege=(EditText) findViewById(R.id.Collegenamestudend);
        studentcourse=(EditText) findViewById(R.id.coursestudend);
        studentgroup=(EditText) findViewById(R.id.Groupstudent);
        reference= FirebaseDatabase.getInstance().getReference().child("Member");
         member=new Member();
        firebaseAuth = FirebaseAuth.getInstance();


        //initializing views
        editTextEmail = (EditText) findViewById(R.id.editTextEmail);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        edittextconfirm=(EditText)findViewById(R.id.confrmeditTextPassword);

        buttonSignup = (Button) findViewById(R.id.buttonSignup);

        progressDialog = new ProgressDialog(this);

        //attaching listener to button
        buttonSignup.setOnClickListener(this);








    }

    private void registerUser() {

        //getting email and password from edit texts
        String email = editTextEmail.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();

        //checking if email and passwords are empty
        if (TextUtils.isEmpty(email)) {
            Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show();
            return;
        }

        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show();
            return;
        }
        String confrmstrinpass=edittextconfirm.getText().toString().trim();





        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();



        firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        //checking if success
                        if (task.isSuccessful()) {
                            finish();
                            final FirebaseUser user=firebaseAuth.getCurrentUser();


                            String email=editTextEmail.getText().toString().trim();
                            String name=studentname.getText().toString().trim();
                            String id=studentidtext.getText().toString().trim();
                            String dobg=studentdob.getText().toString().trim();
                            String collegename=studentcollege.getText().toString().trim();
                            String course=studentcourse.getText().toString().trim();
                            String group=studentgroup.getText().toString().trim();
                            String uid=user.getUid();


                            member.setEmail(email);
                            member.setStudentfullname(name);
                            member.setStudnetid(id);
                            member.setStudentdob(dobg);
                            member.setStudentcollege(collegename);
                            member.setStudnetcoure(course);
                            member.setStudentgroup(group);

                            reference.child(uid).setValue(member);
                            Toast.makeText(MainActivity.this, "successfully saved", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                        } else {
                            //display some message here
                            Toast.makeText(MainActivity.this, "Registration Error", Toast.LENGTH_LONG).show();
                        }
                        progressDialog.dismiss();

                    }
                });



        }

    @Override
    public void onClick(View view) {
        if(view == buttonSignup){
            registerUser();
        }
        if(view == textViewSignin){
            //open login activity when user taps on the already registered textview
            startActivity(new Intent(this, LoginActivity.class));
        }


    }
}