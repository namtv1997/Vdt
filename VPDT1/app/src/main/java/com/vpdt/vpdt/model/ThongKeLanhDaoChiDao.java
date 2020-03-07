package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongKeLanhDaoChiDao implements Parcelable {
    @SerializedName("ma_phoGD")
    @Expose
    private Integer maPhoGD;
    @SerializedName("phoGD")
    @Expose
    private String phoGD;
    @SerializedName("solgVB")
    @Expose
    private Integer solgVB;

    protected ThongKeLanhDaoChiDao(Parcel in) {
        if (in.readByte() == 0) {
            maPhoGD = null;
        } else {
            maPhoGD = in.readInt();
        }
        phoGD = in.readString();
        if (in.readByte() == 0) {
            solgVB = null;
        } else {
            solgVB = in.readInt();
        }
    }

    public static final Creator<ThongKeLanhDaoChiDao> CREATOR = new Creator<ThongKeLanhDaoChiDao>() {
        @Override
        public ThongKeLanhDaoChiDao createFromParcel(Parcel in) {
            return new ThongKeLanhDaoChiDao(in);
        }

        @Override
        public ThongKeLanhDaoChiDao[] newArray(int size) {
            return new ThongKeLanhDaoChiDao[size];
        }
    };

    public Integer getMaPhoGD() {
        return maPhoGD;
    }

    public void setMaPhoGD(Integer maPhoGD) {
        this.maPhoGD = maPhoGD;
    }

    public String getPhoGD() {
        return phoGD;
    }

    public void setPhoGD(String phoGD) {
        this.phoGD = phoGD;
    }

    public Integer getSolgVB() {
        return solgVB;
    }

    public void setSolgVB(Integer solgVB) {
        this.solgVB = solgVB;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (maPhoGD == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(maPhoGD);
        }
        dest.writeString(phoGD);
        if (solgVB == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(solgVB);
        }
    }
}
