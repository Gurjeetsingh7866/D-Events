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
import com.google.firebase.database.DatabaseReference;

public class teacherlogin extends AppCompatActivity implements View.OnClickListener{
    private Button buttonSignInt;
    private EditText editTextEmailt;
    private EditText editTextPasswordt;
    private TextView textViewSignupt,btnabout;


    //firebase auth object
    private FirebaseAuth firebaseAuth;
    private DatabaseReference reference;

    //progress dialog
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teacherlogin);


        //getting firebase auth object
        firebaseAuth = FirebaseAuth.getInstance();

        //if the objects getcurrentuser method is not null
        //means user is already logged in
        if(firebaseAuth.getCurrentUser() != null){
            //close this activity
            finish();
            //opening profile activity
            startActivity(new Intent(getApplicationContext(), teacherprofile.class));
        }

        //initializing views
        editTextEmailt = (EditText) findViewById(R.id.editTextEmailt);
        editTextPasswordt= (EditText) findViewById(R.id.editTextPasswordt);
        buttonSignInt = (Button) findViewById(R.id.buttonSignint);
        textViewSignupt  = (TextView) findViewById(R.id.textViewSignUpt);
        btnabout=(TextView) findViewById(R.id.aboutuss);
          btnabout.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  Intent intent=new Intent(teacherlogin.this,aboutus.class);
                  startActivity(intent);
              }
          });

        progressDialog = new ProgressDialog(this);

        //attaching click listener
        buttonSignInt.setOnClickListener(this);
        textViewSignupt.setOnClickListener(this);
    }



    //method for user login
    private void userLogin(){
        final String email = editTextEmailt.getText().toString().trim();
        String password  = editTextPasswordt.getText().toString().trim();


        //checking if email and passwords are empty
        if(TextUtils.isEmpty(email)){
            Toast.makeText(this,"Please enter email",Toast.LENGTH_LONG).show();
            return;
        }

        if(TextUtils.isEmpty(password)){
            Toast.makeText(this,"Please enter password",Toast.LENGTH_LONG).show();
            return;
        }

        //if the email and password are not empty
        //displaying a progress dialog

        progressDialog.setMessage("Registering Please Wait...");
        progressDialog.show();


        //logging in the user
        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
                        //if the task is successfull
                        if(task.isSuccessful()){
                            // the profile activity
                            finish();
                            startActivity(new Intent(getApplicationContext(), teacherprofile.class));

                        }{
                            Toast.makeText(teacherlogin.this, "Check Your E-mail and Password", Toast.LENGTH_SHORT).show();
                        }
                        editTextEmailt.setText("");
                        editTextPasswordt.setText("");

                    }
                });

    }

    @Override
    public void onClick(View view) {
        if(view == buttonSignInt){
            userLogin();
        }

        if(view == textViewSignupt){
            finish();
            startActivity(new Intent(this, Teacherregister.class));
        }
    }
}
