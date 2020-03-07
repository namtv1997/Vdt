package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ChuyenNhanPhoihop implements Parcelable {
    @SerializedName("nguoi_gui")
    @Expose
    private String nguoiGui;
    @SerializedName("nguoi_nhan")
    @Expose
    private String nguoiNhan;
    @SerializedName("thoi_gian_gui")
    @Expose
    private String thoiGianGui;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("file_yeucau")
    @Expose
    private String fileYeucau;
    @SerializedName("file_traloi")
    @Expose
    private String fileTraloi;

    protected ChuyenNhanPhoihop(Parcel in) {
        nguoiGui = in.readString();
        nguoiNhan = in.readString();
        thoiGianGui = in.readString();
        noiDung = in.readString();
        fileYeucau = in.readString();
        fileTraloi = in.readString();
    }

    public static final Creator<ChuyenNhanPhoihop> CREATOR = new Creator<ChuyenNhanPhoihop>() {
        @Override
        public ChuyenNhanPhoihop createFromParcel(Parcel in) {
            return new ChuyenNhanPhoihop(in);
        }

        @Override
        public ChuyenNhanPhoihop[] newArray(int size) {
            return new ChuyenNhanPhoihop[size];
        }
    };

    public String getNguoiGui() {
        return nguoiGui;
    }

    public void setNguoiGui(String nguoiGui) {
        this.nguoiGui = nguoiGui;
    }

    public String getNguoiNhan() {
        return nguoiNhan;
    }

    public void setNguoiNhan(String nguoiNhan) {
        this.nguoiNhan = nguoiNhan;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getFileYeucau() {
        return fileYeucau;
    }

    public void setFileYeucau(String fileYeucau) {
        this.fileYeucau = fileYeucau;
    }

    public String getFileTraloi() {
        return fileTraloi;
    }

    public void setFileTraloi(String fileTraloi) {
        this.fileTraloi = fileTraloi;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(nguoiGui);
        dest.writeString(nguoiNhan);
        dest.writeString(thoiGianGui);
        dest.writeString(noiDung);
        dest.writeString(fileYeucau);
        dest.writeString(fileTraloi);
    }
}
