package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SoLuongVanBanGiaoChiCucPhoChuTri implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngayNhap")
    @Expose
    private String ngayNhap;
    @SerializedName("soDen")
    @Expose
    private String soDen;
    @SerializedName("loaiVanBan")
    @Expose
    private String loaiVanBan;
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
    @SerializedName("ngayKy")
    @Expose
    private String ngayKy;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("deXuatThemHanGiaiQuyet")
    @Expose
    private Boolean deXuatThemHanGiaiQuyet;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;
    @SerializedName("typeTuChoi")
    @Expose
    private Integer typeTuChoi;
    @SerializedName("allowTuChoi")
    @Expose
    private Boolean allowTuChoi;

    protected SoLuongVanBanGiaoChiCucPhoChuTri(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        loaiVanBan = in.readString();
        soKyHieu = in.readString();
        noiGui = in.readString();
        moTa = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        giayMoiDiaDiem = in.readString();
        ngayKy = in.readString();
        urlFile = in.readString();
        byte tmpDeXuatThemHanGiaiQuyet = in.readByte();
        deXuatThemHanGiaiQuyet = tmpDeXuatThemHanGiaiQuyet == 0 ? null : tmpDeXuatThemHanGiaiQuyet == 1;
        trinhTuXuLy = in.createStringArrayList();
        if (in.readByte() == 0) {
            typeTuChoi = null;
        } else {
            typeTuChoi = in.readInt();
        }
        byte tmpAllowTuChoi = in.readByte();
        allowTuChoi = tmpAllowTuChoi == 0 ? null : tmpAllowTuChoi == 1;
    }

    public static final Creator<SoLuongVanBanGiaoChiCucPhoChuTri> CREATOR = new Creator<SoLuongVanBanGiaoChiCucPhoChuTri>() {
        @Override
        public SoLuongVanBanGiaoChiCucPhoChuTri createFromParcel(Parcel in) {
            return new SoLuongVanBanGiaoChiCucPhoChuTri(in);
        }

        @Override
        public SoLuongVanBanGiaoChiCucPhoChuTri[] newArray(int size) {
            return new SoLuongVanBanGiaoChiCucPhoChuTri[size];
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

    public String getLoaiVanBan() {
        return loaiVanBan;
    }

    public void setLoaiVanBan(String loaiVanBan) {
        this.loaiVanBan = loaiVanBan;
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

    public String getNgayKy() {
        return ngayKy;
    }

    public void setNgayKy(String ngayKy) {
        this.ngayKy = ngayKy;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
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

    public Integer getTypeTuChoi() {
        return typeTuChoi;
    }

    public void setTypeTuChoi(Integer typeTuChoi) {
        this.typeTuChoi = typeTuChoi;
    }

    public Boolean getAllowTuChoi() {
        return allowTuChoi;
    }

    public void setAllowTuChoi(Boolean allowTuChoi) {
        this.allowTuChoi = allowTuChoi;
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
        dest.writeString(loaiVanBan);
        dest.writeString(soKyHieu);
        dest.writeString(noiGui);
        dest.writeString(moTa);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(ngayKy);
        dest.writeString(urlFile);
        dest.writeByte((byte) (deXuatThemHanGiaiQuyet == null ? 0 : deXuatThemHanGiaiQuyet ? 1 : 2));
        dest.writeStringList(trinhTuXuLy);
        if (typeTuChoi == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(typeTuChoi);
        }
        dest.writeByte((byte) (allowTuChoi == null ? 0 : allowTuChoi ? 1 : 2));
    }
}
