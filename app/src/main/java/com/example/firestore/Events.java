package com.example.firestore;

import android.widget.Button;
import android.widget.EditText;

public class Events {
    private  String Nameofevent;
    private String Date_of_event;
    private String Description;
    private  String Nameofclub;
    private  String Descriptionofclub;
    private String TeacherMemberId;

    public String getTeacherMemberId() {
        return TeacherMemberId;
    }

    public void setTeacherMemberId(String teacherMemberId) {
        TeacherMemberId = teacherMemberId;
    }

    public Events() {
    }

    public String getNameofclub() {
        return Nameofclub;
    }

    public void setNameofclub(String nameofclub) {
        Nameofclub = nameofclub;
    }

    public String getDescriptionofclub() {
        return Descriptionofclub;
    }

    public void setDescriptionofclub(String descriptionofclub) {
        Descriptionofclub = descriptionofclub;
    }

    public Events(String nameofevent, String date_of_event, String description, String nameofclub, String descriptionofclub,String teacherMemberId) {
        Nameofevent = nameofevent;
        Date_of_event = date_of_event;
        Description = description;
        Nameofclub = nameofclub;
        Descriptionofclub = descriptionofclub;
        TeacherMemberId = teacherMemberId;
    }


    public String getNameofevent() {
        return Nameofevent;
    }

    public void setNameofevent(String nameofevent) {
        Nameofevent = nameofevent;
    }

    public String getDate_of_event() {
        return Date_of_event;
    }

    public void setDate_of_event(String date_of_event) {
        Date_of_event = date_of_event;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
