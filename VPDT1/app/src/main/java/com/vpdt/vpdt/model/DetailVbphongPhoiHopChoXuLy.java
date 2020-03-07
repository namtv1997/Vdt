package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DetailVbphongPhoiHopChoXuLy {
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
    @SerializedName("khuVuc")
    @Expose
    private String khuVuc;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
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
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("doMat")
    @Expose
    private String doMat;
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
    private List<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets = null;
    @SerializedName("trinhTuGiaiQuyetPhongPHs")
    @Expose
    private List<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyetPhongPHs = null;
    @SerializedName("tepTinDinhKems")
    @Expose
    private List<TepTinDinhKemPPH> tepTinDinhKems = null;
    @SerializedName("ketQuaGiaiQuyetPhongPHs")
    @Expose
    private List<KetQuaGiaiQuyetPhongPP> ketQuaGiaiQuyetPhongPHs = null;
    @SerializedName("ketQuaGiaiQuyetPhongTLs")
    @Expose
    private List<KetQuaGiaiQuyetPhongTL> ketQuaGiaiQuyetPhongTLs = null;

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

    public String getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(String khuVuc) {
        this.khuVuc = khuVuc;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
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

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
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

    public List<TrinhTuGiaiQuyetPhongPH> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TrinhTuGiaiQuyetPhongPH> getTrinhTuGiaiQuyetPhongPHs() {
        return trinhTuGiaiQuyetPhongPHs;
    }

    public void setTrinhTuGiaiQuyetPhongPHs(List<TrinhTuGiaiQuyetPhongPH> trinhTuGiaiQuyetPhongPHs) {
        this.trinhTuGiaiQuyetPhongPHs = trinhTuGiaiQuyetPhongPHs;
    }

    public List<TepTinDinhKemPPH> getTepTinDinhKems() {
        return tepTinDinhKems;
    }

    public void setTepTinDinhKems(List<TepTinDinhKemPPH> tepTinDinhKems) {
        this.tepTinDinhKems = tepTinDinhKems;
    }

    public List<KetQuaGiaiQuyetPhongPP> getketQuaGiaiQuyetPhongPHs() {
        return ketQuaGiaiQuyetPhongPHs;
    }

    public void setketQuaGiaiQuyetPhongPHs(List<KetQuaGiaiQuyetPhongPP> ketQuaGiaiQuyetPhongPHs) {
        this.ketQuaGiaiQuyetPhongPHs = ketQuaGiaiQuyetPhongPHs;
    }

    public List<KetQuaGiaiQuyetPhongTL> getKetQuaGiaiQuyetPhongTLs() {
        return ketQuaGiaiQuyetPhongTLs;
    }

    public void setKetQuaGiaiQuyetPhongTLs(List<KetQuaGiaiQuyetPhongTL> ketQuaGiaiQuyetPhongTLs) {
        this.ketQuaGiaiQuyetPhongTLs = ketQuaGiaiQuyetPhongTLs;
    }
}
