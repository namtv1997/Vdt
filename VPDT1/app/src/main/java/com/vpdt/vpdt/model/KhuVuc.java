package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KhuVuc {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ten")
    @Expose
    private String ten;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }
}
