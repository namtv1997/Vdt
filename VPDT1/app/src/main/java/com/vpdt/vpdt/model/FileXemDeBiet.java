package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class FileXemDeBiet implements Parcelable {
    @SerializedName("ten_file")
    @Expose
    private String tenFile;
    @SerializedName("url")
    @Expose
    private String url;

    protected FileXemDeBiet(Parcel in) {
        tenFile = in.readString();
        url = in.readString();
    }

    public static final Creator<FileXemDeBiet> CREATOR = new Creator<FileXemDeBiet>() {
        @Override
        public FileXemDeBiet createFromParcel(Parcel in) {
            return new FileXemDeBiet(in);
        }

        @Override
        public FileXemDeBiet[] newArray(int size) {
            return new FileXemDeBiet[size];
        }
    };

    public String getTenFile() {
        return tenFile;
    }

    public void setTenFile(String tenFile) {
        this.tenFile = tenFile;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(tenFile);
        dest.writeString(url);
    }
}
