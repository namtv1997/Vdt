package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LdPhong {
    @SerializedName("id_ldp")
    @Expose
    private Integer idLdp;
    @SerializedName("ten_ldp")
    @Expose
    private String tenLdp;
    @SerializedName("chon_lanhdaophog")
    @Expose
    private Integer chonLanhdaophog;

    public Integer getIdLdp() {
        return idLdp;
    }

    public void setIdLdp(Integer idLdp) {
        this.idLdp = idLdp;
    }

    public String getTenLdp() {
        return tenLdp;
    }

    public void setTenLdp(String tenLdp) {
        this.tenLdp = tenLdp;
    }

    public Integer getChonLanhdaophog() {
        return chonLanhdaophog;
    }

    public void setChonLanhdaophog(Integer chonLanhdaophog) {
        this.chonLanhdaophog = chonLanhdaophog;
    }
}
