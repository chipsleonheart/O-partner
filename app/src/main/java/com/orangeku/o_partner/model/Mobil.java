package com.orangeku.o_partner.model;

/**
 * Created by cipta on 11/20/2016.
 */

public class Mobil {
    private String no_stnk,jenis_mobil,merk_mobil,user;
    private int bbm=0, reviewCount=0;

    public Mobil() {
    }

    public Mobil(String no_stnk, String jenis_mobil, String merk_mobil, int bbm) {
        this.no_stnk = no_stnk;
        this.jenis_mobil = jenis_mobil;
        this.merk_mobil = merk_mobil;
        this.bbm = bbm;
    }

    public String getNo_stnk() {
        return no_stnk;
    }

    public void setNo_stnk(String no_stnk) {
        this.no_stnk = no_stnk;
    }

    public String getJenis_mobil() {
        return jenis_mobil;
    }

    public void setJenis_mobil(String jenis_mobil) {
        this.jenis_mobil = jenis_mobil;
    }

    public String getMerk_mobil() {
        return merk_mobil;
    }

    public void setMerk_mobil(String merk_mobil) {
        this.merk_mobil = merk_mobil;
    }

    public int getBbm() {
        return bbm;
    }

    public void setBbm(int bbm) {
        this.bbm = bbm;
    }


}
