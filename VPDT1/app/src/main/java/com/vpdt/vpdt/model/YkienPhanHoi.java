package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YkienPhanHoi {
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
