package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ThongKeLanhDaoChiDaoTheoPhong implements Parcelable {
    @SerializedName("ma_pb")
    @Expose
    private Integer maPb;
    @SerializedName("phongBan")
    @Expose
    private String phongBan;
    @SerializedName("solgVB")
    @Expose
    private Integer solgVB;

    protected ThongKeLanhDaoChiDaoTheoPhong(Parcel in) {
        if (in.readByte() == 0) {
            maPb = null;
        } else {
            maPb = in.readInt();
        }
        phongBan = in.readString();
        if (in.readByte() == 0) {
            solgVB = null;
        } else {
            solgVB = in.readInt();
        }
    }

    public static final Creator<ThongKeLanhDaoChiDaoTheoPhong> CREATOR = new Creator<ThongKeLanhDaoChiDaoTheoPhong>() {
        @Override
        public ThongKeLanhDaoChiDaoTheoPhong createFromParcel(Parcel in) {
            return new ThongKeLanhDaoChiDaoTheoPhong(in);
        }

        @Override
        public ThongKeLanhDaoChiDaoTheoPhong[] newArray(int size) {
            return new ThongKeLanhDaoChiDaoTheoPhong[size];
        }
    };

    public Integer getMaPb() {
        return maPb;
    }

    public void setMaPb(Integer maPb) {
        this.maPb = maPb;
    }

    public String getPhongBan() {
        return phongBan;
    }

    public void setPhongBan(String phongBan) {
        this.phongBan = phongBan;
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
        if (maPb == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(maPb);
        }
        dest.writeString(phongBan);
        if (solgVB == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(solgVB);
        }
    }
}
