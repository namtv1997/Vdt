package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Loaivb {
    @SerializedName("id_lvb")
    @Expose
    private Integer idLvb;
    @SerializedName("ten_lvb")
    @Expose
    private String tenLvb;
    @SerializedName("chon_loaivb")
    @Expose
    private Integer chonLoaivb;
    @SerializedName("tenviettat_loaivanban")
    @Expose
    private String tenviettatLoaivanban;

    public Integer getIdLvb() {
        return idLvb;
    }

    public void setIdLvb(Integer idLvb) {
        this.idLvb = idLvb;
    }

    public String getTenLvb() {
        return tenLvb;
    }

    public void setTenLvb(String tenLvb) {
        this.tenLvb = tenLvb;
    }

    public Integer getChonLoaivb() {
        return chonLoaivb;
    }

    public void setChonLoaivb(Integer chonLoaivb) {
        this.chonLoaivb = chonLoaivb;
    }

    public String getTenviettatLoaivanban() {
        return tenviettatLoaivanban;
    }

    public void setTenviettatLoaivanban(String tenviettatLoaivanban) {
        this.tenviettatLoaivanban = tenviettatLoaivanban;
    }
}
