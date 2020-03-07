package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailBaoCaoTongHop {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("khuVuc")
    @Expose
    private String khuVuc;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("noiGuiDen")
    @Expose
    private String noiGuiDen;
    @SerializedName("ngayKy")
    @Expose
    private String ngayKy;
    @SerializedName("linhVuc")
    @Expose
    private String linhVuc;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("tenNguoiKy")
    @Expose
    private String tenNguoiKy;
    @SerializedName("ngayNhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chucVu")
    @Expose
    private String chucVu;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("soVanBan")
    @Expose
    private String soVanBan;
    @SerializedName("doMat")
    @Expose
    private String doMat;
    @SerializedName("doKhan")
    @Expose
    private String doKhan;
    @SerializedName("ngayPhanLoai")
    @Expose
    private String ngayPhanLoai;
    @SerializedName("tenNguoiChiDao")
    @Expose
    private String tenNguoiChiDao;
    @SerializedName("vanBanTraLoi")
    @Expose
    private String vanBanTraLoi;
    @SerializedName("urlVanBanTraLoi")
    @Expose
    private String urlVanBanTraLoi;
    @SerializedName("trinhTuGiaiQuyets")
    @Expose
    private List<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets = null;
    @SerializedName("tepTinVanBanDens")
    @Expose
    private List<TepTinVanBanDen> tepTinVanBanDens = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }

    public String getNoiGuiDen() {
        return noiGuiDen;
    }

    public void setNoiGuiDen(String noiGuiDen) {
        this.noiGuiDen = noiGuiDen;
    }

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getLinhVuc() {
        return linhVuc;
    }

    public void setLinhVuc(String linhVuc) {
        this.linhVuc = linhVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTenNguoiKy() {
        return tenNguoiKy;
    }

    public void setTenNguoiKy(String tenNguoiKy) {
        this.tenNguoiKy = tenNguoiKy;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getChucVu() {
        return chucVu;
    }

    public void setChucVu(String chucVu) {
        this.chucVu = chucVu;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getSoVanBan() {
        return soVanBan;
    }

    public void setSoVanBan(String soVanBan) {
        this.soVanBan = soVanBan;
    }

    public String getDoMat() {
        return doMat;
    }

    public void setDoMat(String doMat) {
        this.doMat = doMat;
    }

    public String getDoKhan() {
        return doKhan;
    }

    public void setDoKhan(String doKhan) {
        this.doKhan = doKhan;
    }

    public String getNgayPhanLoai() {
        return ngayPhanLoai;
    }

    public void setNgayPhanLoai(String ngayPhanLoai) {
        this.ngayPhanLoai = ngayPhanLoai;
    }

    public String getTenNguoiChiDao() {
        return tenNguoiChiDao;
    }

    public void setTenNguoiChiDao(String tenNguoiChiDao) {
        this.tenNguoiChiDao = tenNguoiChiDao;
    }

    public String getVanBanTraLoi() {
        return vanBanTraLoi;
    }

    public void setVanBanTraLoi(String vanBanTraLoi) {
        this.vanBanTraLoi = vanBanTraLoi;
    }

    public String getUrlVanBanTraLoi() {
        return urlVanBanTraLoi;
    }

    public void setUrlVanBanTraLoi(String urlVanBanTraLoi) {
        this.urlVanBanTraLoi = urlVanBanTraLoi;
    }

    public List<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetChoLanhDaoPhongPheDuyet> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TepTinVanBanDen> getTepTinVanBanDens() {
        return tepTinVanBanDens;
    }

    public void setTepTinVanBanDens(List<TepTinVanBanDen> tepTinVanBanDens) {
        this.tepTinVanBanDens = tepTinVanBanDens;
    }
}
