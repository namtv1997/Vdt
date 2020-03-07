package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanDenChoXuLy implements Parcelable{
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
    @SerializedName("iSTCPhoiHop")
    @Expose
    private Integer iSTCPhoiHop;
    @SerializedName("iToCongTac")
    @Expose
    private Integer iToCongTac;
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
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("noi_dung_tuchoi")
    @Expose
    private String noiDungTuchoi;
    @SerializedName("phong_gui_lai")
    @Expose
    private String phongGuiLai;
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
    @SerializedName("vb_BGD")
    @Expose
    private Boolean vbBGD;
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
    @SerializedName("y_kien")
    @Expose
    private YKien yKien;
    @SerializedName("chi_dao_1")
    @Expose
    private String chiDao1;
    @SerializedName("chi_dao_2")
    @Expose
    private String chiDao2;
    @SerializedName("ket_giai_quyet_phong_phoi_hops")
    @Expose
    private List<KetGiaiQuyetPhongPhoiHop> ketGiaiQuyetPhongPhoiHops = null;
    @SerializedName("vanbandis")
    @Expose
    private List<Vanbandi> vanbandis = null;
    @SerializedName("chuyen_nhan_phoihops")
    @Expose
    private List<ChuyenNhanPhoihop> chuyenNhanPhoihops = null;
    @SerializedName("ket_giai_quyet_phong_thu_lys")
    @Expose
    private List<KetGiaiQuyetPhongThuLy> ketGiaiQuyetPhongThuLys = null;

    protected VanBanDenChoXuLy(Parcel in) {
        if (in.readByte() == 0) {
            idVanBan = null;
        } else {
            idVanBan = in.readInt();
        }
        if (in.readByte() == 0) {
            iSTCChuTri = null;
        } else {
            iSTCChuTri = in.readInt();
        }
        if (in.readByte() == 0) {
            isVanBanTBKL = null;
        } else {
            isVanBanTBKL = in.readInt();
        }
        if (in.readByte() == 0) {
            isVanBanQPPL = null;
        } else {
            isVanBanQPPL = in.readInt();
        }
        if (in.readByte() == 0) {
            iSTCPhoiHop = null;
        } else {
            iSTCPhoiHop = in.readInt();
        }
        if (in.readByte() == 0) {
            iToCongTac = null;
        } else {
            iToCongTac = in.readInt();
        }
        if (in.readByte() == 0) {
            stt = null;
        } else {
            stt = in.readInt();
        }
        if (in.readByte() == 0) {
            khuVuc = null;
        } else {
            khuVuc = in.readInt();
        }
        soKyHieu = in.readString();
        loaiVanBan = in.readString();
        trichYeu = in.readString();
        nguoiKy = in.readString();
        if (in.readByte() == 0) {
            soDen = null;
        } else {
            soDen = in.readInt();
        }
        ngayNhan = in.readString();
        noiDung = in.readString();
        noiDungTuchoi = in.readString();
        phongGuiLai = in.readString();
        if (in.readByte() == 0) {
            soTrang = null;
        } else {
            soTrang = in.readInt();
        }
        thamMuu = in.readString();
        noiGuiDen = in.readString();
        ngayKy = in.readString();
        linhVuc = in.readString();
        chucVu = in.readString();
        hanGiaiQuyet = in.readString();
        doMat = in.readString();
        doKhan = in.readString();
        byte tmpVbBGD = in.readByte();
        vbBGD = tmpVbBGD == 0 ? null : tmpVbBGD == 1;
        ngayPhanLoai = in.readString();
        trinhTuGiaiQuyets = in.createTypedArrayList(TrinhTuGiaiQuyet.CREATOR);
        trinhTuChuyenNhanLuuVets = in.createTypedArrayList(TrinhTuChuyenNhanLuuVet.CREATOR);
        tepDinhKems = in.createTypedArrayList(TepDinhKem.CREATOR);
        trinhTuGiaiQuyetPhongPhoiHops = in.createTypedArrayList(TrinhTuGiaiQuyetPhongPhoiHop.CREATOR);
        chiDao1 = in.readString();
        chiDao2 = in.readString();
        ketGiaiQuyetPhongPhoiHops = in.createTypedArrayList(KetGiaiQuyetPhongPhoiHop.CREATOR);
        vanbandis = in.createTypedArrayList(Vanbandi.CREATOR);
        chuyenNhanPhoihops = in.createTypedArrayList(ChuyenNhanPhoihop.CREATOR);
        ketGiaiQuyetPhongThuLys = in.createTypedArrayList(KetGiaiQuyetPhongThuLy.CREATOR);
    }

    public static final Creator<VanBanDenChoXuLy> CREATOR = new Creator<VanBanDenChoXuLy>() {
        @Override
        public VanBanDenChoXuLy createFromParcel(Parcel in) {
            return new VanBanDenChoXuLy(in);
        }

        @Override
        public VanBanDenChoXuLy[] newArray(int size) {
            return new VanBanDenChoXuLy[size];
        }
    };

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

    public Integer getISTCPhoiHop() {
        return iSTCPhoiHop;
    }

    public void setISTCPhoiHop(Integer iSTCPhoiHop) {
        this.iSTCPhoiHop = iSTCPhoiHop;
    }

    public Integer getIToCongTac() {
        return iToCongTac;
    }

    public void setIToCongTac(Integer iToCongTac) {
        this.iToCongTac = iToCongTac;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiDungTuchoi() {
        return noiDungTuchoi;
    }

    public void setNoiDungTuchoi(String noiDungTuchoi) {
        this.noiDungTuchoi = noiDungTuchoi;
    }

    public String getPhongGuiLai() {
        return phongGuiLai;
    }

    public void setPhongGuiLai(String phongGuiLai) {
        this.phongGuiLai = phongGuiLai;
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

    public Boolean getVbBGD() {
        return vbBGD;
    }

    public void setVbBGD(Boolean vbBGD) {
        this.vbBGD = vbBGD;
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

    public YKien getYKien() {
        return yKien;
    }

    public void setYKien(YKien yKien) {
        this.yKien = yKien;
    }

    public String getChiDao1() {
        return chiDao1;
    }

    public void setChiDao1(String chiDao1) {
        this.chiDao1 = chiDao1;
    }

    public String getChiDao2() {
        return chiDao2;
    }

    public void setChiDao2(String chiDao2) {
        this.chiDao2 = chiDao2;
    }

    public List<KetGiaiQuyetPhongPhoiHop> getKetGiaiQuyetPhongPhoiHops() {
        return ketGiaiQuyetPhongPhoiHops;
    }

    public void setKetGiaiQuyetPhongPhoiHops(List<KetGiaiQuyetPhongPhoiHop> ketGiaiQuyetPhongPhoiHops) {
        this.ketGiaiQuyetPhongPhoiHops = ketGiaiQuyetPhongPhoiHops;
    }

    public List<Vanbandi> getVanbandis() {
        return vanbandis;
    }

    public void setVanbandis(List<Vanbandi> vanbandis) {
        this.vanbandis = vanbandis;
    }

    public List<ChuyenNhanPhoihop> getChuyenNhanPhoihops() {
        return chuyenNhanPhoihops;
    }

    public void setChuyenNhanPhoihops(List<ChuyenNhanPhoihop> chuyenNhanPhoihops) {
        this.chuyenNhanPhoihops = chuyenNhanPhoihops;
    }

    public List<KetGiaiQuyetPhongThuLy> getKetGiaiQuyetPhongThuLys() {
        return ketGiaiQuyetPhongThuLys;
    }

    public void setKetGiaiQuyetPhongThuLys(List<KetGiaiQuyetPhongThuLy> ketGiaiQuyetPhongThuLys) {
        this.ketGiaiQuyetPhongThuLys = ketGiaiQuyetPhongThuLys;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (idVanBan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idVanBan);
        }
        if (iSTCChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iSTCChuTri);
        }
        if (isVanBanTBKL == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isVanBanTBKL);
        }
        if (isVanBanQPPL == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(isVanBanQPPL);
        }
        if (iSTCPhoiHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iSTCPhoiHop);
        }
        if (iToCongTac == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iToCongTac);
        }
        if (stt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stt);
        }
        if (khuVuc == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(khuVuc);
        }
        dest.writeString(soKyHieu);
        dest.writeString(loaiVanBan);
        dest.writeString(trichYeu);
        dest.writeString(nguoiKy);
        if (soDen == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soDen);
        }
        dest.writeString(ngayNhan);
        dest.writeString(noiDung);
        dest.writeString(noiDungTuchoi);
        dest.writeString(phongGuiLai);
        if (soTrang == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soTrang);
        }
        dest.writeString(thamMuu);
        dest.writeString(noiGuiDen);
        dest.writeString(ngayKy);
        dest.writeString(linhVuc);
        dest.writeString(chucVu);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(doMat);
        dest.writeString(doKhan);
        dest.writeByte((byte) (vbBGD == null ? 0 : vbBGD ? 1 : 2));
        dest.writeString(ngayPhanLoai);
        dest.writeTypedList(trinhTuGiaiQuyets);
        dest.writeTypedList(trinhTuChuyenNhanLuuVets);
        dest.writeTypedList(tepDinhKems);
        dest.writeTypedList(trinhTuGiaiQuyetPhongPhoiHops);
        dest.writeString(chiDao1);
        dest.writeString(chiDao2);
        dest.writeTypedList(ketGiaiQuyetPhongPhoiHops);
        dest.writeTypedList(vanbandis);
        dest.writeTypedList(chuyenNhanPhoihops);
        dest.writeTypedList(ketGiaiQuyetPhongThuLys);
    }
}
