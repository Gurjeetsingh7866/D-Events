package com.example.firestore.fetchbyadd;

public class event_mofel_ofstudnet {
    private String Event_id;
    private String club_position;
    private String Event_name;
    private String event_date;
    private String event_description;

    public event_mofel_ofstudnet() {
    }

    public event_mofel_ofstudnet(String event_id, String club_position, String event_name, String event_date, String event_description) {
        Event_id = event_id;
        this.club_position = club_position;
        Event_name = event_name;
        this.event_date = event_date;
        this.event_description = event_description;
    }

    public String getEvent_id() {
        return Event_id;
    }

    public void setEvent_id(String event_id) {
        Event_id = event_id;
    }

    public String getClub_position() {
        return club_position;
    }

    public void setClub_position(String club_position) {
        this.club_position = club_position;
    }

    public String getEvent_name() {
        return Event_name;
    }

    public void setEvent_name(String event_name) {
        Event_name = event_name;
    }

    public String getEvent_date() {
        return event_date;
    }

    public void setEvent_date(String event_date) {
        this.event_date = event_date;
    }

    public String getEvent_description() {
        return event_description;
    }

    public void setEvent_description(String event_description) {
        this.event_description = event_description;
    }
}
