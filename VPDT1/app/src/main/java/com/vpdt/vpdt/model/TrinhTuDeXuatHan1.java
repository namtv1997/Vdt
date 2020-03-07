package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrinhTuDeXuatHan1 {
    @SerializedName("thoiGian")
    @Expose
    private String thoiGian;
    @SerializedName("nguoiChuyen")
    @Expose
    private String nguoiChuyen;
    @SerializedName("noiDungChuyen")
    @Expose
    private String noiDungChuyen;
    @SerializedName("nguoiNhan")
    @Expose
    private String nguoiNhan;
    @SerializedName("hanXuLy")
    @Expose
    private String hanXuLy;

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNguoiChuyen() {
        return nguoiChuyen;
    }

    public void setNguoiChuyen(String nguoiChuyen) {
        this.nguoiChuyen = nguoiChuyen;
    }

    public String getNoiDungChuyen() {
        return noiDungChuyen;
    }

    public void setNoiDungChuyen(String noiDungChuyen) {
        this.noiDungChuyen = noiDungChuyen;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
    }
}
