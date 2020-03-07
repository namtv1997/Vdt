package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DetailVanBanTheoLanhDao {
    @SerializedName("ma_vb")
    @Expose
    private Integer maVb;
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
    private TrichYeuVanBanTheoLanhDao trichYeu;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("hanVb")
    @Expose
    private String hanVb;
    @SerializedName("ngaygiaiquyet")
    @Expose
    private String ngaygiaiquyet;

    public Integer getMaVb() {
        return maVb;
    }

    public void setMaVb(Integer maVb) {
        this.maVb = maVb;
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

    public TrichYeuVanBanTheoLanhDao getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(TrichYeuVanBanTheoLanhDao trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getHanVb() {
        return hanVb;
    }

    public void setHanVb(String hanVb) {
        this.hanVb = hanVb;
    }

    public String getNgaygiaiquyet() {
        return ngaygiaiquyet;
    }

    public void setNgaygiaiquyet(String ngaygiaiquyet) {
        this.ngaygiaiquyet = ngaygiaiquyet;
    }
}
