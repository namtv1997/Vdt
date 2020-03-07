package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Chidao {
    @SerializedName("chuyennhan")
    @Expose
    private String chuyennhan;

    public String getChuyennhan() {
        return chuyennhan;
    }

    public void setChuyennhan(String chuyennhan) {
        this.chuyennhan = chuyennhan;
    }
}
