package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongBao {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("trangThai")
    @Expose
    private Integer trangThai;
    @SerializedName("tieuDe")
    @Expose
    private String tieuDe;
    @SerializedName("ngayTao")
    @Expose
    private String ngayTao;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("idContent")
    @Expose
    private Integer idContent;
    @SerializedName("kieu")
    @Expose
    private Integer kieu;
    @SerializedName("key1")
    @Expose
    private String key1;
    @SerializedName("key2")
    @Expose
    private String key2;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(String ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public Integer getIdContent() {
        return idContent;
    }

    public void setIdContent(Integer idContent) {
        this.idContent = idContent;
    }

    public Integer getKieu() {
        return kieu;
    }

    public void setKieu(Integer kieu) {
        this.kieu = kieu;
    }

    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }
}
