package com.example.firestore.student_all_club;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.firestore.R;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.util.Date;

public class AllClub_studentActivity extends AppCompatActivity {
    private RecyclerView recyclerView_club_Stu_;
    private DatabaseReference club_referenceFor_student,joinclub_reference;
    private FirebaseAuth club_authFor_student;
    private RecyclerView recyclerView_club_student;
    private String uid_student;
    private  EditText clubdanam,clubdidescritpion;
    private Button joinclub;
    private  TextView NAme_of_club,Description_ofclub,puchid_join_;
    private  String namejoin_stud,description_stud,key_,puchid_join;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_club_student);
        club_authFor_student=FirebaseAuth.getInstance();
        FirebaseUser user=club_authFor_student.getCurrentUser();

        uid_student=user.getUid();
        club_referenceFor_student= FirebaseDatabase.getInstance().getReference().child("Clubs");
        recyclerView_club_Stu_=findViewById(R.id.recyclerview_in_student);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(true);
        recyclerView_club_Stu_.setHasFixedSize(true);
        recyclerView_club_Stu_.setLayoutManager(linearLayoutManager);


    }
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<student_clubDataModel, AllClub_studentActivity.MyViewHolder> Stu_adapter=new FirebaseRecyclerAdapter<student_clubDataModel, AllClub_studentActivity.MyViewHolder>
                (
                        student_clubDataModel.class,
                        R.layout.studentcub_list,
                        AllClub_studentActivity.MyViewHolder.class,
                        club_referenceFor_student
                )
        {
            @Override
            protected void populateViewHolder(MyViewHolder myViewHolder, final student_clubDataModel student_clubDataModel, final int i) {
                myViewHolder.setclubname(student_clubDataModel.getClub_name());
                myViewHolder.setdescription(student_clubDataModel.getDescription());
                myViewHolder.setdate(student_clubDataModel.getDate_club());
                myViewHolder.setpuchid(student_clubDataModel.getClubpuchid());
                myViewHolder.myview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        key_=getRef(i).getKey();

                       namejoin_stud=student_clubDataModel.getClub_name();
                       description_stud=student_clubDataModel.getDescription();
                       puchid_join=student_clubDataModel.getClubpuchid();
                        joinme();




                    }
                });

            }

        };
        recyclerView_club_Stu_.setAdapter(Stu_adapter);

    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{

        View myview;
        public MyViewHolder(View itemView){
            super(itemView);
            myview=itemView;
        }
        public void setclubname(String title){
            TextView mTitle=myview.findViewById(R.id.name_instudent);
            mTitle.setText(title);
        }
        public void setdescription(String note){
            TextView mNote=myview.findViewById(R.id.on_club_description_instudent);
            mNote.setText(note);

        }
        public void setdate(String date){
            TextView mDate=myview.findViewById(R.id.date_instudent);
            mDate.setText(date);
        }
        public void setpuchid(String puchid){
            TextView mpuchid=myview.findViewById(R.id.cluppuchid_studn);
            mpuchid.setText(puchid);

        }
    }
    public void joinme(){
        final AlertDialog.Builder joindialog= new AlertDialog.Builder(AllClub_studentActivity.this);
        LayoutInflater inflater=LayoutInflater.from(AllClub_studentActivity.this);
        View myviewjoin=inflater.inflate(R.layout.join_me_club,null);
        joindialog.setView(myviewjoin);
        final AlertDialog joinalert=joindialog.create();
        NAme_of_club=myviewjoin.findViewById(R.id.name_forjoin);
        puchid_join_=myviewjoin.findViewById(R.id.clubpuchid_join);
        Description_ofclub=myviewjoin.findViewById(R.id.club_description_forjoin);
        NAme_of_club.setText(namejoin_stud);
        Description_ofclub.setText(description_stud);
        puchid_join_.setText(key_);

        joinclub=myviewjoin.findViewById(R.id.Join_me_button);

        joinclub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinclub_reference=FirebaseDatabase.getInstance().getReference("Joinclubs");

                String push_id_joinclub = club_referenceFor_student.push().getKey();
                String dates = DateFormat.getDateInstance().format(new Date());
                student_clubDataModel student_clubDataModel=new student_clubDataModel(uid_student,key_,namejoin_stud,dates,description_stud);
                joinclub_reference.child(push_id_joinclub).setValue(student_clubDataModel);
                Toast.makeText(AllClub_studentActivity.this, "Subscribed", Toast.LENGTH_SHORT).show();




                joinalert.dismiss();
            }
        });


        joinalert.show();
    }

}
