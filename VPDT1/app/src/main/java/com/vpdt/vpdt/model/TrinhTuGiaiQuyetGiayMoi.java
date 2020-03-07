package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrinhTuGiaiQuyetGiayMoi {
    @SerializedName("ngay_nhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chuyen_tu")
    @Expose
    private String chuyenTu;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("chuyen_den")
    @Expose
    private String chuyenDen;
    @SerializedName("han_xuly")
    @Expose
    private String hanXuly;

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getChuyenTu() {
        return chuyenTu;
    }

    public void setChuyenTu(String chuyenTu) {
        this.chuyenTu = chuyenTu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getChuyenDen() {
        return chuyenDen;
    }

    public void setChuyenDen(String chuyenDen) {
        this.chuyenDen = chuyenDen;
    }

    public String getHanXuly() {
        return hanXuly;
    }

    public void setHanXuly(String hanXuly) {
        this.hanXuly = hanXuly;
    }
}
