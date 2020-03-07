package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SoDen{
    @SerializedName("so_den")
    @Expose
    private Integer soDen;
    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("noi_gui_den")
    @Expose
    private String noiGuiDen;
    @SerializedName("mo_ta")
    @Expose
    private String moTa;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;

    public Integer getSoDen() {
        return soDen;
    }

    public void setSoDen(Integer soDen) {
        this.soDen = soDen;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getNoiGuiDen() {
        return noiGuiDen;
    }

    public void setNoiGuiDen(String noiGuiDen) {
        this.noiGuiDen = noiGuiDen;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }
}
