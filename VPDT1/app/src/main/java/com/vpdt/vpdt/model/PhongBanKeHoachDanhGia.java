package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhongBanKeHoachDanhGia {
    @SerializedName("mapb")
    @Expose
    private Integer mapb;
    @SerializedName("tenpb")
    @Expose
    private String tenpb;
    @SerializedName("tenviettat")
    @Expose
    private String tenviettat;

    public Integer getMapb() {
        return mapb;
    }

    public void setMapb(Integer mapb) {
        this.mapb = mapb;
    }

    public String getTenpb() {
        return tenpb;
    }

    public void setTenpb(String tenpb) {
        this.tenpb = tenpb;
    }

    public String getTenviettat() {
        return tenviettat;
    }

    public void setTenviettat(String tenviettat) {
        this.tenviettat = tenviettat;
    }
}
