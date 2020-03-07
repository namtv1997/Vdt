package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DanhGiaGiamDoc {
    @SerializedName("danhGia_GDs")
    @Expose
    private List<DanhGiaGD> danhGiaGDs = null;
    @SerializedName("pgd")
    @Expose
    private List<Pgd> pgd = null;
    @SerializedName("gd_tunhanxet")
    @Expose
    private String gdTunhanxet;
    @SerializedName("tongdiem_maycham")
    @Expose
    private Double tongdiemMaycham;
    @SerializedName("tongdiem_GDcham")
    @Expose
    private String tongdiemGDcham;

    public List<DanhGiaGD> getDanhGiaGDs() {
        return danhGiaGDs;
    }

    public void setDanhGiaGDs(List<DanhGiaGD> danhGiaGDs) {
        this.danhGiaGDs = danhGiaGDs;
    }

    public List<Pgd> getPgd() {
        return pgd;
    }

    public void setPgd(List<Pgd> pgd) {
        this.pgd = pgd;
    }

    public String getGdTunhanxet() {
        return gdTunhanxet;
    }

    public void setGdTunhanxet(String gdTunhanxet) {
        this.gdTunhanxet = gdTunhanxet;
    }

    public Double getTongdiemMaycham() {
        return tongdiemMaycham;
    }

    public void setTongdiemMaycham(Double tongdiemMaycham) {
        this.tongdiemMaycham = tongdiemMaycham;
    }

    public String getTongdiemGDcham() {
        return tongdiemGDcham;
    }

    public void setTongdiemGDcham(String tongdiemGDcham) {
        this.tongdiemGDcham = tongdiemGDcham;
    }
}
