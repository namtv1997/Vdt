package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemmoreSang {
    @SerializedName("chu_tri")
    @Expose
    private String chuTri;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("duongdanfile")
    @Expose
    private String duongdanfile;
    @SerializedName("gio_giay_moi")
    @Expose
    private String gioGiayMoi;
    @SerializedName("ngay_giay_moi")
    @Expose
    private String ngayGiayMoi;
    @SerializedName("dia_diem_giay_moi")
    @Expose
    private String diaDiemGiayMoi;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;

    public String getChuTri() {
        return chuTri;
    }

    public void setChuTri(String chuTri) {
        this.chuTri = chuTri;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getDuongdanfile() {
        return duongdanfile;
    }

    public void setDuongdanfile(String duongdanfile) {
        this.duongdanfile = duongdanfile;
    }

    public String getGioGiayMoi() {
        return gioGiayMoi;
    }

    public void setGioGiayMoi(String gioGiayMoi) {
        this.gioGiayMoi = gioGiayMoi;
    }

    public String getNgayGiayMoi() {
        return ngayGiayMoi;
    }

    public void setNgayGiayMoi(String ngayGiayMoi) {
        this.ngayGiayMoi = ngayGiayMoi;
    }

    public String getDiaDiemGiayMoi() {
        return diaDiemGiayMoi;
    }

    public void setDiaDiemGiayMoi(String diaDiemGiayMoi) {
        this.diaDiemGiayMoi = diaDiemGiayMoi;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }
}
