package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class GiaHanGiaiQuyet implements Parcelable {
    @SerializedName("id_van_ban")
    @Expose
    private Integer idVanBan;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("so_den")
    @Expose
    private String soDen;
    @SerializedName("ky_hieu")
    @Expose
    private String kyHieu;
    @SerializedName("mo_ta")
    @Expose
    private String moTa;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("noi_dung")
    @Expose
    private String noiDung;
    @SerializedName("tep_dinh_kems")
    @Expose
    private List<TepDinhKem> tepDinhKems = null;
    @SerializedName("noi_gui")
    @Expose
    private String noiGui;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;
    @SerializedName("han_cho_duyet")
    @Expose
    private String hanChoDuyet;
    @SerializedName("ly_do_de_xuat")
    @Expose
    private String lyDoDeXuat;
    @SerializedName("chi_dao")
    @Expose
    private String chiDao;



    protected GiaHanGiaiQuyet(Parcel in) {
        if (in.readByte() == 0) {
            idVanBan = null;
        } else {
            idVanBan = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        kyHieu = in.readString();
        moTa = in.readString();
        nguoiNhap = in.readString();
        noiDung = in.readString();
        noiGui = in.readString();
        phongChuTri = in.readString();
        hanChoDuyet = in.readString();
        lyDoDeXuat = in.readString();
        chiDao = in.readString();
        if (tepDinhKems==null){
            tepDinhKems=new ArrayList<>();
        }
        in.readTypedList(tepDinhKems,TepDinhKem.CREATOR);
    }

    public static final Creator<GiaHanGiaiQuyet> CREATOR = new Creator<GiaHanGiaiQuyet>() {
        @Override
        public GiaHanGiaiQuyet createFromParcel(Parcel in) {
            return new GiaHanGiaiQuyet(in);
        }

        @Override
        public GiaHanGiaiQuyet[] newArray(int size) {
            return new GiaHanGiaiQuyet[size];
        }
    };

    public Integer getIdVanBan() {
        return idVanBan;
    }

    public void setIdVanBan(Integer idVanBan) {
        this.idVanBan = idVanBan;
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

    public String getKyHieu() {
        return kyHieu;
    }

    public void setKyHieu(String kyHieu) {
        this.kyHieu = kyHieu;
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public List<TepDinhKem> getTepDinhKems() {
        return tepDinhKems;
    }

    public void setTepDinhKems(List<TepDinhKem> tepDinhKems) {
        this.tepDinhKems = tepDinhKems;
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

    public String getHanChoDuyet() {
        return hanChoDuyet;
    }

    public void setHanChoDuyet(String hanChoDuyet) {
        this.hanChoDuyet = hanChoDuyet;
    }

    public String getLyDoDeXuat() {
        return lyDoDeXuat;
    }

    public void setLyDoDeXuat(String lyDoDeXuat) {
        this.lyDoDeXuat = lyDoDeXuat;
    }

    public String getChiDao() {
        return chiDao;
    }

    public void setChiDao(String chiDao) {
        this.chiDao = chiDao;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (idVanBan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(idVanBan);
        }
        dest.writeString(ngayNhap);
        dest.writeString(soDen);
        dest.writeString(kyHieu);
        dest.writeString(moTa);
        dest.writeString(nguoiNhap);
        dest.writeString(noiDung);
        dest.writeString(noiGui);
        dest.writeString(phongChuTri);
        dest.writeString(hanChoDuyet);
        dest.writeString(lyDoDeXuat);
        dest.writeString(chiDao);
        dest.writeTypedList(tepDinhKems);
    }
}
