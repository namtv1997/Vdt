package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GMDaHoanThanhChoLanhDaoPhongPheDuyet implements Parcelable {
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
    @SerializedName("giayMoiDiaDiem")
    @Expose
    private String giayMoiDiaDiem;
    @SerializedName("giayMoiGio")
    @Expose
    private String giayMoiGio;
    @SerializedName("giayMoiNgay")
    @Expose
    private String giayMoiNgay;
    @SerializedName("moTa")
    @Expose
    private String moTa;
    @SerializedName("hanGiaiQuyet")
    @Expose
    private String hanGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("idNguoiHoanThanh")
    @Expose
    private String idNguoiHoanThanh;
    @SerializedName("tenNguoiHoanThanh")
    @Expose
    private String tenNguoiHoanThanh;
    @SerializedName("moTaHoanThanh")
    @Expose
    private String moTaHoanThanh;
    @SerializedName("fileBaoCaos")
    @Expose
    private List<FileBaoCao> fileBaoCaos = null;
    @SerializedName("trinhTuXuLy")
    @Expose
    private List<String> trinhTuXuLy = null;
    @SerializedName("trangthai")
    @Expose
    private String trangthai;

    protected GMDaHoanThanhChoLanhDaoPhongPheDuyet(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        soDen = in.readString();
        soKyHieu = in.readString();
        noiGui = in.readString();
        giayMoiDiaDiem = in.readString();
        giayMoiGio = in.readString();
        giayMoiNgay = in.readString();
        moTa = in.readString();
        hanGiaiQuyet = in.readString();
        urlFile = in.readString();
        idNguoiHoanThanh = in.readString();
        tenNguoiHoanThanh = in.readString();
        moTaHoanThanh = in.readString();
        fileBaoCaos = in.createTypedArrayList(FileBaoCao.CREATOR);
        trinhTuXuLy = in.createStringArrayList();
        trangthai = in.readString();
    }

    public static final Creator<GMDaHoanThanhChoLanhDaoPhongPheDuyet> CREATOR = new Creator<GMDaHoanThanhChoLanhDaoPhongPheDuyet>() {
        @Override
        public GMDaHoanThanhChoLanhDaoPhongPheDuyet createFromParcel(Parcel in) {
            return new GMDaHoanThanhChoLanhDaoPhongPheDuyet(in);
        }

        @Override
        public GMDaHoanThanhChoLanhDaoPhongPheDuyet[] newArray(int size) {
            return new GMDaHoanThanhChoLanhDaoPhongPheDuyet[size];
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

    public String getGiayMoiDiaDiem() {
        return giayMoiDiaDiem;
    }

    public void setGiayMoiDiaDiem(String giayMoiDiaDiem) {
        this.giayMoiDiaDiem = giayMoiDiaDiem;
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

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getIdNguoiHoanThanh() {
        return idNguoiHoanThanh;
    }

    public void setIdNguoiHoanThanh(String idNguoiHoanThanh) {
        this.idNguoiHoanThanh = idNguoiHoanThanh;
    }

    public String getTenNguoiHoanThanh() {
        return tenNguoiHoanThanh;
    }

    public void setTenNguoiHoanThanh(String tenNguoiHoanThanh) {
        this.tenNguoiHoanThanh = tenNguoiHoanThanh;
    }

    public String getMoTaHoanThanh() {
        return moTaHoanThanh;
    }

    public void setMoTaHoanThanh(String moTaHoanThanh) {
        this.moTaHoanThanh = moTaHoanThanh;
    }

    public List<FileBaoCao> getFileBaoCaos() {
        return fileBaoCaos;
    }

    public void setFileBaoCaos(List<FileBaoCao> fileBaoCaos) {
        this.fileBaoCaos = fileBaoCaos;
    }

    public List<String> getTrinhTuXuLy() {
        return trinhTuXuLy;
    }

    public void setTrinhTuXuLy(List<String> trinhTuXuLy) {
        this.trinhTuXuLy = trinhTuXuLy;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
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
        dest.writeString(giayMoiDiaDiem);
        dest.writeString(giayMoiGio);
        dest.writeString(giayMoiNgay);
        dest.writeString(moTa);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(urlFile);
        dest.writeString(idNguoiHoanThanh);
        dest.writeString(tenNguoiHoanThanh);
        dest.writeString(moTaHoanThanh);
        dest.writeTypedList(fileBaoCaos);
        dest.writeStringList(trinhTuXuLy);
        dest.writeString(trangthai);
    }
}
