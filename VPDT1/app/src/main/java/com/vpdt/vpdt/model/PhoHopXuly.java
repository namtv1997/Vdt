package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhoHopXuly {
    @SerializedName("thoi_gian")
    @Expose
    private String thoiGian;
    @SerializedName("nguoi_gui")
    @Expose
    private String nguoiGui;
    @SerializedName("noi_dung_xuly")
    @Expose
    private String noiDungXuly;
    @SerializedName("nguoi_nhan")
    @Expose
    private String nguoiNhan;
    @SerializedName("file")
    @Expose
    private String file;

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

    public String getNoiDungXuly() {
        return noiDungXuly;
    }

    public void setNoiDungXuly(String noiDungXuly) {
        this.noiDungXuly = noiDungXuly;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
