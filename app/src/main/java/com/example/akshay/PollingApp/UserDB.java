package com.example.akshay.PollingApp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UserDB {
String username;


    public UserDB(String username, ArrayList<String> listofgroups) {
        this.username = username;
        this.listofgroups = listofgroups;
    }
    public UserDB(){
        this.listofgroups = null;
        this.username = null;
    }
    //    String[] grouplist  = new String[100];
    ArrayList<String> listofgroups = new ArrayList<>();
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getListofgroups() {
        return listofgroups;
    }

    public void setListofgroups(ArrayList<String> listofgroups) {
        this.listofgroups = listofgroups;
    }

    public UserDB(String username ) {
        this.username = username;

    }
}
