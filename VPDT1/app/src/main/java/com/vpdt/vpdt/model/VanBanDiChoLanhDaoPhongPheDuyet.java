package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanDiChoLanhDaoPhongPheDuyet {
    @SerializedName("soVanBanDi")
    @Expose
    private String soVanBanDi;
    @SerializedName("ngayVanBan")
    @Expose
    private String ngayVanBan;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;

    public String getSoVanBanDi() {
        return soVanBanDi;
    }

    public void setSoVanBanDi(String soVanBanDi) {
        this.soVanBanDi = soVanBanDi;
    }

    public String getNgayVanBan() {
        return ngayVanBan;
    }

    public void setNgayVanBan(String ngayVanBan) {
        this.ngayVanBan = ngayVanBan;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
}
