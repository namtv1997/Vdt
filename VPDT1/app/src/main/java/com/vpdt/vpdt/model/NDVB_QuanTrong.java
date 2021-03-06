package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class NDVB_QuanTrong implements Serializable {
    @SerializedName("id_van_ban")
    @Expose
    private Integer idVanBan;
    @SerializedName("iSTCChuTri")
    @Expose
    private Integer iSTCChuTri;
    @SerializedName("isVanBanTBKL")
    @Expose
    private Integer isVanBanTBKL;
    @SerializedName("isVanBanQPPL")
    @Expose
    private Integer isVanBanQPPL;
    @SerializedName("isToCongTac")
    @Expose
    private Integer isToCongTac;
    @SerializedName("stt")
    @Expose
    private Integer stt;
    @SerializedName("khu_vuc")
    @Expose
    private Integer khuVuc;
    @SerializedName("so_ky_hieu")
    @Expose
    private String soKyHieu;
    @SerializedName("loai_van_ban")
    @Expose
    private String loaiVanBan;
    @SerializedName("trich_yeu")
    @Expose
    private String trichYeu;
    @SerializedName("nguoi_ky")
    @Expose
    private String nguoiKy;
    @SerializedName("so_den")
    @Expose
    private Integer soDen;
    @SerializedName("ngay_nhan")
    @Expose
    private String ngayNhan;
    @SerializedName("so_trang")
    @Expose
    private Integer soTrang;
    @SerializedName("tham_muu")
    @Expose
    private String thamMuu;
    @SerializedName("noi_gui_den")
    @Expose
    private String noiGuiDen;
    @SerializedName("ngay_ky")
    @Expose
    private String ngayKy;
    @SerializedName("linh_vuc")
    @Expose
    private String linhVuc;
    @SerializedName("chuc_vu")
    @Expose
    private String chucVu;
    @SerializedName("han_giai_quyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("do_mat")
    @Expose
    private String doMat;
    @SerializedName("do_khan")
    @Expose
    private String doKhan;
    @SerializedName("ngay_phan_loai")
    @Expose
    private String ngayPhanLoai;
    @SerializedName("trinh_tu_giai_quyets")
    @Expose
    private List<TrinhTuGiaiQuyet> trinhTuGiaiQuyets = null;
    @SerializedName("trinh_tu_chuyen_nhan_luu_vets")
    @Expose
    private List<TrinhTuChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets = null;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;
    @SerializedName("trinh_tu_giai_quyet_phong_phoi_hops")
    @Expose
    private List<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops = null;
    @SerializedName("file_vanban_lienquans")
    @Expose
    private List<FileVanbanLienquan> fileVanbanLienquans = null;
    @SerializedName("ketqua_giai_quyets")
    @Expose
    private List<KetquaGiaiQuyet> ketquaGiaiQuyets = null;
    @SerializedName("trinh_tu_hoan_thanh_luu_vets")
    @Expose
    private List<TrinhTuHoanThanhLuuVet> trinhTuHoanThanhLuuVets = null;
    @SerializedName("vanbandis")
    @Expose
    private List<Vanbandi> vanbandis = null;

    public Integer getIdVanBan() {
        return idVanBan;
    }

    public void setIdVanBan(Integer idVanBan) {
        this.idVanBan = idVanBan;
    }

    public Integer getISTCChuTri() {
        return iSTCChuTri;
    }

    public void setISTCChuTri(Integer iSTCChuTri) {
        this.iSTCChuTri = iSTCChuTri;
    }

    public Integer getIsVanBanTBKL() {
        return isVanBanTBKL;
    }

    public void setIsVanBanTBKL(Integer isVanBanTBKL) {
        this.isVanBanTBKL = isVanBanTBKL;
    }

    public Integer getIsVanBanQPPL() {
        return isVanBanQPPL;
    }

    public void setIsVanBanQPPL(Integer isVanBanQPPL) {
        this.isVanBanQPPL = isVanBanQPPL;
    }

    public Integer getIsToCongTac() {
        return isToCongTac;
    }

    public void setIsToCongTac(Integer isToCongTac) {
        this.isToCongTac = isToCongTac;
    }

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public Integer getKhuVuc() {
        return khuVuc;
    }

    public void setKhuVuc(Integer khuVuc) {
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

    public String getTrichYeu() {
        return trichYeu;
    }

    public void setTrichYeu(String trichYeu) {
        this.trichYeu = trichYeu;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public Integer getSoDen() {
        return soDen;
    }

    public void setSoDen(Integer soDen) {
        this.soDen = soDen;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public String getThamMuu() {
        return thamMuu;
    }

    public void setThamMuu(String thamMuu) {
        this.thamMuu = thamMuu;
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

    public List<TrinhTuGiaiQuyet> getTrinhTuGiaiQuyets() {
        return trinhTuGiaiQuyets;
    }

    public void setTrinhTuGiaiQuyets(List<TrinhTuGiaiQuyet> trinhTuGiaiQuyets) {
        this.trinhTuGiaiQuyets = trinhTuGiaiQuyets;
    }

    public List<TrinhTuChuyenNhanLuuVet> getTrinhTuChuyenNhanLuuVets() {
        return trinhTuChuyenNhanLuuVets;
    }

    public void setTrinhTuChuyenNhanLuuVets(List<TrinhTuChuyenNhanLuuVet> trinhTuChuyenNhanLuuVets) {
        this.trinhTuChuyenNhanLuuVets = trinhTuChuyenNhanLuuVets;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
    }

    public List<TrinhTuGiaiQuyetPhongPhoiHop> getTrinhTuGiaiQuyetPhongPhoiHops() {
        return trinhTuGiaiQuyetPhongPhoiHops;
    }

    public void setTrinhTuGiaiQuyetPhongPhoiHops(List<TrinhTuGiaiQuyetPhongPhoiHop> trinhTuGiaiQuyetPhongPhoiHops) {
        this.trinhTuGiaiQuyetPhongPhoiHops = trinhTuGiaiQuyetPhongPhoiHops;
    }

    public List<FileVanbanLienquan> getFileVanbanLienquans() {
        return fileVanbanLienquans;
    }

    public void setFileVanbanLienquans(List<FileVanbanLienquan> fileVanbanLienquans) {
        this.fileVanbanLienquans = fileVanbanLienquans;
    }

    public List<KetquaGiaiQuyet> getKetquaGiaiQuyets() {
        return ketquaGiaiQuyets;
    }

    public void setKetquaGiaiQuyets(List<KetquaGiaiQuyet> ketquaGiaiQuyets) {
        this.ketquaGiaiQuyets = ketquaGiaiQuyets;
    }

    public List<TrinhTuHoanThanhLuuVet> getTrinhTuHoanThanhLuuVets() {
        return trinhTuHoanThanhLuuVets;
    }

    public void setTrinhTuHoanThanhLuuVets(List<TrinhTuHoanThanhLuuVet> trinhTuHoanThanhLuuVets) {
        this.trinhTuHoanThanhLuuVets = trinhTuHoanThanhLuuVets;
    }

    public List<Vanbandi> getVanbandis() {
        return vanbandis;
    }

    public void setVanbandis(List<Vanbandi> vanbandis) {
        this.vanbandis = vanbandis;
    }

}