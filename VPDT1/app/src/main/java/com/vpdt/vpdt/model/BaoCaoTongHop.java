package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaoCaoTongHop implements Parcelable {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phongban")
    @Expose
    private List<PhongbanBaoCaoTongHop> phongban = null;

    protected BaoCaoTongHop(Parcel in) {
        name = in.readString();
        phongban = in.createTypedArrayList(PhongbanBaoCaoTongHop.CREATOR);
    }

    public static final Creator<BaoCaoTongHop> CREATOR = new Creator<BaoCaoTongHop>() {
        @Override
        public BaoCaoTongHop createFromParcel(Parcel in) {
            return new BaoCaoTongHop(in);
        }

        @Override
        public BaoCaoTongHop[] newArray(int size) {
            return new BaoCaoTongHop[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhongbanBaoCaoTongHop> getPhongban() {
        return phongban;
    }

    public void setPhongban(List<PhongbanBaoCaoTongHop> phongban) {
        this.phongban = phongban;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeTypedList(phongban);
    }
}
