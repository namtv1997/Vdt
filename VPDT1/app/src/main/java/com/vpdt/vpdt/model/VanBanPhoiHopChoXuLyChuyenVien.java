package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanPhoiHopChoXuLyChuyenVien implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("chiDaoCuaPhong")
    @Expose
    private String chiDaoCuaPhong;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;

    protected VanBanPhoiHopChoXuLyChuyenVien(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        moTa = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        chiDaoCuaPhong = in.readString();
        trinhTuXuLy = in.createStringArrayList();
    }

    public static final Creator<VanBanPhoiHopChoXuLyChuyenVien> CREATOR = new Creator<VanBanPhoiHopChoXuLyChuyenVien>() {
        @Override
        public VanBanPhoiHopChoXuLyChuyenVien createFromParcel(Parcel in) {
            return new VanBanPhoiHopChoXuLyChuyenVien(in);
        }

        @Override
        public VanBanPhoiHopChoXuLyChuyenVien[] newArray(int size) {
            return new VanBanPhoiHopChoXuLyChuyenVien[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getChiDaoCuaPhong() {
        return chiDaoCuaPhong;
    }

    public void setChiDaoCuaPhong(String chiDaoCuaPhong) {
        this.chiDaoCuaPhong = chiDaoCuaPhong;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
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
        dest.writeString(ngayNhap);
        dest.writeString(moTa);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        dest.writeString(chiDaoCuaPhong);
        dest.writeStringList(trinhTuXuLy);
    }
}
