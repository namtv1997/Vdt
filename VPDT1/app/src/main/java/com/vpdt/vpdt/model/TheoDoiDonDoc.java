package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TheoDoiDonDoc implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("han_thong_ke")
    @Expose
    private String hanThongKe;
    @SerializedName("han_giai_quyet")
    @Expose
    private String hanGiaiQuyet;
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
    @SerializedName("pho_giam_doc")
    @Expose
    private String phoGiamDoc;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;
    @SerializedName("chi_dao_giamdoc")
    @Expose
    private String chiDaoGiamdoc;
    @SerializedName("chi_dao_phong")
    @Expose
    private String chiDaoPhong;
    @SerializedName("files")
    @Expose
    private List<FileXemDeBiet> files = null;

    protected TheoDoiDonDoc(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        ngayNhap = in.readString();
        mota = in.readString();
        hanThongKe = in.readString();
        hanGiaiQuyet = in.readString();
        soKyHieu = in.readString();
        soDen = in.readString();
        noiGui = in.readString();
        noiDung = in.readString();
        phoGiamDoc = in.readString();
        phongChuTri = in.readString();
        chiDaoGiamdoc = in.readString();
        chiDaoPhong = in.readString();
        files = in.createTypedArrayList(FileXemDeBiet.CREATOR);
    }

    public static final Creator<TheoDoiDonDoc> CREATOR = new Creator<TheoDoiDonDoc>() {
        @Override
        public TheoDoiDonDoc createFromParcel(Parcel in) {
            return new TheoDoiDonDoc(in);
        }

        @Override
        public TheoDoiDonDoc[] newArray(int size) {
            return new TheoDoiDonDoc[size];
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getHanThongKe() {
        return hanThongKe;
    }

    public void setHanThongKe(String hanThongKe) {
        this.hanThongKe = hanThongKe;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
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

    public String getPhoGiamDoc() {
        return phoGiamDoc;
    }

    public void setPhoGiamDoc(String phoGiamDoc) {
        this.phoGiamDoc = phoGiamDoc;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public String getChiDaoGiamdoc() {
        return chiDaoGiamdoc;
    }

    public void setChiDaoGiamdoc(String chiDaoGiamdoc) {
        this.chiDaoGiamdoc = chiDaoGiamdoc;
    }

    public String getChiDaoPhong() {
        return chiDaoPhong;
    }

    public void setChiDaoPhong(String chiDaoPhong) {
        this.chiDaoPhong = chiDaoPhong;
    }

    public List<FileXemDeBiet> getFiles() {
        return files;
    }

    public void setFiles(List<FileXemDeBiet> files) {
        this.files = files;
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
        dest.writeString(mota);
        dest.writeString(hanThongKe);
        dest.writeString(hanGiaiQuyet);
        dest.writeString(soKyHieu);
        dest.writeString(soDen);
        dest.writeString(noiGui);
        dest.writeString(noiDung);
        dest.writeString(phoGiamDoc);
        dest.writeString(phongChuTri);
        dest.writeString(chiDaoGiamdoc);
        dest.writeString(chiDaoPhong);
        dest.writeTypedList(files);
    }
}
