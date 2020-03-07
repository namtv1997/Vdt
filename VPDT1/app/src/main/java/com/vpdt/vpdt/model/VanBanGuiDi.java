package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanGuiDi {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("thoi_gian")
    @Expose
    private String thoiGian;
    @SerializedName("y_kien")
    @Expose
    private String yKien;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getYKien() {
        return yKien;
    }

    public void setYKien(String yKien) {
        this.yKien = yKien;
    }
}
