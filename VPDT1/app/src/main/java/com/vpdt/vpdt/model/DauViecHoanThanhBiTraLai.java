package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DauViecHoanThanhBiTraLai implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("nguoiNhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("hanVanBan")
    @Expose
    private String hanVanBan;
    @SerializedName("lanhDao")
    @Expose
    private String lanhDao;
    @SerializedName("idLanhDao")
    @Expose
    private Integer idLanhDao;
    @SerializedName("phongChuTri")
    @Expose
    private String phongChuTri;
    @SerializedName("phongPhoiHop")
    @Expose
    private String phongPhoiHop;

    protected DauViecHoanThanhBiTraLai(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        moTa = in.readString();
        nguoiNhap = in.readString();
        ngayNhap = in.readString();
        hanVanBan = in.readString();
        lanhDao = in.readString();
        if (in.readByte() == 0) {
            idLanhDao = null;
        } else {
            idLanhDao = in.readInt();
        }
        phongChuTri = in.readString();
        phongPhoiHop = in.readString();
    }

    public static final Creator<DauViecHoanThanhBiTraLai> CREATOR = new Creator<DauViecHoanThanhBiTraLai>() {
        @Override
        public DauViecHoanThanhBiTraLai createFromParcel(Parcel in) {
            return new DauViecHoanThanhBiTraLai(in);
        }

        @Override
        public DauViecHoanThanhBiTraLai[] newArray(int size) {
            return new DauViecHoanThanhBiTraLai[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHanVanBan() {
        return hanVanBan;
    }

    public void setHanVanBan(String hanVanBan) {
        this.hanVanBan = hanVanBan;
    }

    public String getLanhDao() {
        return lanhDao;
    }

    public void setLanhDao(String lanhDao) {
        this.lanhDao = lanhDao;
    }

    public Integer getIdLanhDao() {
        return idLanhDao;
    }

    public void setIdLanhDao(Integer idLanhDao) {
        this.idLanhDao = idLanhDao;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public String getPhongPhoiHop() {
        return phongPhoiHop;
    }

    public void setPhongPhoiHop(String phongPhoiHop) {
        this.phongPhoiHop = phongPhoiHop;
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
        dest.writeString(moTa);
        dest.writeString(nguoiNhap);
        dest.writeString(ngayNhap);
        dest.writeString(hanVanBan);
        dest.writeString(lanhDao);
        if (idLanhDao == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idLanhDao);
        }
        dest.writeString(phongChuTri);
        dest.writeString(phongPhoiHop);
    }
}
