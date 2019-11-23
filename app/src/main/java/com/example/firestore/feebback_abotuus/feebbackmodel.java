package com.example.firestore.feebback_abotuus;

public class feebbackmodel {
    private  String name;
    private String email;
    private String decription;

    public feebbackmodel() {
    }

    public feebbackmodel(String name, String email, String decription) {
        this.name = name;
        this.email = email;
        this.decription = decription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDecription() {
        return decription;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }
}
