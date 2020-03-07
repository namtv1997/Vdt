package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TaiLieuHopPhong {
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("phu_luc")
    @Expose
    private String phuLuc;
    @SerializedName("phong_chutri")
    @Expose
    private String phongChutri;
    @SerializedName("phong_phohops")
    @Expose
    private String phongPhohops;
    @SerializedName("lanh_dao_so")
    @Expose
    private String lanhDaoSo;
    @SerializedName("files")
    @Expose
    private List<File> files = null;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getPhuLuc() {
        return phuLuc;
    }

    public void setPhuLuc(String phuLuc) {
        this.phuLuc = phuLuc;
    }

    public String getPhongChutri() {
        return phongChutri;
    }

    public void setPhongChutri(String phongChutri) {
        this.phongChutri = phongChutri;
    }

    public String getPhongPhohops() {
        return phongPhohops;
    }

    public void setPhongPhohops(String phongPhohops) {
        this.phongPhohops = phongPhohops;
    }

    public String getLanhDaoSo() {
        return lanhDaoSo;
    }

    public void setLanhDaoSo(String lanhDaoSo) {
        this.lanhDaoSo = lanhDaoSo;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }
}
