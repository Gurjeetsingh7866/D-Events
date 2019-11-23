package com.example.firestore.feebback_abotuus;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.firestore.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class feedback extends AppCompatActivity {
    private Button feedback;
    private EditText name,email,descritpion_feedback;
    private FirebaseAuth firebaseAuth=FirebaseAuth.getInstance();
    private DatabaseReference feedbackrefer;
    private FirebaseUser firebaseUser=firebaseAuth.getCurrentUser();
    private String namef,emailf,decf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        name=findViewById(R.id.feedbackname);
        email=findViewById(R.id.feedbackemail);
        descritpion_feedback=findViewById(R.id.feedbackdec);
        feedback=findViewById(R.id.submitfeedback);
        final  String emailg=firebaseUser.getEmail();
        email.setText(emailg);
        feedbackrefer=FirebaseDatabase.getInstance().getReference("Feedback");
        feedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                namef=name.getText().toString().trim();
                decf=descritpion_feedback.getText().toString().trim();
                feebbackmodel feebbackmodel=new feebbackmodel();
                feebbackmodel.setName(namef);
                feebbackmodel.setEmail(emailg);
                feebbackmodel.setDecription(decf);
                String uid=firebaseUser.getUid();
                feedbackrefer.push().setValue(feebbackmodel);
                Toast.makeText(feedback.this, "Thanks For Your Feedback", Toast.LENGTH_SHORT).show();


            }
        });




    }
}
