package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TepDinhKemVanBanDi {
    @SerializedName("ten_tep")
    @Expose
    private String tenTep;
    @SerializedName("duong_dan")
    @Expose
    private String duongDan;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("nguoi_gui")
    @Expose
    private String nguoiGui;

    public String getTenTep() {
        return tenTep;
    }

    public void setTenTep(String tenTep) {
        this.tenTep = tenTep;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }
}
