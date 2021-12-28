package com.example.finals;

//카페인 객체를 위한 클래스
public class caffaine {
    private String name;
    private String calorie;
    private String thumb_url;

    public caffaine(String name, String thumb_url, String calorie) {
        this.name = name;
        this.calorie = calorie;
        this.thumb_url = thumb_url;
    }

    public String getName() {
        return name;
    }

    public String getcalorie() {
        return calorie;
    }

    public String getThumb_url() {
        return thumb_url;
    }
}
