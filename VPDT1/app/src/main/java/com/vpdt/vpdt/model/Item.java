package com.vpdt.vpdt.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Item implements Parcelable {
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("mota")
    @Expose
    private String mota;
    @SerializedName("nguoi_nhap")
    @Expose
    private String nguoiNhap;
    @SerializedName("ngay_nhap")
    @Expose
    private String ngayNhap;
    @SerializedName("han_vanban")
    @Expose
    private String hanVanban;
    @SerializedName("pho_giam_doc_id")
    @Expose
    private Integer phoGiamDocId;
    @SerializedName("pho_giam_doc")
    @Expose
    private String phoGiamDoc;
    @SerializedName("phong_chu_tri_id")
    @Expose
    private Integer phongChuTriId;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;
    @SerializedName("phong_phohops")
    @Expose
    private List<String> phongPhohops = null;
    @SerializedName("han_xuly")
    @Expose
    private String hanXuly;
    @SerializedName("noi_dung_chuyen_pgd")
    @Expose
    private String noiDungChuyenPgd;
    @SerializedName("noi_dung_phong_ph")
    @Expose
    private String noiDungPhongPh;
    @SerializedName("noi_dung_chuyen_pct")
    @Expose
    private String noiDungChuyenPct;

    protected Item(Parcel in) {
        if (in.readByte() == 0) {
            id = null;
        } else {
            id = in.readInt();
        }
        mota = in.readString();
        nguoiNhap = in.readString();
        ngayNhap = in.readString();
        hanVanban = in.readString();
        if (in.readByte() == 0) {
            phoGiamDocId = null;
        } else {
            phoGiamDocId = in.readInt();
        }
        phoGiamDoc = in.readString();
        if (in.readByte() == 0) {
            phongChuTriId = null;
        } else {
            phongChuTriId = in.readInt();
        }
        phongChuTri = in.readString();
        phongPhohops = in.createStringArrayList();
        hanXuly = in.readString();
        noiDungChuyenPgd = in.readString();
        noiDungPhongPh = in.readString();
        noiDungChuyenPct = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getNguoiNhap() {
        return nguoiNhap;
    }

    public void setNguoiNhap(String nguoiNhap) {
        this.nguoiNhap = nguoiNhap;
    }

    public String getNgayNhap() {
        return ngayNhap;
    }

    public void setNgayNhap(String ngayNhap) {
        this.ngayNhap = ngayNhap;
    }

    public String getHanVanban() {
        return hanVanban;
    }

    public void setHanVanban(String hanVanban) {
        this.hanVanban = hanVanban;
    }

    public Integer getPhoGiamDocId() {
        return phoGiamDocId;
    }

    public void setPhoGiamDocId(Integer phoGiamDocId) {
        this.phoGiamDocId = phoGiamDocId;
    }

    public String getPhoGiamDoc() {
        return phoGiamDoc;
    }

    public void setPhoGiamDoc(String phoGiamDoc) {
        this.phoGiamDoc = phoGiamDoc;
    }

    public Integer getPhongChuTriId() {
        return phongChuTriId;
    }

    public void setPhongChuTriId(Integer phongChuTriId) {
        this.phongChuTriId = phongChuTriId;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public List<String> getPhongPhohops() {
        return phongPhohops;
    }

    public void setPhongPhohops(List<String> phongPhohops) {
        this.phongPhohops = phongPhohops;
    }

    public String getHanXuly() {
        return hanXuly;
    }

    public void setHanXuly(String hanXuly) {
        this.hanXuly = hanXuly;
    }

    public String getNoiDungChuyenPgd() {
        return noiDungChuyenPgd;
    }

    public void setNoiDungChuyenPgd(String noiDungChuyenPgd) {
        this.noiDungChuyenPgd = noiDungChuyenPgd;
    }

    public String getNoiDungPhongPh() {
        return noiDungPhongPh;
    }

    public void setNoiDungPhongPh(String noiDungPhongPh) {
        this.noiDungPhongPh = noiDungPhongPh;
    }

    public String getNoiDungChuyenPct() {
        return noiDungChuyenPct;
    }

    public void setNoiDungChuyenPct(String noiDungChuyenPct) {
        this.noiDungChuyenPct = noiDungChuyenPct;
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
        dest.writeString(mota);
        dest.writeString(nguoiNhap);
        dest.writeString(ngayNhap);
        dest.writeString(hanVanban);
        if (phoGiamDocId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(phoGiamDocId);
        }
        dest.writeString(phoGiamDoc);
        if (phongChuTriId == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(phongChuTriId);
        }
        dest.writeString(phongChuTri);
        dest.writeStringList(phongPhohops);
        dest.writeString(hanXuly);
        dest.writeString(noiDungChuyenPgd);
        dest.writeString(noiDungPhongPh);
        dest.writeString(noiDungChuyenPct);
    }
}
