package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuaTrinhXuly {
    @SerializedName("thoi_gian")
    @Expose
    private String thoiGian;
    @SerializedName("nguoi_gui")
    @Expose
    private String nguoiGui;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("nguoi_nhan")
    @Expose
    private String nguoiNhan;
    @SerializedName("dong_y")
    @Expose
    private Boolean dongY;

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public Boolean getDongY() {
        return dongY;
    }

    public void setDongY(Boolean dongY) {
        this.dongY = dongY;
    }
}
