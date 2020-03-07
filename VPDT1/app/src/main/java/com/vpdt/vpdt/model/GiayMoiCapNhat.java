package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiayMoiCapNhat {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("vBQPPL")
    @Expose
    private Integer vBQPPL;
    @SerializedName("STC_CT")
    @Expose
    private Integer sTCCT;
    @SerializedName("TBKL")
    @Expose
    private Integer tBKL;
    @SerializedName("idKhuVuc")
    @Expose
    private Integer idKhuVuc;
    @SerializedName("khuVuc")
    @Expose
    private String khuVuc;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("idLoaiVanBan")
    @Expose
    private Integer idLoaiVanBan;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("noiGuiDen")
    @Expose
    private String noiGuiDen;
    @SerializedName("idnoiGuiDen")
    @Expose
    private Integer idnoiGuiDen;
    @SerializedName("ngayKy")
    @Expose
    private String ngayKy;
    @SerializedName("linhVuc")
    @Expose
    private String linhVuc;
    @SerializedName("idLinhVuc")
    @Expose
    private Integer idLinhVuc;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("tenNguoiKy")
    @Expose
    private String tenNguoiKy;
    @SerializedName("idNguoiKy")
    @Expose
    private Integer idNguoiKy;
    @SerializedName("ngayNhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chucVu")
    @Expose
    private String chucVu;
    @SerializedName("idChucVu")
    @Expose
    private Integer idChucVu;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("idDoMat")
    @Expose
    private Integer idDoMat;
    @SerializedName("doMat")
    @Expose
    private String doMat;
    @SerializedName("idDoKhan")
    @Expose
    private Integer idDoKhan;
    @SerializedName("doKhan")
    @Expose
    private String doKhan;
    @SerializedName("soTrang")
    @Expose
    private String soTrang;
    @SerializedName("thamMuu")
    @Expose
    private String thamMuu;
    @SerializedName("ngayPhanLoai")
    @Expose
    private String ngayPhanLoai;
    @SerializedName("trinhTuGiaiQuyets")
    @Expose
    private List<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets = null;
    @SerializedName("tepTinDinhKems")
    @Expose
    private List<TepTinDinhKemPPH> tepTinDinhKems = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getVBQPPL() {
        return vBQPPL;
    }

    public void setVBQPPL(Integer vBQPPL) {
        this.vBQPPL = vBQPPL;
    }

    public Integer getSTCCT() {
        return sTCCT;
    }

    public void setSTCCT(Integer sTCCT) {
        this.sTCCT = sTCCT;
    }

    public Integer getTBKL() {
        return tBKL;
    }

    public void setTBKL(Integer tBKL) {
        this.tBKL = tBKL;
    }

    public Integer getIdKhuVuc() {
        return idKhuVuc;
    }

    public void setIdKhuVuc(Integer idKhuVuc) {
        this.idKhuVuc = idKhuVuc;
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

    public Integer getIdLoaiVanBan() {
        return idLoaiVanBan;
    }

    public void setIdLoaiVanBan(Integer idLoaiVanBan) {
        this.idLoaiVanBan = idLoaiVanBan;
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

    public Integer getIdnoiGuiDen() {
        return idnoiGuiDen;
    }

    public void setIdnoiGuiDen(Integer idnoiGuiDen) {
        this.idnoiGuiDen = idnoiGuiDen;
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

    public Integer getIdLinhVuc() {
        return idLinhVuc;
    }

    public void setIdLinhVuc(Integer idLinhVuc) {
        this.idLinhVuc = idLinhVuc;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenNguoiKy() {
        return tenNguoiKy;
    }

    public void setTenNguoiKy(String tenNguoiKy) {
        this.tenNguoiKy = tenNguoiKy;
    }

    public Integer getIdNguoiKy() {
        return idNguoiKy;
    }

    public void setIdNguoiKy(Integer idNguoiKy) {
        this.idNguoiKy = idNguoiKy;
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

    public Integer getIdChucVu() {
        return idChucVu;
    }

    public void setIdChucVu(Integer idChucVu) {
        this.idChucVu = idChucVu;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public Integer getIdDoMat() {
        return idDoMat;
    }

    public void setIdDoMat(Integer idDoMat) {
        this.idDoMat = idDoMat;
    }

    public String getDoMat() {
        return doMat;
    }

    public void setDoMat(String doMat) {
        this.doMat = doMat;
    }

    public Integer getIdDoKhan() {
        return idDoKhan;
    }

    public void setIdDoKhan(Integer idDoKhan) {
        this.idDoKhan = idDoKhan;
    }

    public String getDoKhan() {
        return doKhan;
    }

    public void setDoKhan(String doKhan) {
        this.doKhan = doKhan;
    }

    public String getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(String soTrang) {
        this.soTrang = soTrang;
    }

    public String getThamMuu() {
        return thamMuu;
    }

    public void setThamMuu(String thamMuu) {
        this.thamMuu = thamMuu;
    }

    public String getNgayPhanLoai() {
        return ngayPhanLoai;
    }

    public void setNgayPhanLoai(String ngayPhanLoai) {
        this.ngayPhanLoai = ngayPhanLoai;
    }

    public List<TrinhTuGiaiQuyetPhoiHopTraLai> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetPhoiHopTraLai> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TepTinDinhKemPPH> getTepTinDinhKems() {
        return tepTinDinhKems;
    }

    public void setTepTinDinhKems(List<TepTinDinhKemPPH> tepTinDinhKems) {
        this.tepTinDinhKems = tepTinDinhKems;
    }
}
