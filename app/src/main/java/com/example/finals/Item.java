package com.example.finals;

//커스텀 뷰를 위한 Item클래스
public class Item {

    String name;
    String calorie;
    public Item(String name, String calorie)
    {
        this.name = name;
        this.calorie = calorie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCalorie() {
        return calorie;
    }

    public void setCalorie(String calorie) {
        this.calorie = calorie;
    }



}