package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoaiVanBan_Nhap {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ten")
    @Expose
    private String ten;
    @SerializedName("tenviettat")
    @Expose
    private String tenviettat;

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

    public String getTenviettat() {
        return tenviettat;
    }

    public void setTenviettat(String tenviettat) {
        this.tenviettat = tenviettat;
    }
}
