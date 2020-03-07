package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrinhTuChuyenNhanLuuVetChoLanhDaoPhongPheDuyet {
    @SerializedName("ngayNhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chuyenTu")
    @Expose
    private String chuyenTu;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("chuyenDen")
    @Expose
    private String chuyenDen;

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getChuyenTu() {
        return chuyenTu;
    }

    public void setChuyenTu(String chuyenTu) {
        this.chuyenTu = chuyenTu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getChuyenDen() {
        return chuyenDen;
    }

    public void setChuyenDen(String chuyenDen) {
        this.chuyenDen = chuyenDen;
    }
}
