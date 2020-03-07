package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class YKien {
    @SerializedName("id_giam_doc")
    @Expose
    private Integer idGiamDoc;
    @SerializedName("pho_giam_doc")
    @Expose
    private String phoGiamDoc;
    @SerializedName("id_chu_tri")
    @Expose
    private Integer idChuTri;
    @SerializedName("phong_chu_tri")
    @Expose
    private String phongChuTri;
    @SerializedName("han_giai_quyet")
    @Expose
    private String hanGiaiQuyet;

    public Integer getIdGiamDoc() {
        return idGiamDoc;
    }

    public void setIdGiamDoc(Integer idGiamDoc) {
        this.idGiamDoc = idGiamDoc;
    }

    public String getPhoGiamDoc() {
        return phoGiamDoc;
    }

    public void setPhoGiamDoc(String phoGiamDoc) {
        this.phoGiamDoc = phoGiamDoc;
    }

    public Integer getIdChuTri() {
        return idChuTri;
    }

    public void setIdChuTri(Integer idChuTri) {
        this.idChuTri = idChuTri;
    }

    public String getPhongChuTri() {
        return phongChuTri;
    }

    public void setPhongChuTri(String phongChuTri) {
        this.phongChuTri = phongChuTri;
    }

    public String getHanGiaiQuyet() {
        return hanGiaiQuyet;
    }

    public void setHanGiaiQuyet(String hanGiaiQuyet) {
        this.hanGiaiQuyet = hanGiaiQuyet;
    }
}
