package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrinhTuChuyenNhanLuuVet implements Parcelable {
    @SerializedName("stt")
    @Expose
    private Integer stt;
    @SerializedName("ngay_nhan")
    @Expose
    private String ngayNhan;
    @SerializedName("chuyen_tu")
    @Expose
    private String chuyenTu;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("chuyen_den")
    @Expose
    private String chuyenDen;

    protected TrinhTuChuyenNhanLuuVet(Parcel in) {
        if (in.readByte() == 0) {
            stt = null;
        } else {
            stt = in.readInt();
        }
        ngayNhan = in.readString();
        chuyenTu = in.readString();
        noiDung = in.readString();
        chuyenDen = in.readString();
    }

    public static final Creator<TrinhTuChuyenNhanLuuVet> CREATOR = new Creator<TrinhTuChuyenNhanLuuVet>() {
        @Override
        public TrinhTuChuyenNhanLuuVet createFromParcel(Parcel in) {
            return new TrinhTuChuyenNhanLuuVet(in);
        }

        @Override
        public TrinhTuChuyenNhanLuuVet[] newArray(int size) {
            return new TrinhTuChuyenNhanLuuVet[size];
        }
    };

    public Integer getStt() {
        return stt;
    }

    public void setStt(Integer stt) {
        this.stt = stt;
    }

    public String getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(String ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public String getChuyenTu() {
        return chuyenTu;
    }

    public void setChuyenTu(String chuyenTu) {
        this.chuyenTu = chuyenTu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getChuyenDen() {
        return chuyenDen;
    }

    public void setChuyenDen(String chuyenDen) {
        this.chuyenDen = chuyenDen;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (stt == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(stt);
        }
        dest.writeString(ngayNhan);
        dest.writeString(chuyenTu);
        dest.writeString(noiDung);
        dest.writeString(chuyenDen);
    }
}
