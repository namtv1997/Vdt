package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DanhSachPhongPhoiHopDaChiDaoTPCC implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("items")
    @Expose
    private List<ItemDanhSachPhongPhoiHopDaChiDaoTPCC> items = null;

    protected DanhSachPhongPhoiHopDaChiDaoTPCC(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        noiDung = in.readString();
        urlFile = in.readString();
        items = in.createTypedArrayList(ItemDanhSachPhongPhoiHopDaChiDaoTPCC.CREATOR);
    }

    public static final Creator<DanhSachPhongPhoiHopDaChiDaoTPCC> CREATOR = new Creator<DanhSachPhongPhoiHopDaChiDaoTPCC>() {
        @Override
        public DanhSachPhongPhoiHopDaChiDaoTPCC createFromParcel(Parcel in) {
            return new DanhSachPhongPhoiHopDaChiDaoTPCC(in);
        }

        @Override
        public DanhSachPhongPhoiHopDaChiDaoTPCC[] newArray(int size) {
            return new DanhSachPhongPhoiHopDaChiDaoTPCC[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public List<ItemDanhSachPhongPhoiHopDaChiDaoTPCC> getItems() {
        return items;
    }

    public void setItems(List<ItemDanhSachPhongPhoiHopDaChiDaoTPCC> items) {
        this.items = items;
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
        dest.writeString(noiDung);
        dest.writeString(urlFile);
        dest.writeTypedList(items);
    }
}
