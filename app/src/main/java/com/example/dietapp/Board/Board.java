package com.example.dietapp.Board;

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

    public String getTitle() {
        return b_title;
    }

    public void setTitle(String b_title) {
        this.b_title = b_title;
    }

    public String getContent() {
        return b_content;
    }

    public void setContent(String b_content) {
        this.b_content = b_content;
    }
}
