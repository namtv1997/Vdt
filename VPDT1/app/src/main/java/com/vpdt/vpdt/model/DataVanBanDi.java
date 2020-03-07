package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataVanBanDi implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ykien")
    @Expose
    private String ykien;
    @SerializedName("can_bo_gui")
    @Expose
    private String canBoGui;
    @SerializedName("thoi_gian_gui")
    @Expose
    private String thoiGianGui;
    @SerializedName("duong_dan_file")
    @Expose
    private String duongDanFile;
    @SerializedName("trang_thai_cap_so")
    @Expose
    private Integer trangThaiCapSo;

    protected DataVanBanDi(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        kyHieu = in.readString();
        mota = in.readString();
        nguoiNhap = in.readString();
        ykien = in.readString();
        canBoGui = in.readString();
        thoiGianGui = in.readString();
        duongDanFile = in.readString();
        if (in.readByte() == 0) {
            trangThaiCapSo = null;
        } else {
            trangThaiCapSo = in.readInt();
        }
    }

    public static final Creator<DataVanBanDi> CREATOR = new Creator<DataVanBanDi>() {
        @Override
        public DataVanBanDi createFromParcel(Parcel in) {
            return new DataVanBanDi(in);
        }

        @Override
        public DataVanBanDi[] newArray(int size) {
            return new DataVanBanDi[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getYkien() {
        return ykien;
    }

    public void setYkien(String ykien) {
        this.ykien = ykien;
    }

    public String getCanBoGui() {
        return canBoGui;
    }

    public void setCanBoGui(String canBoGui) {
        this.canBoGui = canBoGui;
    }

    public String getThoiGianGui() {
        return thoiGianGui;
    }

    public void setThoiGianGui(String thoiGianGui) {
        this.thoiGianGui = thoiGianGui;
    }

    public String getDuongDanFile() {
        return duongDanFile;
    }

    public void setDuongDanFile(String duongDanFile) {
        this.duongDanFile = duongDanFile;
    }

    public Integer getTrangThaiCapSo() {
        return trangThaiCapSo;
    }

    public void setTrangThaiCapSo(Integer trangThaiCapSo) {
        this.trangThaiCapSo = trangThaiCapSo;
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
        dest.writeString(kyHieu);
        dest.writeString(mota);
        dest.writeString(nguoiNhap);
        dest.writeString(ykien);
        dest.writeString(canBoGui);
        dest.writeString(thoiGianGui);
        dest.writeString(duongDanFile);
        if (trangThaiCapSo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trangThaiCapSo);
        }
    }
}
