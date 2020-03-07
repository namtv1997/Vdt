package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VanBanDaDeXuatGiaHanGiaiQuyet implements Parcelable {
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
    @SerializedName("noiGui")
    @Expose
    private String noiGui;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("hanDeXuat")
    @Expose
    private String hanDeXuat;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("lyDoTuChoiHan")
    @Expose
    private String lyDoTuChoiHan;
    @SerializedName("deXuatThemHanGiaiQuyet")
    @Expose
    private Boolean deXuatThemHanGiaiQuyet;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;
    @SerializedName("trangThaiThemHan")
    @Expose
    private Integer trangThaiThemHan;
    @SerializedName("tenLanhDao")
    @Expose
    private String tenLanhDao;

    protected VanBanDaDeXuatGiaHanGiaiQuyet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        noiGui = in.readString();
        moTa = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        hanGiaiQuyet = in.readString();
        hanDeXuat = in.readString();
        urlFile = in.readString();
        lyDoTuChoiHan = in.readString();
        byte tmpDeXuatThemHanGiaiQuyet = in.readByte();
        deXuatThemHanGiaiQuyet = tmpDeXuatThemHanGiaiQuyet == 0 ? null : tmpDeXuatThemHanGiaiQuyet == 1;
        trinhTuXuLy = in.createStringArrayList();
        if (in.readByte() == 0) {
            trangThaiThemHan = null;
        } else {
            trangThaiThemHan = in.readInt();
        }
        tenLanhDao = in.readString();
    }

    public static final Creator<VanBanDaDeXuatGiaHanGiaiQuyet> CREATOR = new Creator<VanBanDaDeXuatGiaHanGiaiQuyet>() {
        @Override
        public VanBanDaDeXuatGiaHanGiaiQuyet createFromParcel(Parcel in) {
            return new VanBanDaDeXuatGiaHanGiaiQuyet(in);
        }

        @Override
        public VanBanDaDeXuatGiaHanGiaiQuyet[] newArray(int size) {
            return new VanBanDaDeXuatGiaHanGiaiQuyet[size];
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

    public String getNoiGui() {
        return noiGui;
    }

    public void setNoiGui(String noiGui) {
        this.noiGui = noiGui;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
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

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getHanDeXuat() {
        return hanDeXuat;
    }

    public void setHanDeXuat(String hanDeXuat) {
        this.hanDeXuat = hanDeXuat;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getLyDoTuChoiHan() {
        return lyDoTuChoiHan;
    }

    public void setLyDoTuChoiHan(String lyDoTuChoiHan) {
        this.lyDoTuChoiHan = lyDoTuChoiHan;
    }

    public Boolean getDeXuatThemHanGiaiQuyet() {
        return deXuatThemHanGiaiQuyet;
    }

    public void setDeXuatThemHanGiaiQuyet(Boolean deXuatThemHanGiaiQuyet) {
        this.deXuatThemHanGiaiQuyet = deXuatThemHanGiaiQuyet;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
    }

    public Integer getTrangThaiThemHan() {
        return trangThaiThemHan;
    }

    public void setTrangThaiThemHan(Integer trangThaiThemHan) {
        this.trangThaiThemHan = trangThaiThemHan;
    }

    public String getTenLanhDao() {
        return tenLanhDao;
    }

    public void setTenLanhDao(String tenLanhDao) {
        this.tenLanhDao = tenLanhDao;
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
        dest.writeString(noiGui);
        dest.writeString(moTa);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(hanDeXuat);
        dest.writeString(urlFile);
        dest.writeString(lyDoTuChoiHan);
        dest.writeByte((byte) (deXuatThemHanGiaiQuyet == null ? 0 : deXuatThemHanGiaiQuyet ? 1 : 2));
        dest.writeStringList(trinhTuXuLy);
        if (trangThaiThemHan == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(trangThaiThemHan);
        }
        dest.writeString(tenLanhDao);
    }
}
