package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DSVB_ChoSoCuaSo {
    @SerializedName("soVB")
    @Expose
    private Integer soVB;
    @SerializedName("ngay_thang")
    @Expose
    private String ngayThang;
    @SerializedName("y_kien")
    @Expose
    private String yKien;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("linhvuc")
    @Expose
    private String linhvuc;
    @SerializedName("sotrang")
    @Expose
    private Integer sotrang;
    @SerializedName("soden")
    @Expose
    private String soden;
    @SerializedName("nguoinhapvb")
    @Expose
    private String nguoinhapvb;
    @SerializedName("ngaymoi")
    @Expose
    private String ngaymoi;
    @SerializedName("giomoi")
    @Expose
    private String giomoi;
    @SerializedName("diadiemmoi")
    @Expose
    private String diadiemmoi;
    @SerializedName("chon_id_loaivbs")
    @Expose
    private Integer chonIdLoaivbs;
    @SerializedName("chon_loaivbs")
    @Expose
    private String chonLoaivbs;
    @SerializedName("chon_id_ld_phongs")
    @Expose
    private Integer chonIdLdPhongs;
    @SerializedName("chon_ld_phongs")
    @Expose
    private String chonLdPhongs;
    @SerializedName("chon_id_noiduthaos")
    @Expose
    private Integer chonIdNoiduthaos;
    @SerializedName("chon_noiduthaos")
    @Expose
    private String chonNoiduthaos;
    @SerializedName("chon_id_nguoi_ky")
    @Expose
    private Integer chonIdNguoiKy;
    @SerializedName("chon_nguoi_ky")
    @Expose
    private String chonNguoiKy;
    @SerializedName("mail_quanhuyen")
    @Expose
    private List<MailQuanhuyen> mailQuanhuyen = null;
    @SerializedName("mail_soBanNganh")
    @Expose
    private List<MailSoBanNganh> mailSoBanNganh = null;
    @SerializedName("mail_donvi")
    @Expose
    private List<MailDonvus> mailDonvi = null;
    @SerializedName("mail_ngoai")
    @Expose
    private String mailNgoai;
    @SerializedName("duthao")
    @Expose
    private Integer duthao;

    public Integer getSoVB() {
        return soVB;
    }

    public void setSoVB(Integer soVB) {
        this.soVB = soVB;
    }

    public String getNgayThang() {
        return ngayThang;
    }

    public void setNgayThang(String ngayThang) {
        this.ngayThang = ngayThang;
    }

    public String getYKien() {
        return yKien;
    }

    public void setYKien(String yKien) {
        this.yKien = yKien;
    }

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getLinhvuc() {
        return linhvuc;
    }

    public void setLinhvuc(String linhvuc) {
        this.linhvuc = linhvuc;
    }

    public Integer getSotrang() {
        return sotrang;
    }

    public void setSotrang(Integer sotrang) {
        this.sotrang = sotrang;
    }

    public String getSoden() {
        return soden;
    }

    public void setSoden(String soden) {
        this.soden = soden;
    }

    public String getNguoinhapvb() {
        return nguoinhapvb;
    }

    public void setNguoinhapvb(String nguoinhapvb) {
        this.nguoinhapvb = nguoinhapvb;
    }

    public String getNgaymoi() {
        return ngaymoi;
    }

    public void setNgaymoi(String ngaymoi) {
        this.ngaymoi = ngaymoi;
    }

    public String getGiomoi() {
        return giomoi;
    }

    public void setGiomoi(String giomoi) {
        this.giomoi = giomoi;
    }

    public String getDiadiemmoi() {
        return diadiemmoi;
    }

    public void setDiadiemmoi(String diadiemmoi) {
        this.diadiemmoi = diadiemmoi;
    }

    public Integer getChonIdLoaivbs() {
        return chonIdLoaivbs;
    }

    public void setChonIdLoaivbs(Integer chonIdLoaivbs) {
        this.chonIdLoaivbs = chonIdLoaivbs;
    }

    public String getChonLoaivbs() {
        return chonLoaivbs;
    }

    public void setChonLoaivbs(String chonLoaivbs) {
        this.chonLoaivbs = chonLoaivbs;
    }

    public Integer getChonIdLdPhongs() {
        return chonIdLdPhongs;
    }

    public void setChonIdLdPhongs(Integer chonIdLdPhongs) {
        this.chonIdLdPhongs = chonIdLdPhongs;
    }

    public String getChonLdPhongs() {
        return chonLdPhongs;
    }

    public void setChonLdPhongs(String chonLdPhongs) {
        this.chonLdPhongs = chonLdPhongs;
    }

    public Integer getChonIdNoiduthaos() {
        return chonIdNoiduthaos;
    }

    public void setChonIdNoiduthaos(Integer chonIdNoiduthaos) {
        this.chonIdNoiduthaos = chonIdNoiduthaos;
    }

    public String getChonNoiduthaos() {
        return chonNoiduthaos;
    }

    public void setChonNoiduthaos(String chonNoiduthaos) {
        this.chonNoiduthaos = chonNoiduthaos;
    }

    public Integer getChonIdNguoiKy() {
        return chonIdNguoiKy;
    }

    public void setChonIdNguoiKy(Integer chonIdNguoiKy) {
        this.chonIdNguoiKy = chonIdNguoiKy;
    }

    public String getChonNguoiKy() {
        return chonNguoiKy;
    }

    public void setChonNguoiKy(String chonNguoiKy) {
        this.chonNguoiKy = chonNguoiKy;
    }

    public List<MailQuanhuyen> getMailQuanhuyen() {
        return mailQuanhuyen;
    }

    public void setMailQuanhuyen(List<MailQuanhuyen> mailQuanhuyen) {
        this.mailQuanhuyen = mailQuanhuyen;
    }

    public List<MailSoBanNganh> getMailSoBanNganh() {
        return mailSoBanNganh;
    }

    public void setMailSoBanNganh(List<MailSoBanNganh> mailSoBanNganh) {
        this.mailSoBanNganh = mailSoBanNganh;
    }

    public List<MailDonvus> getMailDonvi() {
        return mailDonvi;
    }

    public void setMailDonvi(List<MailDonvus> mailDonvi) {
        this.mailDonvi = mailDonvi;
    }

    public String getMailNgoai() {
        return mailNgoai;
    }

    public void setMailNgoai(String mailNgoai) {
        this.mailNgoai = mailNgoai;
    }

    public Integer getDuthao() {
        return duthao;
    }

    public void setDuthao(Integer duthao) {
        this.duthao = duthao;
    }
}
