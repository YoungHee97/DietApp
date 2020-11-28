package com.example.dietapp.Health;

public class Health {
    int h_picture, hno;
    String h_title, h_ex, link;

    public Health(int h_picture, String h_title, String h_ex, int hno, String link){
        this.h_picture = h_picture;
        this.h_title = h_title;
        this.h_ex = h_ex;
        this.hno = hno;
        this.link = link;
    }

    public int getH_picture() {
        return h_picture;
    }

    public void setH_picture(int h_picture) {
        this.h_picture = h_picture;
    }

    public int getHno() {
        return hno;
    }

    public void setHno(int hno) {
        this.hno = hno;
    }

    public String getH_title() {
        return h_title;
    }

    public void setH_title(String h_title) {
        this.h_title = h_title;
    }

    public String getH_ex() {
        return h_ex;
    }

    public void setH_ex(String h_ex) {
        this.h_ex = h_ex;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
