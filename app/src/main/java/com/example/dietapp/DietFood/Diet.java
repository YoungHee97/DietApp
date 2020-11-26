package com.example.dietapp.DietFood;

public class Diet {
    int dfood_picture, tno;
    String name, explanation;

    public Diet(int dfood_picture, String name, String explanation,int tno){
        this.dfood_picture = dfood_picture;
        this.name = name;
        this.explanation = explanation;
        this.tno = tno;
    }

    public int getDfood_picture() {
        return dfood_picture;
    }

    public void setDfood_picture(int dfood_picture) {
        this.dfood_picture = dfood_picture;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }
}
