package com.example.firestore;

public class Club_data_modl {
    private  String club_puchid;
    private  String club_id;
    private String club_name;
    private String date_club;
    private String description;

    public String getClub_puchid() {
        return club_puchid;
    }

    public void setClub_puchid(String club_puchid) {
        this.club_puchid = club_puchid;
    }

    public Club_data_modl(String club_puchid, String club_id, String club_name, String date_club, String description) {
        this.club_puchid = club_puchid;
        this.club_id = club_id;
        this.club_name = club_name;
        this.date_club = date_club;
        this.description = description;
    }

    public Club_data_modl() {
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
