package com.example.dietapp.FastFood.MacDonald;

public class Macdonald {
    int m_burger;
    String m_name, m_calorie, m_ex;

    public Macdonald(int m_burger, String m_name, String m_calorie,String m_ex){
        this.m_burger = m_burger;
        this.m_name = m_name;
        this.m_calorie = m_calorie;
        this.m_ex = m_ex;
    }

    public void setM_burger(int m_burger){
        this.m_burger = m_burger;
    }

    public int getM_burger(){
        return m_burger;
    }

    public void setM_name(String m_name){
        this.m_name = m_name;
    }

    public void setM_ex(String m_ex){
        this.m_ex = m_ex;
    }

    public String getM_name(){
        return m_name;
    }

    public void setM_calorie(String m_calorie){
        this.m_calorie = m_calorie;
    }

    public String getM_calorie(){
        return m_calorie;
    }

    public String getM_ex(){return m_ex;}
}
