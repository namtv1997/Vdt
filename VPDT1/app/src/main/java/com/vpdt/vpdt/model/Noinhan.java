package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Noinhan implements Parcelable {
    @SerializedName("mthu")
    @Expose
    private String mthu;

    protected Noinhan(Parcel in) {
        mthu = in.readString();
    }

    public static final Creator<Noinhan> CREATOR = new Creator<Noinhan>() {
        @Override
        public Noinhan createFromParcel(Parcel in) {
            return new Noinhan(in);
        }

        @Override
        public Noinhan[] newArray(int size) {
            return new Noinhan[size];
        }
    };

    public String getMthu() {
        return mthu;
    }

    public void setMthu(String mthu) {
        this.mthu = mthu;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mthu);
    }
}
