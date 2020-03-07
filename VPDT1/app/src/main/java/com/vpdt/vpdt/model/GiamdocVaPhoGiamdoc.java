package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class GiamdocVaPhoGiamdoc {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ho_ten")
    @Expose
    private String hoTen;

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
}
