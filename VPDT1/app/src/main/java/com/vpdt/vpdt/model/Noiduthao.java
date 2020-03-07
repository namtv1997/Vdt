package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Noiduthao {
    @SerializedName("id_phong")
    @Expose
    private Integer idPhong;
    @SerializedName("ten_phong")
    @Expose
    private String tenPhong;
    @SerializedName("chon_noiduthao")
    @Expose
    private Integer chonNoiduthao;
    @SerializedName("tenviettat")
    @Expose
    private String tenviettat;

    public Integer getIdPhong() {
        return idPhong;
    }

    public void setIdPhong(Integer idPhong) {
        this.idPhong = idPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public Integer getChonNoiduthao() {
        return chonNoiduthao;
    }

    public void setChonNoiduthao(Integer chonNoiduthao) {
        this.chonNoiduthao = chonNoiduthao;
    }

    public String getTenviettat() {
        return tenviettat;
    }

    public void setTenviettat(String tenviettat) {
        this.tenviettat = tenviettat;
    }
}
