package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LyDoChamMuonPhongThuLy {
    @SerializedName("canBo")
    @Expose
    private String canBo;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;

    public String getCanBo() {
        return canBo;
    }

    public void setCanBo(String canBo) {
        this.canBo = canBo;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

}
