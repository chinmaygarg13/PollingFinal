package com.example.akshay.PollingApp;

import java.util.ArrayList;

public class PollDB {

    String Asker;
    String Questions;
    ArrayList<String> listofoptions = new ArrayList<>();
    String Askedtime;
    String Expirytime;

    public String getAsker() {
        return Asker;
    }

    public void setAsker(String asker) {
        Asker = asker;
    }

    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public ArrayList<String> getListofoptions() {
        return listofoptions;
    }

    public void setListofoptions(ArrayList<String> listofoptions) {
        this.listofoptions = listofoptions;
    }

    public String getAskedtime() {
        return Askedtime;
    }

    public void setAskedtime(String askedtime) {
        Askedtime = askedtime;
    }

    public String getExpirytime() {
        return Expirytime;
    }

    public void setExpirytime(String expirytime) {
        Expirytime = expirytime;
    }

    public PollDB() {
        this.Askedtime=null;
        this.Asker=null;
        this.Expirytime=null;
        this.listofoptions=null;
        this.Questions=null;
    }

    public PollDB(String asker, String questions, ArrayList<String> listofoptions, String askedtime, String expirytime) {
        Asker = asker;
        Questions = questions;
        this.listofoptions = listofoptions;
        Askedtime = askedtime;
        Expirytime = expirytime;
    }
}
