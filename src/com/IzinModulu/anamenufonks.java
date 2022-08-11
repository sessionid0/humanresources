package com.IzinModulu;

import com.PersonelModulu.Personel;

import java.text.ParseException;

public class anamenufonks {

    public void AnaMenuFonk() throws ParseException {
        com.PersonelModulu.Personel p1 = new Personel();
        com.IzinModulu.Islemler islemler = new Islemler();
        com.PersonelModulu.Personel personelclass = new Personel();
        p1.setKimlik("27271234567");
        p1.setAd_soyad("Süleyman Nur Ceylan");
        p1.setBolum("Stajyer");
        p1.setIseBaslama("18/07/2022");
        p1.setCalisilanGun(islemler.tarihHesapla("18/07/2022"));
        p1.setYilIzGun(islemler.YillikIzinGunSayisi(p1.getCalisilanGun()));
        p1.setHastaIzinGun(30);
        p1.setSirketadi("AVD TEKNOLOJİ VE DANIŞMANLIK A.Ş.");
        personelclass.personels.add(p1);

        com.PersonelModulu.Personel p2 = new Personel();
        p2.setKimlik("10691234567");
        p2.setAd_soyad("Deniz Ceylan");
        p2.setBolum("Makine Mühendisi");
        p2.setIseBaslama("12/02/2021");
        p2.setCalisilanGun(islemler.tarihHesapla("12/02/2021"));
        p2.setYilIzGun(islemler.YillikIzinGunSayisi(p2.getCalisilanGun()));
        p2.setHastaIzinGun(30);
        p2.setSirketadi("GEST ÖLÇÜM VE OTOMASYON A.Ş.");
        personelclass.personels.add(p2);
        islemler.anaMenu();
    }
}
