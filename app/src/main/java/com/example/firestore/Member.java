package com.example.firestore;

public class Member {
    private  String email;
    private String password;
    private String studnetid;
    private String studentfullname;
    private String studentdob;
    private String studentcollege;
    private String studnetcoure;
    private String studentgroup;

    public Member() {

    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudnetid(String studnetid) {
        this.studnetid = studnetid;
    }

    public void setStudentfullname(String studentfullname) {
        this.studentfullname = studentfullname;
    }

    public void setStudentdob(String studentdob) {
        this.studentdob = studentdob;
    }

    public void setStudentcollege(String studentcollege) {
        this.studentcollege = studentcollege;
    }

    public void setStudnetcoure(String studnetcoure) {
        this.studnetcoure = studnetcoure;
    }

    public void setStudentgroup(String studentgroup) {
        this.studentgroup = studentgroup;
    }

    public String getStudnetid() {
        return studnetid;
    }

    public String getStudentfullname() {
        return studentfullname;
    }

    public String getStudentdob() {
        return studentdob;
    }

    public String getStudentcollege() {
        return studentcollege;
    }

    public String getStudnetcoure() {
        return studnetcoure;
    }

    public String getStudentgroup() {
        return studentgroup;
    }
}
