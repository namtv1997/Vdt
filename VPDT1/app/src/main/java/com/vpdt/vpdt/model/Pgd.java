package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Pgd {
    @SerializedName("nguoidanhgia")
    @Expose
    private String nguoidanhgia;
    @SerializedName("nhanxet")
    @Expose
    private String nhanxet;
    @SerializedName("thoigian_danhgia")
    @Expose
    private String thoigianDanhgia;

    public String getNguoidanhgia() {
        return nguoidanhgia;
    }

    public void setNguoidanhgia(String nguoidanhgia) {
        this.nguoidanhgia = nguoidanhgia;
    }

    public String getNhanxet() {
        return nhanxet;
    }

    public void setNhanxet(String nhanxet) {
        this.nhanxet = nhanxet;
    }

    public String getThoigianDanhgia() {
        return thoigianDanhgia;
    }

    public void setThoigianDanhgia(String thoigianDanhgia) {
        this.thoigianDanhgia = thoigianDanhgia;
    }
}
