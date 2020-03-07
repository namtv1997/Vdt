package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetQuaGiaiQuyetPhongPhoiHop1 {
    @SerializedName("canBo")
    @Expose
    private String canBo;
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;
    @SerializedName("thoiGian")
    @Expose
    private String thoiGian;

    public String getCanBo() {
        return canBo;
    }

    public void setCanBo(String canBo) {
        this.canBo = canBo;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }

    public String getThoiGian() {
        return thoiGian;
    }

    public void setThoiGian(String thoiGian) {
        this.thoiGian = thoiGian;
    }
}
