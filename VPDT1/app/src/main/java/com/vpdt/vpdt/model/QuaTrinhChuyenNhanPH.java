package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class QuaTrinhChuyenNhanPH {
    @SerializedName("nguoiGui")
    @Expose
    private String nguoiGui;
    @SerializedName("nguoiNhan")
    @Expose
    private String nguoiNhan;
    @SerializedName("thoiGianGui")
    @Expose
    private String thoiGianGui;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("urlFileYeuCau")
    @Expose
    private String urlFileYeuCau;
    @SerializedName("urlFileTraLoi")
    @Expose
    private String urlFileTraLoi;
    @SerializedName("trangThai")
    @Expose
    private Integer trangThai;

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFileYeuCau() {
        return urlFileYeuCau;
    }

    public void setUrlFileYeuCau(String urlFileYeuCau) {
        this.urlFileYeuCau = urlFileYeuCau;
    }

    public String getUrlFileTraLoi() {
        return urlFileTraLoi;
    }

    public void setUrlFileTraLoi(String urlFileTraLoi) {
        this.urlFileTraLoi = urlFileTraLoi;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

}
