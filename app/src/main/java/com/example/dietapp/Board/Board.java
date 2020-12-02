package com.example.dietapp.Board;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Board {
    String user;
    String b_title;
    String b_content;

    Board(){}

   Board(String user, String b_title, String b_content){
        this.user = user;
        this.b_title = b_title;
        this.b_content = b_content;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getB_title() {
        return b_title;
    }

    public void setB_title(String b_title) {
        this.b_title = b_title;
    }

    public String getB_content() {
        return b_content;
    }

    public void setB_content(String b_content) {
        this.b_content = b_content;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();
        result.put("user",user);
        result.put("b_title",b_title);
        result.put("b_content",b_content);

        return result;
    }
}
