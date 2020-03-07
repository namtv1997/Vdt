package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TrichyeuChoSoCuaSo implements Parcelable {
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("soden")
    @Expose
    private String soden;
    @SerializedName("nguoiky")
    @Expose
    private String nguoiky;
    @SerializedName("ngaynhap")
    @Expose
    private String ngaynhap;

    protected TrichyeuChoSoCuaSo(Parcel in) {
        mota = in.readString();
        soden = in.readString();
        nguoiky = in.readString();
        ngaynhap = in.readString();
    }

    public static final Creator<TrichyeuChoSoCuaSo> CREATOR = new Creator<TrichyeuChoSoCuaSo>() {
        @Override
        public TrichyeuChoSoCuaSo createFromParcel(Parcel in) {
            return new TrichyeuChoSoCuaSo(in);
        }

        @Override
        public TrichyeuChoSoCuaSo[] newArray(int size) {
            return new TrichyeuChoSoCuaSo[size];
        }
    };

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getSoden() {
        return soden;
    }

    public void setSoden(String soden) {
        this.soden = soden;
    }

    public String getNguoiky() {
        return nguoiky;
    }

    public void setNguoiky(String nguoiky) {
        this.nguoiky = nguoiky;
    }

    public String getNgaynhap() {
        return ngaynhap;
    }

    public void setNgaynhap(String ngaynhap) {
        this.ngaynhap = ngaynhap;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mota);
        dest.writeString(soden);
        dest.writeString(nguoiky);
        dest.writeString(ngaynhap);
    }
}
