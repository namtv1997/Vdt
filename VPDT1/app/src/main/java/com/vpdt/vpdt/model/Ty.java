package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ty implements Parcelable {
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("iFile")
    @Expose
    private Integer iFile;
    @SerializedName("nguoiKy")
    @Expose
    private String nguoiKy;
    @SerializedName("duongdan")
    @Expose
    private String duongdan;

    protected Ty(Parcel in) {
        mota = in.readString();
        if (in.readByte() == 0) {
            iFile = null;
        } else {
            iFile = in.readInt();
        }
        nguoiKy = in.readString();
        duongdan = in.readString();
    }

    public static final Creator<Ty> CREATOR = new Creator<Ty>() {
        @Override
        public Ty createFromParcel(Parcel in) {
            return new Ty(in);
        }

        @Override
        public Ty[] newArray(int size) {
            return new Ty[size];
        }
    };

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public Integer getIFile() {
        return iFile;
    }

    public void setIFile(Integer iFile) {
        this.iFile = iFile;
    }

    public String getNguoiKy() {
        return nguoiKy;
    }

    public void setNguoiKy(String nguoiKy) {
        this.nguoiKy = nguoiKy;
    }

    public String getDuongdan() {
        return duongdan;
    }

    public void setDuongdan(String duongdan) {
        this.duongdan = duongdan;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mota);
        if (iFile == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(iFile);
        }
        dest.writeString(nguoiKy);
        dest.writeString(duongdan);
    }
}
