package com.example.rxjavalearning.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class MarsPhoto implements Serializable {

    @SerializedName("id")
    private String id;

    @SerializedName("img_src")
    private String img_src;


    public MarsPhoto(String id, String img_src) {
        this.id = id;
        this.img_src = img_src;
    }


    public MarsPhoto() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImg_src() {
        return img_src;
    }

    public void setImg_src(String img_src) {
        this.img_src = img_src;
    }

}
