package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanChoDuyetLV3 implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("soKyHieu")
    @Expose
    private String soKyHieu;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("noiDungVanBan")
    @Expose
    private String noiDungVanBan;
    @SerializedName("noiDungChiDao")
    @Expose
    private String noiDungChiDao;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("hanVanBan")
    @Expose
    private String hanVanBan;
    @SerializedName("canBoHoanThanh")
    @Expose
    private String canBoHoanThanh;
    @SerializedName("urlFileKetQua")
    @Expose
    private String urlFileKetQua;
    @SerializedName("thoiGianHoanThanh")
    @Expose
    private String thoiGianHoanThanh;
    @SerializedName("chuyenNhans")
    @Expose
    private List<String> chuyenNhans = null;

    protected VanBanChoDuyetLV3(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        moTa = in.readString();
        noiDungVanBan = in.readString();
        noiDungChiDao = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        noiGui = in.readString();
        urlFile = in.readString();
        hanVanBan = in.readString();
        canBoHoanThanh = in.readString();
        urlFileKetQua = in.readString();
        thoiGianHoanThanh = in.readString();
        chuyenNhans = in.createStringArrayList();
    }

    public static final Creator<VanBanChoDuyetLV3> CREATOR = new Creator<VanBanChoDuyetLV3>() {
        @Override
        public VanBanChoDuyetLV3 createFromParcel(Parcel in) {
            return new VanBanChoDuyetLV3(in);
        }

        @Override
        public VanBanChoDuyetLV3[] newArray(int size) {
            return new VanBanChoDuyetLV3[size];
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

    public String getSoDen() {
        return soDen;
    }

    public void setSoDen(String soDen) {
        this.soDen = soDen;
    }

    public String getSoKyHieu() {
        return soKyHieu;
    }

    public void setSoKyHieu(String soKyHieu) {
        this.soKyHieu = soKyHieu;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getNoiDungVanBan() {
        return noiDungVanBan;
    }

    public void setNoiDungVanBan(String noiDungVanBan) {
        this.noiDungVanBan = noiDungVanBan;
    }

    public String getNoiDungChiDao() {
        return noiDungChiDao;
    }

    public void setNoiDungChiDao(String noiDungChiDao) {
        this.noiDungChiDao = noiDungChiDao;
    }

    public String getGiayMoiGio() {
        return giayMoiGio;
    }

    public void setGiayMoiGio(String giayMoiGio) {
        this.giayMoiGio = giayMoiGio;
    }

    public String getGiayMoiNgay() {
        return giayMoiNgay;
    }

    public void setGiayMoiNgay(String giayMoiNgay) {
        this.giayMoiNgay = giayMoiNgay;
    }

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
    }

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getHanVanBan() {
        return hanVanBan;
    }

    public void setHanVanBan(String hanVanBan) {
        this.hanVanBan = hanVanBan;
    }

    public String getCanBoHoanThanh() {
        return canBoHoanThanh;
    }

    public void setCanBoHoanThanh(String canBoHoanThanh) {
        this.canBoHoanThanh = canBoHoanThanh;
    }

    public String getUrlFileKetQua() {
        return urlFileKetQua;
    }

    public void setUrlFileKetQua(String urlFileKetQua) {
        this.urlFileKetQua = urlFileKetQua;
    }

    public String getThoiGianHoanThanh() {
        return thoiGianHoanThanh;
    }

    public void setThoiGianHoanThanh(String thoiGianHoanThanh) {
        this.thoiGianHoanThanh = thoiGianHoanThanh;
    }

    public List<String> getChuyenNhans() {
        return chuyenNhans;
    }

    public void setChuyenNhans(List<String> chuyenNhans) {
        this.chuyenNhans = chuyenNhans;
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
        dest.writeString(soDen);
        dest.writeString(soKyHieu);
        dest.writeString(moTa);
        dest.writeString(noiDungVanBan);
        dest.writeString(noiDungChiDao);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiGui);
        dest.writeString(urlFile);
        dest.writeString(hanVanBan);
        dest.writeString(canBoHoanThanh);
        dest.writeString(urlFileKetQua);
        dest.writeString(thoiGianHoanThanh);
        dest.writeStringList(chuyenNhans);
    }
}
