package com.example.dietapp.FastFood.BurgerKing;

public class King {
    int k_burger;
    String k_name, k_calorie, k_ex;

    public King(int k_burger, String k_name, String k_calorie,String k_ex){
        this.k_burger = k_burger;
        this.k_name = k_name;
        this.k_calorie = k_calorie;
        this.k_ex = k_ex;
    }

    public void setK_burger(int k_burger){
        this.k_burger = k_burger;
    }

    public int getK_burger(){
        return k_burger;
    }

    public void setK_name(String k_name){
        this.k_name = k_name;
    }

    public void setK_ex(String k_ex){
        this.k_ex = k_ex;
    }

    public String getK_name(){
        return k_name;
    }

    public void setK_calorie(String k_calorie){
        this.k_calorie = k_calorie;
    }

    public String getK_calorie(){
        return k_calorie;
    }

    public String getK_ex(){return k_ex;}
}
