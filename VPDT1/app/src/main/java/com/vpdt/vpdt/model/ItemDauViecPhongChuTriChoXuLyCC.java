package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ItemDauViecPhongChuTriChoXuLyCC implements Parcelable {
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
    @SerializedName("canBoChiDao")
    @Expose
    private String canBoChiDao;
    @SerializedName("noiDungChiDao")
    @Expose
    private String noiDungChiDao;
    @SerializedName("idPhongChuTri")
    @Expose
    private Integer idPhongChuTri;
    @SerializedName("tenPhongChuTri")
    @Expose
    private String tenPhongChuTri;
    @SerializedName("idPhongPhoiHops")
    @Expose
    private String idPhongPhoiHops;
    @SerializedName("chiDao")
    @Expose
    private String chiDao;
    @SerializedName("ChidaoChuTri")
    @Expose
    private String chidaoChuTri;
    @SerializedName("hanXuLy")
    @Expose
    private String hanXuLy;

    protected ItemDauViecPhongChuTriChoXuLyCC(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        moTa = in.readString();
        nguoiNhap = in.readString();
        ngayNhap = in.readString();
        hanVanBan = in.readString();
        canBoChiDao = in.readString();
        noiDungChiDao = in.readString();
        if (in.readByte() == 0) {
            idPhongChuTri = null;
        } else {
            idPhongChuTri = in.readInt();
        }
        tenPhongChuTri = in.readString();
        idPhongPhoiHops = in.readString();
        chiDao = in.readString();
        chidaoChuTri = in.readString();
        hanXuLy = in.readString();
    }

    public static final Creator<ItemDauViecPhongChuTriChoXuLyCC> CREATOR = new Creator<ItemDauViecPhongChuTriChoXuLyCC>() {
        @Override
        public ItemDauViecPhongChuTriChoXuLyCC createFromParcel(Parcel in) {
            return new ItemDauViecPhongChuTriChoXuLyCC(in);
        }

        @Override
        public ItemDauViecPhongChuTriChoXuLyCC[] newArray(int size) {
            return new ItemDauViecPhongChuTriChoXuLyCC[size];
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

    public String getCanBoChiDao() {
        return canBoChiDao;
    }

    public void setCanBoChiDao(String canBoChiDao) {
        this.canBoChiDao = canBoChiDao;
    }

    public String getNoiDungChiDao() {
        return noiDungChiDao;
    }

    public void setNoiDungChiDao(String noiDungChiDao) {
        this.noiDungChiDao = noiDungChiDao;
    }

    public Integer getIdPhongChuTri() {
        return idPhongChuTri;
    }

    public void setIdPhongChuTri(Integer idPhongChuTri) {
        this.idPhongChuTri = idPhongChuTri;
    }

    public String getTenPhongChuTri() {
        return tenPhongChuTri;
    }

    public void setTenPhongChuTri(String tenPhongChuTri) {
        this.tenPhongChuTri = tenPhongChuTri;
    }

    public String getIdPhongPhoiHops() {
        return idPhongPhoiHops;
    }

    public void setIdPhongPhoiHops(String idPhongPhoiHops) {
        this.idPhongPhoiHops = idPhongPhoiHops;
    }

    public String getChiDao() {
        return chiDao;
    }

    public void setChiDao(String chiDao) {
        this.chiDao = chiDao;
    }

    public String getChidaoChuTri() {
        return chidaoChuTri;
    }

    public void setChidaoChuTri(String chidaoChuTri) {
        this.chidaoChuTri = chidaoChuTri;
    }

    public String getHanXuLy() {
        return hanXuLy;
    }

    public void setHanXuLy(String hanXuLy) {
        this.hanXuLy = hanXuLy;
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
        dest.writeString(canBoChiDao);
        dest.writeString(noiDungChiDao);
        if (idPhongChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongChuTri);
        }
        dest.writeString(tenPhongChuTri);
        dest.writeString(idPhongPhoiHops);
        dest.writeString(chiDao);
        dest.writeString(chidaoChuTri);
        dest.writeString(hanXuLy);
    }
}
