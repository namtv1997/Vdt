package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PhanLoaiVanBan implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
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
    @SerializedName("noiDungTuChoi")
    @Expose
    private String noiDungTuChoi;
    @SerializedName("tenPhongGuiLai")
    @Expose
    private String tenPhongGuiLai;
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
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;

    protected PhanLoaiVanBan(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        noiDungTuChoi = in.readString();
        tenPhongGuiLai = in.readString();
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
        urlFile = in.readString();
        hanGiaiQuyet = in.readString();
    }

    public static final Creator<PhanLoaiVanBan> CREATOR = new Creator<PhanLoaiVanBan>() {
        @Override
        public PhanLoaiVanBan createFromParcel(Parcel in) {
            return new PhanLoaiVanBan(in);
        }

        @Override
        public PhanLoaiVanBan[] newArray(int size) {
            return new PhanLoaiVanBan[size];
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

    public String getNoiDungTuChoi() {
        return noiDungTuChoi;
    }

    public void setNoiDungTuChoi(String noiDungTuChoi) {
        this.noiDungTuChoi = noiDungTuChoi;
    }

    public String getTenPhongGuiLai() {
        return tenPhongGuiLai;
    }

    public void setTenPhongGuiLai(String tenPhongGuiLai) {
        this.tenPhongGuiLai = tenPhongGuiLai;
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

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(noiDungTuChoi);
        dest.writeString(tenPhongGuiLai);
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
        dest.writeString(urlFile);
        dest.writeString(hanGiaiQuyet);
    }
}
