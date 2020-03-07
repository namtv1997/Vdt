package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DauViecHoanThanhChoLanhDaoPhongDuyet implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("tieuDe")
    @Expose
    private String tieuDe;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("thoiGian")
    @Expose
    private String thoiGian;

    protected DauViecHoanThanhChoLanhDaoPhongDuyet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        moTa = in.readString();
        tieuDe = in.readString();
        loaiVanBan = in.readString();
        urlFile = in.readString();
        thoiGian = in.readString();
    }

    public static final Creator<DauViecHoanThanhChoLanhDaoPhongDuyet> CREATOR = new Creator<DauViecHoanThanhChoLanhDaoPhongDuyet>() {
        @Override
        public DauViecHoanThanhChoLanhDaoPhongDuyet createFromParcel(Parcel in) {
            return new DauViecHoanThanhChoLanhDaoPhongDuyet(in);
        }

        @Override
        public DauViecHoanThanhChoLanhDaoPhongDuyet[] newArray(int size) {
            return new DauViecHoanThanhChoLanhDaoPhongDuyet[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getTieuDe() {
        return tieuDe;
    }

    public void setTieuDe(String tieuDe) {
        this.tieuDe = tieuDe;
    }

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
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
        dest.writeString(moTa);
        dest.writeString(tieuDe);
        dest.writeString(loaiVanBan);
        dest.writeString(urlFile);
        dest.writeString(thoiGian);
    }
}
