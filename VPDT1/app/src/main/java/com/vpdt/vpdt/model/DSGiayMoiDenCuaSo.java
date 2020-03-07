package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DSGiayMoiDenCuaSo  implements Parcelable{

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("loai_vanban")
    @Expose
    private String loaiVanban;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("so_kyhieu")
    @Expose
    private String soKyhieu;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("giay_moi_ngay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giay_moi_gio")
    @Expose
    private String giayMoiGio;
    @SerializedName("mota2")
    @Expose
    private String mota2;
    @SerializedName("giay_moi_diadiem")
    @Expose
    private String giayMoiDiadiem;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;
    @SerializedName("ket_qua_thuchien")
    @Expose
    private String ketQuaThuchien;
    @SerializedName("so_trang")
    @Expose
    private Integer soTrang;
    @SerializedName("chu_tri")
    @Expose
    private String chuTri;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;

    protected DSGiayMoiDenCuaSo(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        loaiVanban = in.readString();
        soDen = in.readString();
        soKyhieu = in.readString();
        mota = in.readString();
        giayMoiNgay = in.readString();
        giayMoiGio = in.readString();
        mota2 = in.readString();
        giayMoiDiadiem = in.readString();
        nguoiNhap = in.readString();
        noiDung = in.readString();
        noiGui = in.readString();
        phongChuTri = in.readString();
        ketQuaThuchien = in.readString();
        if (in.readByte() == 0) {
            soTrang = null;
        } else {
            soTrang = in.readInt();
        }
        chuTri = in.readString();
        tepDinhKems = in.createTypedArrayList(TepDinhKem.CREATOR);
    }

    public static final Creator<DSGiayMoiDenCuaSo> CREATOR = new Creator<DSGiayMoiDenCuaSo>() {
        @Override
        public DSGiayMoiDenCuaSo createFromParcel(Parcel in) {
            return new DSGiayMoiDenCuaSo(in);
        }

        @Override
        public DSGiayMoiDenCuaSo[] newArray(int size) {
            return new DSGiayMoiDenCuaSo[size];
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

    public String getLoaiVanban() {
        return loaiVanban;
    }

    public void setLoaiVanban(String loaiVanban) {
        this.loaiVanban = loaiVanban;
    }

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyhieu() {
        return soKyhieu;
    }

    public void setSoKyhieu(String soKyhieu) {
        this.soKyhieu = soKyhieu;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
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

    public String getMota2() {
        return mota2;
    }

    public void setMota2(String mota2) {
        this.mota2 = mota2;
    }

    public String getGiayMoiDiadiem() {
        return giayMoiDiadiem;
    }

    public void setGiayMoiDiadiem(String giayMoiDiadiem) {
        this.giayMoiDiadiem = giayMoiDiadiem;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public String getKetQuaThuchien() {
        return ketQuaThuchien;
    }

    public void setKetQuaThuchien(String ketQuaThuchien) {
        this.ketQuaThuchien = ketQuaThuchien;
    }

    public Integer getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(Integer soTrang) {
        this.soTrang = soTrang;
    }

    public String getChuTri() {
        return chuTri;
    }

    public void setChuTri(String chuTri) {
        this.chuTri = chuTri;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
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
        dest.writeString(loaiVanban);
        dest.writeString(soDen);
        dest.writeString(soKyhieu);
        dest.writeString(mota);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiGio);
        dest.writeString(mota2);
        dest.writeString(giayMoiDiadiem);
        dest.writeString(nguoiNhap);
        dest.writeString(noiDung);
        dest.writeString(noiGui);
        dest.writeString(phongChuTri);
        dest.writeString(ketQuaThuchien);
        if (soTrang == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(soTrang);
        }
        dest.writeString(chuTri);
        dest.writeTypedList(tepDinhKems);
    }
}
