package com.example.firestore.joinclub;

public class stud_join_model {
    private  String club_id;
    private String club_name;
    private String date_club;
    private String description;

    public stud_join_model() {
    }

    public stud_join_model(String club_id, String club_name, String date_club, String description) {
        this.club_id = club_id;
        this.club_name = club_name;
        this.date_club = date_club;
        this.description = description;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    public String getDate_club() {
        return date_club;
    }

    public void setDate_club(String date_club) {
        this.date_club = date_club;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
