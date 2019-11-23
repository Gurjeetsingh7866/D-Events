package com.example.firestore.joinclub;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
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

import javax.xml.namespace.QName;

public class stud_clubs extends AppCompatActivity {
    private RecyclerView recyclerView_club_Stu_join;
    private DatabaseReference club_referenceFor_student_join;
    private FirebaseAuth club_authFor_student_join;
    private String uid_student_join;
    private TextView NAme_of_club_join,Description_ofclub_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stud_clubs);
        club_authFor_student_join=FirebaseAuth.getInstance();
        FirebaseUser user=club_authFor_student_join.getCurrentUser();
        uid_student_join=user.getUid();

        club_referenceFor_student_join= FirebaseDatabase.getInstance().getReference("Clubs");

        //select * from club where id of teacher;


        recyclerView_club_Stu_join=findViewById(R.id.recyclerView_of_joinclubs);
        LinearLayoutManager linearLayoutManager_join=new LinearLayoutManager(this);
        linearLayoutManager_join.setReverseLayout(true);
        linearLayoutManager_join.setStackFromEnd(true);
        recyclerView_club_Stu_join.setHasFixedSize(true);
        recyclerView_club_Stu_join.setLayoutManager(linearLayoutManager_join);

    }
}
