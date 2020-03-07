package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DonViCanNhanVanban {
    @SerializedName("ten_phong_ban")
    @Expose
    private String tenPhongBan;
    @SerializedName("nguoi_nhans")
    @Expose
    private List<NguoiNhan> nguoiNhans = null;
    @SerializedName("ghi_chu")
    @Expose
    private String ghiChu;

    public String getTenPhongBan() {
        return tenPhongBan;
    }

    public void setTenPhongBan(String tenPhongBan) {
        this.tenPhongBan = tenPhongBan;
    }

    public List<NguoiNhan> getNguoiNhans() {
        return nguoiNhans;
    }

    public void setNguoiNhans(List<NguoiNhan> nguoiNhans) {
        this.nguoiNhans = nguoiNhans;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }
}
