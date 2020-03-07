package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class KetQuaGiaiQuyet1 {
    @SerializedName("noiDung")
    @Expose
    private String noiDung;
    @SerializedName("canBoGiaiQuyet")
    @Expose
    private String canBoGiaiQuyet;
    @SerializedName("thoiGianGiaiQuyet")
    @Expose
    private String thoiGianGiaiQuyet;
    @SerializedName("urlFile")
    @Expose
    private String urlFile;

    public String getNoiDung() {
        return noiDung;
    }

    public void setNoiDung(String noiDung) {
        this.noiDung = noiDung;
    }

    public String getCanBoGiaiQuyet() {
        return canBoGiaiQuyet;
    }

    public void setCanBoGiaiQuyet(String canBoGiaiQuyet) {
        this.canBoGiaiQuyet = canBoGiaiQuyet;
    }

    public String getThoiGianGiaiQuyet() {
        return thoiGianGiaiQuyet;
    }

    public void setThoiGianGiaiQuyet(String thoiGianGiaiQuyet) {
        this.thoiGianGiaiQuyet = thoiGianGiaiQuyet;
    }

    public String getUrlFile() {
        return urlFile;
    }

    public void setUrlFile(String urlFile) {
        this.urlFile = urlFile;
    }
}
