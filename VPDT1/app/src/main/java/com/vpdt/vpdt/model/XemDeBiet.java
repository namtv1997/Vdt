package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class XemDeBiet implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("so_ky_hieu")
    @Expose
    private String soKyHieu;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("luu_y")
    @Expose
    private String luuY;
    @SerializedName("chi_dao")
    @Expose
    private String chiDao;
    @SerializedName("files")
    @Expose
    private List<FileXemDeBiet> files = null;
    @SerializedName("thuoc_loai")
    @Expose
    private String thuocLoai;
    @SerializedName("han_gia_quyet")
    @Expose
    private String hanGiaQuyet;

    protected XemDeBiet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        mota = in.readString();
        luuY = in.readString();
        chiDao = in.readString();
        files = in.createTypedArrayList(FileXemDeBiet.CREATOR);
        thuocLoai = in.readString();
        hanGiaQuyet = in.readString();
    }

    public static final Creator<XemDeBiet> CREATOR = new Creator<XemDeBiet>() {
        @Override
        public XemDeBiet createFromParcel(Parcel in) {
            return new XemDeBiet(in);
        }

        @Override
        public XemDeBiet[] newArray(int size) {
            return new XemDeBiet[size];
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getLuuY() {
        return luuY;
    }

    public void setLuuY(String luuY) {
        this.luuY = luuY;
    }

    public String getChiDao() {
        return chiDao;
    }

    public void setChiDao(String chiDao) {
        this.chiDao = chiDao;
    }

    public List<FileXemDeBiet> getFiles() {
        return files;
    }

    public void setFiles(List<FileXemDeBiet> files) {
        this.files = files;
    }

    public String getThuocLoai() {
        return thuocLoai;
    }

    public void setThuocLoai(String thuocLoai) {
        this.thuocLoai = thuocLoai;
    }

    public String getHanGiaQuyet() {
        return hanGiaQuyet;
    }

    public void setHanGiaQuyet(String hanGiaQuyet) {
        this.hanGiaQuyet = hanGiaQuyet;
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
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(mota);
        dest.writeString(luuY);
        dest.writeString(chiDao);
        dest.writeTypedList(files);
        dest.writeString(thuocLoai);
        dest.writeString(hanGiaQuyet);
    }
}
