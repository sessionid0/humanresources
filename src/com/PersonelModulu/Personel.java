package com.PersonelModulu;

import java.util.ArrayList;

public class Personel {

    private String kimlik;
    private String ad_soyad;
    private String bolum;
    private String iseBaslama;
    private String izinBaslama;
    private String izinBitis;
    private String izinTuru;
    private String sirketadi;

    private int yilIzGun;
    private int hastaIzinGun;
    private int ebeveynIzinGun;
    private int calisilanGun;

    /*
    Kimlik ad_soyad bolüm işebaşlama izinbaslama izinbitis yilizngun hastaizngun ebeveynlikizingun calisilangun
     */
    public Personel() {
    }

    ;

    public String getKimlik() {
        return kimlik;
    }

    ;

    public void setKimlik(String kimlik) {
        this.kimlik = kimlik;
    }

    ;

    public String getAd_soyad() {
        return ad_soyad;
    }

    ;

    public void setAd_soyad(String ad_soyad) {
        this.ad_soyad = ad_soyad;
    }

    ;

    public String getBolum() {
        return bolum;
    }

    ;

    public void setBolum(String bolum) {
        this.bolum = bolum;
    }

    ;

    public String getIseBaslama() {
        return iseBaslama;
    }

    ;

    public void setIseBaslama(String iseBaslama) {
        this.iseBaslama = iseBaslama;
    }

    ;

    public String getIzinBaslama() {
        return izinBaslama;
    }

    ;

    public void setIzinBaslama(String izinBaslama) {
        this.izinBaslama = izinBaslama;
    }

    ;

    public String getIzinTuru() {
        return izinTuru;
    }

    ;

    public void setIzinTuru(String izinTuru) {
        this.izinTuru = izinTuru;
    }

    ;

    public String getIzinBitis() {
        return izinBitis;
    }

    ;

    public void setIzinBitis(String izinBitis) {
        this.izinBitis = izinBitis;
    }

    ;

    public int getYilIzGun() {
        return yilIzGun;
    }

    ;
    public String getSirketAdi(){return sirketadi;};
    public void setSirketadi(String sirketadi){this.sirketadi=sirketadi;}
    public void setYilIzGun(int yilIzGun) {
        this.yilIzGun = yilIzGun;
    }

    ;

    public int getHastaIzinGun() {
        return hastaIzinGun;
    }

    ;

    public void setHastaIzinGun(int hastaIzinGun) {
        this.hastaIzinGun = hastaIzinGun;
    }

    ;

    public int getEbeveynIzinGun() {
        return ebeveynIzinGun;
    }

    ;

    public void setEbeveynIzinGun(int ebeveynIzinGun) {
        this.ebeveynIzinGun = ebeveynIzinGun;
    }

    ;

    public int getCalisilanGun() {
        return calisilanGun;
    }

    ;

    public void setCalisilanGun(int calisilanGun) {
        this.calisilanGun = calisilanGun;
    }

    ;

    @Override
    public String toString() {
        return "-> {" +
                "TC ='" + kimlik + '\'' +
                ", Adı Soyadı ='" + ad_soyad + '\'' +
                ", Bölümü ='" + bolum + '\'' +
                ", İşe başlama Tarihi ='" + iseBaslama + '\'' +
                //  ", İzin Başlama Tarihi ='" + izinBaslama + '\'' +
                // ", İzin Bitiş Tarihi ='" + izinBitis + '\'' +
                ", Yıllık İzin Gün Sayısı =" + yilIzGun +
                ", Hastalık İzni Gün Sayısı =" + hastaIzinGun +
                //  ", Ebeveynlik İzni Gün Sayısı =" + ebeveynIzinGun +
                ", Çalışılan Gün Sayısı =" + calisilanGun +
                '}';
    }

    public static ArrayList<Personel> personels = new ArrayList<Personel>();


    //SEARCH


}






