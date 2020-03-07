package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanChuTriChoXuLy implements Parcelable {
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
    @SerializedName("lyDoTuChoiCuaChuyenVien")
    @Expose
    private String lyDoTuChoiCuaChuyenVien;
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
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idChuyenVien")
    @Expose
    private Integer idChuyenVien;
    @SerializedName("tenChuyenVien")
    @Expose
    private String tenChuyenVien;
    @SerializedName("idPhoiHops")
    @Expose
    private String idPhoiHops;
    @SerializedName("hanXuLy")
    @Expose
    private String hanXuLy;
    @SerializedName("allowThemHan")
    @Expose
    private Boolean allowThemHan;
    @SerializedName("allowTuChoi")
    @Expose
    private Boolean allowTuChoi;
    @SerializedName("vBDauRaTP")
    @Expose
    private Integer vBDauRaTP;
    @SerializedName("vBDauRaTPText")
    @Expose
    private String vBDauRaTPText;
    @SerializedName("chidaoChuTri")
    @Expose
    private String chidaoChuTri;

    protected VanBanChuTriChoXuLy(Parcel in) {
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
        lyDoTuChoiCuaChuyenVien = in.readString();
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
        urlFile = in.readString();
        if (in.readByte() == 0) {
            idChuyenVien = null;
        } else {
            idChuyenVien = in.readInt();
        }
        tenChuyenVien = in.readString();
        idPhoiHops = in.readString();
        hanXuLy = in.readString();
        byte tmpAllowThemHan = in.readByte();
        allowThemHan = tmpAllowThemHan == 0 ? null : tmpAllowThemHan == 1;
        byte tmpAllowTuChoi = in.readByte();
        allowTuChoi = tmpAllowTuChoi == 0 ? null : tmpAllowTuChoi == 1;
        if (in.readByte() == 0) {
            vBDauRaTP = null;
        } else {
            vBDauRaTP = in.readInt();
        }
        vBDauRaTPText = in.readString();
        chidaoChuTri = in.readString();
    }

    public static final Creator<VanBanChuTriChoXuLy> CREATOR = new Creator<VanBanChuTriChoXuLy>() {
        @Override
        public VanBanChuTriChoXuLy createFromParcel(Parcel in) {
            return new VanBanChuTriChoXuLy(in);
        }

        @Override
        public VanBanChuTriChoXuLy[] newArray(int size) {
            return new VanBanChuTriChoXuLy[size];
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

    public String getLyDoTuChoiCuaChuyenVien() {
        return lyDoTuChoiCuaChuyenVien;
    }

    public void setLyDoTuChoiCuaChuyenVien(String lyDoTuChoiCuaChuyenVien) {
        this.lyDoTuChoiCuaChuyenVien = lyDoTuChoiCuaChuyenVien;
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

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public Integer getIdChuyenVien() {
        return idChuyenVien;
    }

    public void setIdChuyenVien(Integer idChuyenVien) {
        this.idChuyenVien = idChuyenVien;
    }

    public String getTenChuyenVien() {
        return tenChuyenVien;
    }

    public void setTenChuyenVien(String tenChuyenVien) {
        this.tenChuyenVien = tenChuyenVien;
    }

    public String getIdPhoiHops() {
        return idPhoiHops;
    }

    public void setIdPhoiHops(String idPhoiHops) {
        this.idPhoiHops = idPhoiHops;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
    }

    public Boolean getAllowThemHan() {
        return allowThemHan;
    }

    public void setAllowThemHan(Boolean allowThemHan) {
        this.allowThemHan = allowThemHan;
    }

    public Boolean getAllowTuChoi() {
        return allowTuChoi;
    }

    public void setAllowTuChoi(Boolean allowTuChoi) {
        this.allowTuChoi = allowTuChoi;
    }

    public Integer getVBDauRaTP() {
        return vBDauRaTP;
    }

    public void setVBDauRaTP(Integer vBDauRaTP) {
        this.vBDauRaTP = vBDauRaTP;
    }

    public String getVBDauRaTPText() {
        return vBDauRaTPText;
    }

    public void setVBDauRaTPText(String vBDauRaTPText) {
        this.vBDauRaTPText = vBDauRaTPText;
    }

    public String getChidaoChuTri() {
        return chidaoChuTri;
    }

    public void setChidaoChuTri(String chidaoChuTri) {
        this.chidaoChuTri = chidaoChuTri;
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
        dest.writeString(lyDoTuChoiCuaChuyenVien);
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
        dest.writeString(urlFile);
        if (idChuyenVien == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idChuyenVien);
        }
        dest.writeString(tenChuyenVien);
        dest.writeString(idPhoiHops);
        dest.writeString(hanXuLy);
        dest.writeByte((byte) (allowThemHan == null ? 0 : allowThemHan ? 1 : 2));
        dest.writeByte((byte) (allowTuChoi == null ? 0 : allowTuChoi ? 1 : 2));
        if (vBDauRaTP == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(vBDauRaTP);
        }
        dest.writeString(vBDauRaTPText);
        dest.writeString(chidaoChuTri);
    }
}
