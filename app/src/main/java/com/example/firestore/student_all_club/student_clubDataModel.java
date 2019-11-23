package com.example.firestore.student_all_club;

public class student_clubDataModel {

        private  String club_id;
        private String clubpuchid;
        private String club_name;
        private String date_club;
        private String description;

    public student_clubDataModel() {
    }

    public String getClubpuchid() {
        return clubpuchid;
    }

    public void setClubpuchid(String clubpuchid) {
        this.clubpuchid = clubpuchid;
    }

    public student_clubDataModel(String club_id, String clubpuchid, String club_name, String date_club, String description) {
        this.club_id = club_id;
        this.clubpuchid = clubpuchid;
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
