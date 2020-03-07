package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongKeKetQuaCongTacTuan {
    @SerializedName("can_bo")
    @Expose
    private String canBo;
    @SerializedName("phong_ban")
    @Expose
    private String phongBan;
    @SerializedName("tuan")
    @Expose
    private String tuan;
    @SerializedName("so_diem")
    @Expose
    private String soDiem;
    @SerializedName("nhan_xet")
    @Expose
    private String nhanSet;
    @SerializedName("nhan_xet_truong_dv")
    @Expose
    private String nhanSetTruongDv;

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

    public String getTuan() {
        return tuan;
    }

    public void setTuan(String tuan) {
        this.tuan = tuan;
    }

    public String getSoDiem() {
        return soDiem;
    }

    public void setSoDiem(String soDiem) {
        this.soDiem = soDiem;
    }

    public String getNhanSet() {
        return nhanSet;
    }

    public void setNhanSet(String nhanSet) {
        this.nhanSet = nhanSet;
    }

    public String getNhanSetTruongDv() {
        return nhanSetTruongDv;
    }

    public void setNhanSetTruongDv(String nhanSetTruongDv) {
        this.nhanSetTruongDv = nhanSetTruongDv;
    }
}
