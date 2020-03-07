package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaoCaoCuocHopChoPheDuyet implements Parcelable {
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
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("fileBaoCao")
    @Expose
    private String fileBaoCao;
    @SerializedName("mieuTa")
    @Expose
    private String mieuTa;
    @SerializedName("noiDungDeXuat")
    @Expose
    private String noiDungDeXuat;
    @SerializedName("IdNoiDungDeXuat")
    @Expose
    private String idNoiDungDeXuat;
    @SerializedName("yKienGiamDoc")
    @Expose
    private String yKienGiamDoc;
    @SerializedName("baoCaoGuiCacPhongs")
    @Expose
    private List<String> baoCaoGuiCacPhongs = null;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;

    protected BaoCaoCuocHopChoPheDuyet(Parcel in) {
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
        noiDung = in.readString();
        fileBaoCao = in.readString();
        mieuTa = in.readString();
        noiDungDeXuat = in.readString();
        idNoiDungDeXuat = in.readString();
        yKienGiamDoc = in.readString();
        baoCaoGuiCacPhongs = in.createStringArrayList();
        trinhTuXuLy = in.createStringArrayList();
    }

    public static final Creator<BaoCaoCuocHopChoPheDuyet> CREATOR = new Creator<BaoCaoCuocHopChoPheDuyet>() {
        @Override
        public BaoCaoCuocHopChoPheDuyet createFromParcel(Parcel in) {
            return new BaoCaoCuocHopChoPheDuyet(in);
        }

        @Override
        public BaoCaoCuocHopChoPheDuyet[] newArray(int size) {
            return new BaoCaoCuocHopChoPheDuyet[size];
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

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getFileBaoCao() {
        return fileBaoCao;
    }

    public void setFileBaoCao(String fileBaoCao) {
        this.fileBaoCao = fileBaoCao;
    }

    public String getMieuTa() {
        return mieuTa;
    }

    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }

    public String getNoiDungDeXuat() {
        return noiDungDeXuat;
    }

    public void setNoiDungDeXuat(String noiDungDeXuat) {
        this.noiDungDeXuat = noiDungDeXuat;
    }

    public String getIdNoiDungDeXuat() {
        return idNoiDungDeXuat;
    }

    public void setIdNoiDungDeXuat(String idNoiDungDeXuat) {
        this.idNoiDungDeXuat = idNoiDungDeXuat;
    }

    public String getYKienGiamDoc() {
        return yKienGiamDoc;
    }

    public void setYKienGiamDoc(String yKienGiamDoc) {
        this.yKienGiamDoc = yKienGiamDoc;
    }

    public List<String> getBaoCaoGuiCacPhongs() {
        return baoCaoGuiCacPhongs;
    }

    public void setBaoCaoGuiCacPhongs(List<String> baoCaoGuiCacPhongs) {
        this.baoCaoGuiCacPhongs = baoCaoGuiCacPhongs;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
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
        dest.writeString(noiDung);
        dest.writeString(fileBaoCao);
        dest.writeString(mieuTa);
        dest.writeString(noiDungDeXuat);
        dest.writeString(idNoiDungDeXuat);
        dest.writeString(yKienGiamDoc);
        dest.writeStringList(baoCaoGuiCacPhongs);
        dest.writeStringList(trinhTuXuLy);
    }
}
