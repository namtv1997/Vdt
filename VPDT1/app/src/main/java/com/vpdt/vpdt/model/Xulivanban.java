package com.vpdt.vpdt.model;

public class Xulivanban {
    String stt,skh,sodendo,noigui,ngay,textn,sodenvang,sodenxanh;

    public Xulivanban(String stt, String skh, String sodendo, String noigui, String ngay, String text, String sodenvang, String sodenxanh) {
        this.stt = stt;
        this.skh = skh;
        this.sodendo = sodendo;
        this.noigui = noigui;
        this.ngay = ngay;
        this.textn = text;
        this.sodenvang = sodenvang;
        this.sodenxanh = sodenxanh;
    }

    public Xulivanban(String stt, String skh, String sodendo, String noigui, String ngay, String text) {
        this.stt = stt;
        this.skh = skh;
        this.sodendo = sodendo;
        this.noigui = noigui;
        this.ngay = ngay;
        this.textn = text;
    }

    public String getSodenvang() {
        return sodenvang;
    }

    public void setSodenvang(String sodenvang) {
        this.sodenvang = sodenvang;
    }

    public String getSodenxanh() {
        return sodenxanh;
    }

    public void setSodenxanh(String sodenxanh) {
        this.sodenxanh = sodenxanh;
    }

    public String getStt() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    public String getSkh() {
        return skh;
    }

    public void setSkh(String skh) {
        this.skh = skh;
    }

    public String getSodendo() {
        return sodendo;
    }

    public void setSodendo(String sodendo) {
        this.sodendo = sodendo;
    }

    public String getNoigui() {
        return noigui;
    }

    public void setNoigui(String noigui) {
        this.noigui = noigui;
    }

    public String getNgay() {
        return ngay;
    }

    public void setNgay(String ngay) {
        this.ngay = ngay;
    }

    public String getTextn() {
        return textn;
    }

    public void setTextn(String textn) {
        this.textn = textn;
    }
}
