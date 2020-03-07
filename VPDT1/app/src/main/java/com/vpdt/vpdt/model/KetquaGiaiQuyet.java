package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetquaGiaiQuyet {
    @SerializedName("canbo")
    @Expose
    private String canbo;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("ten_file")
    @Expose
    private String tenFile;
    @SerializedName("duong_dan")
    @Expose
    private String duongDan;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;

    public String getCanbo() {
        return canbo;
    }

    public void setCanbo(String canbo) {
        this.canbo = canbo;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
