package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GiayMoiXemDeBiet implements Parcelable {
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
    @SerializedName("giay_moi_ngay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giay_moi_gio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giay_moi_diadiem")
    @Expose
    private String giayMoiDiadiem;

    protected GiayMoiXemDeBiet(Parcel in) {
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
        giayMoiNgay = in.readString();
        giayMoiGio = in.readString();
        giayMoiDiadiem = in.readString();
    }

    public static final Creator<GiayMoiXemDeBiet> CREATOR = new Creator<GiayMoiXemDeBiet>() {
        @Override
        public GiayMoiXemDeBiet createFromParcel(Parcel in) {
            return new GiayMoiXemDeBiet(in);
        }

        @Override
        public GiayMoiXemDeBiet[] newArray(int size) {
            return new GiayMoiXemDeBiet[size];
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

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiDiadiem() {
        return giayMoiDiadiem;
    }

    public void setGiayMoiDiadiem(String giayMoiDiadiem) {
        this.giayMoiDiadiem = giayMoiDiadiem;
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
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiDiadiem);
    }
}
