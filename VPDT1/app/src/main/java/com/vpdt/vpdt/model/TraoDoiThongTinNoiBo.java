package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TraoDoiThongTinNoiBo {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("thoi_gian")
    @Expose
    private String thoiGian;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }
}
