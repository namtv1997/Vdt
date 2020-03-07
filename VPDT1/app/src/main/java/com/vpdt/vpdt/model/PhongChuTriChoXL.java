package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhongChuTriChoXL implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("TenChiDao")
    @Expose
    private String tenChiDao;
    @SerializedName("noiDungChiDao")
    @Expose
    private String noiDungChiDao;
    @SerializedName("lyDoTuChoiChiDao")
    @Expose
    private String lyDoTuChoiChiDao;
    @SerializedName("lyDoTuChoiCuaChuyenVien")
    @Expose
    private String lyDoTuChoiCuaChuyenVien;
    @SerializedName("canBoTuChoi")
    @Expose
    private String canBoTuChoi;
    @SerializedName("iSTCChuTri")
    @Expose
    private Integer iSTCChuTri;
    @SerializedName("iVanBanTBKL")
    @Expose
    private Integer iVanBanTBKL;
    @SerializedName("iToCongTac")
    @Expose
    private Integer iToCongTac;
    @SerializedName("iSTCPhoiHop")
    @Expose
    private Integer iSTCPhoiHop;
    @SerializedName("iVanBanQPPL")
    @Expose
    private Integer iVanBanQPPL;
    @SerializedName("phongBanChuyenLai")
    @Expose
    private String phongBanChuyenLai;
    @SerializedName("noiDungChuyenLai")
    @Expose
    private String noiDungChuyenLai;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("trangThaiThemHan")
    @Expose
    private Boolean trangThaiThemHan;
    @SerializedName("tuChoiTP")
    @Expose
    private Boolean tuChoiTP;

    protected PhongChuTriChoXL(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        hanGiaiQuyet = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        tenChiDao = in.readString();
        noiDungChiDao = in.readString();
        lyDoTuChoiChiDao = in.readString();
        lyDoTuChoiCuaChuyenVien = in.readString();
        canBoTuChoi = in.readString();
        if (in.readByte() == 0) {
            iSTCChuTri = null;
        } else {
            iSTCChuTri = in.readInt();
        }
        if (in.readByte() == 0) {
            iVanBanTBKL = null;
        } else {
            iVanBanTBKL = in.readInt();
        }
        if (in.readByte() == 0) {
            iToCongTac = null;
        } else {
            iToCongTac = in.readInt();
        }
        if (in.readByte() == 0) {
            iSTCPhoiHop = null;
        } else {
            iSTCPhoiHop = in.readInt();
        }
        if (in.readByte() == 0) {
            iVanBanQPPL = null;
        } else {
            iVanBanQPPL = in.readInt();
        }
        phongBanChuyenLai = in.readString();
        noiDungChuyenLai = in.readString();
        urlFile = in.readString();
        byte tmpTrangThaiThemHan = in.readByte();
        trangThaiThemHan = tmpTrangThaiThemHan == 0 ? null : tmpTrangThaiThemHan == 1;
        byte tmpTuChoiTP = in.readByte();
        tuChoiTP = tmpTuChoiTP == 0 ? null : tmpTuChoiTP == 1;
    }

    public static final Creator<PhongChuTriChoXL> CREATOR = new Creator<PhongChuTriChoXL>() {
        @Override
        public PhongChuTriChoXL createFromParcel(Parcel in) {
            return new PhongChuTriChoXL(in);
        }

        @Override
        public PhongChuTriChoXL[] newArray(int size) {
            return new PhongChuTriChoXL[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getTenChiDao() {
        return tenChiDao;
    }

    public void setTenChiDao(String tenChiDao) {
        this.tenChiDao = tenChiDao;
    }

    public String getNoiDungChiDao() {
        return noiDungChiDao;
    }

    public void setNoiDungChiDao(String noiDungChiDao) {
        this.noiDungChiDao = noiDungChiDao;
    }

    public String getLyDoTuChoiChiDao() {
        return lyDoTuChoiChiDao;
    }

    public void setLyDoTuChoiChiDao(String lyDoTuChoiChiDao) {
        this.lyDoTuChoiChiDao = lyDoTuChoiChiDao;
    }

    public String getLyDoTuChoiCuaChuyenVien() {
        return lyDoTuChoiCuaChuyenVien;
    }

    public void setLyDoTuChoiCuaChuyenVien(String lyDoTuChoiCuaChuyenVien) {
        this.lyDoTuChoiCuaChuyenVien = lyDoTuChoiCuaChuyenVien;
    }

    public String getCanBoTuChoi() {
        return canBoTuChoi;
    }

    public void setCanBoTuChoi(String canBoTuChoi) {
        this.canBoTuChoi = canBoTuChoi;
    }

    public Integer getISTCChuTri() {
        return iSTCChuTri;
    }

    public void setISTCChuTri(Integer iSTCChuTri) {
        this.iSTCChuTri = iSTCChuTri;
    }

    public Integer getIVanBanTBKL() {
        return iVanBanTBKL;
    }

    public void setIVanBanTBKL(Integer iVanBanTBKL) {
        this.iVanBanTBKL = iVanBanTBKL;
    }

    public Integer getIToCongTac() {
        return iToCongTac;
    }

    public void setIToCongTac(Integer iToCongTac) {
        this.iToCongTac = iToCongTac;
    }

    public Integer getISTCPhoiHop() {
        return iSTCPhoiHop;
    }

    public void setISTCPhoiHop(Integer iSTCPhoiHop) {
        this.iSTCPhoiHop = iSTCPhoiHop;
    }

    public Integer getIVanBanQPPL() {
        return iVanBanQPPL;
    }

    public void setIVanBanQPPL(Integer iVanBanQPPL) {
        this.iVanBanQPPL = iVanBanQPPL;
    }

    public String getPhongBanChuyenLai() {
        return phongBanChuyenLai;
    }

    public void setPhongBanChuyenLai(String phongBanChuyenLai) {
        this.phongBanChuyenLai = phongBanChuyenLai;
    }

    public String getNoiDungChuyenLai() {
        return noiDungChuyenLai;
    }

    public void setNoiDungChuyenLai(String noiDungChuyenLai) {
        this.noiDungChuyenLai = noiDungChuyenLai;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Boolean getTrangThaiThemHan() {
        return trangThaiThemHan;
    }

    public void setTrangThaiThemHan(Boolean trangThaiThemHan) {
        this.trangThaiThemHan = trangThaiThemHan;
    }

    public Boolean getTuChoiTP() {
        return tuChoiTP;
    }

    public void setTuChoiTP(Boolean tuChoiTP) {
        this.tuChoiTP = tuChoiTP;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (id == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(id);
        }
        dest.writeString(ngayNhap);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(tenChiDao);
        dest.writeString(noiDungChiDao);
        dest.writeString(lyDoTuChoiChiDao);
        dest.writeString(lyDoTuChoiCuaChuyenVien);
        dest.writeString(canBoTuChoi);
        if (iSTCChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iSTCChuTri);
        }
        if (iVanBanTBKL == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iVanBanTBKL);
        }
        if (iToCongTac == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iToCongTac);
        }
        if (iSTCPhoiHop == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iSTCPhoiHop);
        }
        if (iVanBanQPPL == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iVanBanQPPL);
        }
        dest.writeString(phongBanChuyenLai);
        dest.writeString(noiDungChuyenLai);
        dest.writeString(urlFile);
        dest.writeByte((byte) (trangThaiThemHan == null ? 0 : trangThaiThemHan ? 1 : 2));
        dest.writeByte((byte) (tuChoiTP == null ? 0 : tuChoiTP ? 1 : 2));
    }
}
