package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemThang {
    @SerializedName("can_bo")
    @Expose
    private String canBo;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("thang")
    @Expose
    private Integer thang;
    @SerializedName("so_diem")
    @Expose
    private String soDiem;
    @SerializedName("nhanxet_lanhdao")
    @Expose
    private String nhanxetLanhdao;
    @SerializedName("danhgia_lanhdao")
    @Expose
    private String danhgiaLanhdao;
    @SerializedName("nhanxet_truongphong")
    @Expose
    private String nhanxetTruongphong;
    @SerializedName("danhgia_truongphong")
    @Expose
    private String danhgiaTruongphong;
    @SerializedName("active")
    @Expose
    private Integer active;
    @SerializedName("danhgia_bgd")
    @Expose
    private String danhgiaBgd;
    @SerializedName("nhanxet_bgd")
    @Expose
    private String nhanxetBgd;

    public String getCanBo() {
        return canBo;
    }

    public void setCanBo(String canBo) {
        this.canBo = canBo;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
    }

    public Integer getThang() {
        return thang;
    }

    public void setThang(Integer thang) {
        this.thang = thang;
    }

    public String getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(String soDiem) {
        this.soDiem = soDiem;
    }

    public String getNhanxetLanhdao() {
        return nhanxetLanhdao;
    }

    public void setNhanxetLanhdao(String nhanxetLanhdao) {
        this.nhanxetLanhdao = nhanxetLanhdao;
    }

    public String getDanhgiaLanhdao() {
        return danhgiaLanhdao;
    }

    public void setDanhgiaLanhdao(String danhgiaLanhdao) {
        this.danhgiaLanhdao = danhgiaLanhdao;
    }

    public String getNhanxetTruongphong() {
        return nhanxetTruongphong;
    }

    public void setNhanxetTruongphong(String nhanxetTruongphong) {
        this.nhanxetTruongphong = nhanxetTruongphong;
    }

    public String getDanhgiaTruongphong() {
        return danhgiaTruongphong;
    }

    public void setDanhgiaTruongphong(String danhgiaTruongphong) {
        this.danhgiaTruongphong = danhgiaTruongphong;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public String getDanhgiaBgd() {
        return danhgiaBgd;
    }

    public void setDanhgiaBgd(String danhgiaBgd) {
        this.danhgiaBgd = danhgiaBgd;
    }

    public String getNhanxetBgd() {
        return nhanxetBgd;
    }

    public void setNhanxetBgd(String nhanxetBgd) {
        this.nhanxetBgd = nhanxetBgd;
    }

}
