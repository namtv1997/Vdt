package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NguoiKy_nhap {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ho_ten")
    @Expose
    private String hoTen;
    @SerializedName("chucvu")
    @Expose
    private String chucvu;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getChucvu() {
        return chucvu;
    }

    public void setChucvu(String chucvu) {
        this.chucvu = chucvu;
    }
}
