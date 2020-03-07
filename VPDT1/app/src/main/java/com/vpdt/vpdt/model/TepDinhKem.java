package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TepDinhKem implements Parcelable {
    @SerializedName("stt")
    @Expose
    private String stt;
    @SerializedName("ten_tep")
    @Expose
    private String tenTep;
    @SerializedName("duong_dan")
    @Expose
    private String duongDan;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;

    protected TepDinhKem(Parcel in) {
        stt = in.readString();
        tenTep = in.readString();
        duongDan = in.readString();
        ngayNhap = in.readString();
    }

    public static final Creator<TepDinhKem> CREATOR = new Creator<TepDinhKem>() {
        @Override
        public TepDinhKem createFromParcel(Parcel in) {
            return new TepDinhKem(in);
        }

        @Override
        public TepDinhKem[] newArray(int size) {
            return new TepDinhKem[size];
        }
    };

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getTenTep() {
        return tenTep;
    }

    public void setTenTep(String tenTep) {
        this.tenTep = tenTep;
    }

    public String getDuongDan() {
        return duongDan;
    }

    public void setDuongDan(String duongDan) {
        this.duongDan = duongDan;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(stt);
        dest.writeString(tenTep);
        dest.writeString(duongDan);
        dest.writeString(ngayNhap);
    }
}
