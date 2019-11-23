package com.example.firestore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.firestore.fetchbyadd.techerclubkey;

public class Home extends AppCompatActivity {
    ImageView Student,Faculity;
    Boolean is_teacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Student=findViewById(R.id.studentbutton);
        Faculity=findViewById(R.id.faculitybutton);
        Student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_teacher = false;
                Intent intent=new Intent(Home.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        Faculity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                is_teacher = true;
                Intent intent=new Intent(Home.this, teacherlogin.class);
                startActivity(intent);
            }
        });

    }
}
