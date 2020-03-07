package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetQuaGiaiQuyetPhongPP {
    @SerializedName("tenCanBo")
    @Expose
    private String tenCanBo;
    @SerializedName("donVi")
    @Expose
    private String donVi;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;

    public String getTenCanBo() {
        return tenCanBo;
    }

    public void setTenCanBo(String tenCanBo) {
        this.tenCanBo = tenCanBo;
    }

    public String getDonVi() {
        return donVi;
    }

    public void setDonVi(String donVi) {
        this.donVi = donVi;
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

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
}
