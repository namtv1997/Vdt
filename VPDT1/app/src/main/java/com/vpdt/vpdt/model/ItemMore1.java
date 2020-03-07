package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemMore1 {
    @SerializedName("noiDungDauViec")
    @Expose
    private String noiDungDauViec;
    @SerializedName("tieuDe")
    @Expose
    private String tieuDe;
    @SerializedName("lanhDaoChiDao")
    @Expose
    private String lanhDaoChiDao;
    @SerializedName("noiDungPhanCong")
    @Expose
    private String noiDungPhanCong;
    @SerializedName("cuTri")
    @Expose
    private String cuTri;
    @SerializedName("donViChuTri")
    @Expose
    private String donViChuTri;
    @SerializedName("hanXuLy")
    @Expose
    private String hanXuLy;
    @SerializedName("donViPhoiHop")
    @Expose
    private String donViPhoiHop;

    public String getNoiDungDauViec() {
        return noiDungDauViec;
    }

    public void setNoiDungDauViec(String noiDungDauViec) {
        this.noiDungDauViec = noiDungDauViec;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getLanhDaoChiDao() {
        return lanhDaoChiDao;
    }

    public void setLanhDaoChiDao(String lanhDaoChiDao) {
        this.lanhDaoChiDao = lanhDaoChiDao;
    }

    public String getNoiDungPhanCong() {
        return noiDungPhanCong;
    }

    public void setNoiDungPhanCong(String noiDungPhanCong) {
        this.noiDungPhanCong = noiDungPhanCong;
    }

    public String getCuTri() {
        return cuTri;
    }

    public void setCuTri(String cuTri) {
        this.cuTri = cuTri;
    }

    public String getDonViChuTri() {
        return donViChuTri;
    }

    public void setDonViChuTri(String donViChuTri) {
        this.donViChuTri = donViChuTri;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
    }

    public String getDonViPhoiHop() {
        return donViPhoiHop;
    }

    public void setDonViPhoiHop(String donViPhoiHop) {
        this.donViPhoiHop = donViPhoiHop;
    }
}
