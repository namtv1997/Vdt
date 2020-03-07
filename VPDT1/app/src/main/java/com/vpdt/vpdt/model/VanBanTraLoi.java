package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanTraLoi {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("trich_dan")
    @Expose
    private String trichDan;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTrichDan() {
        return trichDan;
    }

    public void setTrichDan(String trichDan) {
        this.trichDan = trichDan;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }
}
