package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VanBanChoChiDaoLV2 implements Parcelable {
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
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
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
    @SerializedName("noidung")
    @Expose
    private String noidung;
    @SerializedName("canBoChidao")
    @Expose
    private String canBoChidao;
    @SerializedName("tenPhongChuTri")
    @Expose
    private String tenPhongChuTri;
    @SerializedName("idPhongChuTri")
    @Expose
    private Integer idPhongChuTri;
    @SerializedName("idPhongPhoiHops")
    @Expose
    private String idPhongPhoiHops;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;

    protected VanBanChoChiDaoLV2(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        moTa = in.readString();
        noiDung = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        noiGui = in.readString();
        urlFile = in.readString();
        noidung = in.readString();
        canBoChidao = in.readString();
        tenPhongChuTri = in.readString();
        if (in.readByte() == 0) {
            idPhongChuTri = null;
        } else {
            idPhongChuTri = in.readInt();
        }
        idPhongPhoiHops = in.readString();
        hanGiaiQuyet = in.readString();
    }

    public static final Creator<VanBanChoChiDaoLV2> CREATOR = new Creator<VanBanChoChiDaoLV2>() {
        @Override
        public VanBanChoChiDaoLV2 createFromParcel(Parcel in) {
            return new VanBanChoChiDaoLV2(in);
        }

        @Override
        public VanBanChoChiDaoLV2[] newArray(int size) {
            return new VanBanChoChiDaoLV2[size];
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
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

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public String getCanBoChidao() {
        return canBoChidao;
    }

    public void setCanBoChidao(String canBoChidao) {
        this.canBoChidao = canBoChidao;
    }

    public String getTenPhongChuTri() {
        return tenPhongChuTri;
    }

    public void setTenPhongChuTri(String tenPhongChuTri) {
        this.tenPhongChuTri = tenPhongChuTri;
    }

    public Integer getIdPhongChuTri() {
        return idPhongChuTri;
    }

    public void setIdPhongChuTri(Integer idPhongChuTri) {
        this.idPhongChuTri = idPhongChuTri;
    }

    public String getIdPhongPhoiHops() {
        return idPhongPhoiHops;
    }

    public void setIdPhongPhoiHops(String idPhongPhoiHops) {
        this.idPhongPhoiHops = idPhongPhoiHops;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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
        dest.writeString(noiDung);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(noiGui);
        dest.writeString(urlFile);
        dest.writeString(noidung);
        dest.writeString(canBoChidao);
        dest.writeString(tenPhongChuTri);
        if (idPhongChuTri == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idPhongChuTri);
        }
        dest.writeString(idPhongPhoiHops);
        dest.writeString(hanGiaiQuyet);
    }
}
