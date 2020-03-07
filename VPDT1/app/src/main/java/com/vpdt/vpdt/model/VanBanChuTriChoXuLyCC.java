package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanChuTriChoXuLyCC implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soVBDi")
    @Expose
    private Integer soVBDi;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("nguoiGui")
    @Expose
    private String nguoiGui;
    @SerializedName("thoiGian")
    @Expose
    private String thoiGian;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("yKien")
    @Expose
    private String yKien;

    protected VanBanChuTriChoXuLyCC(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        soKyHieu = in.readString();
        if (in.readByte() == 0) {
            soVBDi = null;
        } else {
            soVBDi = in.readInt();
        }
        moTa = in.readString();
        nguoiNhap = in.readString();
        nguoiGui = in.readString();
        thoiGian = in.readString();
        urlFile = in.readString();
        yKien = in.readString();
    }

    public static final Creator<VanBanChuTriChoXuLyCC> CREATOR = new Creator<VanBanChuTriChoXuLyCC>() {
        @Override
        public VanBanChuTriChoXuLyCC createFromParcel(Parcel in) {
            return new VanBanChuTriChoXuLyCC(in);
        }

        @Override
        public VanBanChuTriChoXuLyCC[] newArray(int size) {
            return new VanBanChuTriChoXuLyCC[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public Integer getSoVBDi() {
        return soVBDi;
    }

    public void setSoVBDi(Integer soVBDi) {
        this.soVBDi = soVBDi;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getYKien() {
        return yKien;
    }

    public void setYKien(String yKien) {
        this.yKien = yKien;
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
        dest.writeString(soKyHieu);
        if (soVBDi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soVBDi);
        }
        dest.writeString(moTa);
        dest.writeString(nguoiNhap);
        dest.writeString(nguoiGui);
        dest.writeString(thoiGian);
        dest.writeString(urlFile);
        dest.writeString(yKien);
    }
}
