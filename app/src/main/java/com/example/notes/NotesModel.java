package com.example.notes;

public class NotesModel {
    public NotesModel(String title, String destcription, int id) {
        this.title = title;
        Destcription = destcription;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDestcription() {
        return Destcription;
    }

    public void setDestcription(String destcription) {
        Destcription = destcription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    String title;
    String Destcription;
    int id;


}
