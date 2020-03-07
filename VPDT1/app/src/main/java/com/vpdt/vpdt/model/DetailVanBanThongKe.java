package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailVanBanThongKe {
    @SerializedName("PK_iMaVBDen")
    @Expose
    private Integer pKIMaVBDen;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("tenlvb")
    @Expose
    private String tenlvb;
    @SerializedName("soden")
    @Expose
    private Integer soden;
    @SerializedName("kyhieu")
    @Expose
    private String kyhieu;
    @SerializedName("trichYeu")
    @Expose
    private TrichYeu trichYeu;
    @SerializedName("phongCT")
    @Expose
    private String phongCT;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;

    public Integer getPKIMaVBDen() {
        return pKIMaVBDen;
    }

    public void setPKIMaVBDen(Integer pKIMaVBDen) {
        this.pKIMaVBDen = pKIMaVBDen;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getTenlvb() {
        return tenlvb;
    }

    public void setTenlvb(String tenlvb) {
        this.tenlvb = tenlvb;
    }

    public Integer getSoden() {
        return soden;
    }

    public void setSoden(Integer soden) {
        this.soden = soden;
    }

    public String getKyhieu() {
        return kyhieu;
    }

    public void setKyhieu(String kyhieu) {
        this.kyhieu = kyhieu;
    }

    public TrichYeu getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(TrichYeu trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getPhongCT() {
        return phongCT;
    }

    public void setPhongCT(String phongCT) {
        this.phongCT = phongCT;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }
}
