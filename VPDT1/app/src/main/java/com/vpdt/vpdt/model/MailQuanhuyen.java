package com.vpdt.vpdt.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MailQuanhuyen {
    @SerializedName("ten_donvi")
    @Expose
    private String tenDonvi;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("chon_mail")
    @Expose
    private Integer chonMail;

    public String getTenDonvi() {
        return tenDonvi;
    }

    public void setTenDonvi(String tenDonvi) {
        this.tenDonvi = tenDonvi;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getChonMail() {
        return chonMail;
    }

    public void setChonMail(Integer chonMail) {
        this.chonMail = chonMail;
    }
}
