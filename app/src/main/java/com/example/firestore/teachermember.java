package com.example.firestore;

public class teachermember {
   private String temail;
    private String tname;
    private String tid;
    private String tdobg;
    private String tcollegename;
    private  String departemnt;
    public teachermember() {
    }

    public teachermember(String temail, String tname, String tid, String tdobg, String tcollegename, String departemnt) {
        this.temail = temail;
        this.tname = tname;
        this.tid = tid;
        this.tdobg = tdobg;
        this.tcollegename = tcollegename;
        this.departemnt = departemnt;
    }

    public String getTemail() {
        return temail;
    }

    public void setTemail(String temail) {
        this.temail = temail;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTid() {
        return tid;
    }

    public void setTid(String tid) {
        this.tid = tid;
    }

    public String getTdobg() {
        return tdobg;
    }

    public void setTdobg(String tdobg) {
        this.tdobg = tdobg;
    }

    public String getTcollegename() {
        return tcollegename;
    }

    public void setTcollegename(String tcollegename) {
        this.tcollegename = tcollegename;
    }

    public String getDepartemnt() {
        return departemnt;
    }

    public void setDepartemnt(String departemnt) {
        this.departemnt = departemnt;
    }
}
