package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ChieuLichcongtac {
    @SerializedName("mavb")
    @Expose
    private Integer mavb;
    @SerializedName("gio_hop")
    @Expose
    private String gioHop;
    @SerializedName("donvi")
    @Expose
    private String donvi;
    @SerializedName("GMso")
    @Expose
    private String gMso;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("NoiDung")
    @Expose
    private String noiDung;
    @SerializedName("ghichu")
    @Expose
    private String ghichu;
    @SerializedName("diadiem_hop")
    @Expose
    private String diadiemHop;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;
    @SerializedName("lanhdao")
    @Expose
    private String lanhdao;
    @SerializedName("chidao_s")
    @Expose
    private List<Chidao> chidaoS = null;
    @SerializedName("phong_phoihop")
    @Expose
    private String phongPhoihop;

    public Integer getMavb() {
        return mavb;
    }

    public void setMavb(Integer mavb) {
        this.mavb = mavb;
    }

    public String getGioHop() {
        return gioHop;
    }

    public void setGioHop(String gioHop) {
        this.gioHop = gioHop;
    }

    public String getDonvi() {
        return donvi;
    }

    public void setDonvi(String donvi) {
        this.donvi = donvi;
    }

    public String getGMso() {
        return gMso;
    }

    public void setGMso(String gMso) {
        this.gMso = gMso;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getGhichu() {
        return ghichu;
    }

    public void setGhichu(String ghichu) {
        this.ghichu = ghichu;
    }

    public String getDiadiemHop() {
        return diadiemHop;
    }

    public void setDiadiemHop(String diadiemHop) {
        this.diadiemHop = diadiemHop;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    public String getLanhdao() {
        return lanhdao;
    }

    public void setLanhdao(String lanhdao) {
        this.lanhdao = lanhdao;
    }

    public List<Chidao> getChidaoS() {
        return chidaoS;
    }

    public void setChidaoS(List<Chidao> chidaoS) {
        this.chidaoS = chidaoS;
    }

    public String getPhongPhoihop() {
        return phongPhoihop;
    }

    public void setPhongPhoihop(String phongPhoihop) {
        this.phongPhoihop = phongPhoihop;
    }
}
