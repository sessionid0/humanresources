package com.PersonelModulu;

import com.IzinModulu.Islemler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class PersonelIslemler {
    com.IzinModulu.Islemler islemler = new Islemler();
    com.PersonelModulu.Personel personelclass = new Personel();


    public void display(ArrayList<Personel> arr) {



       /* for (int i= 0; i<personelclass.personels.size(); i++){
            if (personelclass.personels.get(i).getSirketAdi().equals("AVD TEKNOLOJİ VE DANIŞMANLIK A.Ş.")) {
                System.out.println("*************************************************");
                for (int a = 0; a < arr.size(); a++) {
                    System.out.print(arr.get(a) + " \n");

                }

                System.out.println();
            }
            else if (personelclass.personels.get(i).getSirketAdi().equals("GEST ÖLÇÜM VE OTOMASYON A.Ş.")){
                System.out.println("*************************************************");
                for (int b = 0; b < arr.size(); b++) {
                    System.out.print(arr.get(i) + " \n");

                }

                System.out.println();
            }*/
        System.out.println("*************************************************");
        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i) + " \n");

        }

        System.out.println();

    }



    public void personeliGuncelle(Scanner h) throws ParseException {
        com.IzinModulu.Islemler islemler = new Islemler();
        com.PersonelModulu.Personel personelclass = new Personel();
        System.out.println("Güncellemek istediğiniz personelin kimlik numarasını girin: ");
        String kimliknogirilen = h.nextLine();
        // String gecici2 = h.nextLine();

        int index = -1;

        for (int i= 0; i<personelclass.personels.size(); i++){
            if (personelclass.personels.get(i).getKimlik().equals(kimliknogirilen)) {
                index = i;
                break;
            }
        }
        if (index != -1) {

            personelclass.personels.get(index);
            String gk = personelclass.personels.get(index).getKimlik();
            String gad= personelclass.personels.get(index).getAd_soyad();
            String gbol = personelclass.personels.get(index).getBolum();
            String gis= personelclass.personels.get(index).getIseBaslama();
            System.out.println("****************************");
            System.out.println();
            System.out.println("Güncellemek istediğiniz personel bilgisi aşağıdaki gibidir:");
            System.out.println();
            System.out.println("TC Kimlik No: "+gk+"   Adı ve Soyadı: "+gad+"   Bölüm: "+gbol+"   İşe başlama tarihi: "+gis);
            System.out.println("***********************************");
            System.out.println("Lütfen bir seçim yapın:");
            System.out.println();
            System.out.println("1- Ad ve Soyadı güncelleme");
            System.out.println("2- Bölüm Güncelleme");
            System.out.println("0- GERİ");
            int baskadeger = Integer.parseInt(h.nextLine());
            if (baskadeger==1){
                System.out.println("Lütfen yeni ad ve soyadı girin: ");
                String gecici3 = h.nextLine();
                personelclass.personels.get(index).setAd_soyad(gecici3);
                System.out.println("Güncelleme tamamlandı.");
                personeliGuncelle(h);

            } else if (baskadeger==2) {
                System.out.println("Lütfen yeni bölüm adını girin: ");
                String gecici2 = h.nextLine();
                personelclass.personels.get(index).setBolum(gecici2);
                System.out.println("Güncelleme tamamlandı.");
                personeliGuncelle(h);
            } else if (baskadeger==0) {
                PersonelOlustur();
            }
            else{
                System.out.println("Yanlış seçim yapıldı. Varsayılan olarak ana menüye dönülüyor...");
                islemler.anaMenu();
            }

        }
        else{
            System.out.println("Belirtilen kimlik numarasına ait personel bulunamadı.");
            System.out.println("Varsayılan olarak ana menüye dönülüyor...");
            islemler.anaMenu();

        }
    }
    public static void personeliSil(Scanner h){
        com.IzinModulu.Islemler islemler = new Islemler();
        com.PersonelModulu.Personel personelclass = new Personel();
        System.out.println("Silmek istediğiniz personelin kimlik numarasını girin: ");
        String kimliknogirilen = h.nextLine();
       // String gecici2 = h.nextLine();

        int index = -1;

        for (int i= 0; i<personelclass.personels.size(); i++){
            if (personelclass.personels.get(i).getKimlik().equals(kimliknogirilen)) {
                index = i;
                break;
            }
        }
        if (index != -1) {

            personelclass.personels.remove(index);
            System.out.println("Personel başarıyla silindi. Ana menüye dönülüyor..");
            islemler.anaMenu();
        }
        else{
            System.out.println("Belirtilen kimlik numarasına ait personel bulunamadı.");
            System.exit(0);

        }
    }


//
    //display(personelclass.personels);

    // System.out.println();
    // System.out.println();


 /*
        System.out.print("****Bölümden sorgulama yapma***");
        String bolumadi = scanner.nextLine();

        for (String person: personel.personels) {
            if (personel.getBolum() == bolumadi) {
                System.out.println(person);
            }
        }

        */

    public void PersonelOlustur() throws ParseException {

        Scanner scanner = new Scanner(System.in);

        String getID;
        String getAd;
        String getBolum;
        String getIseBaslama;
        String setSirket="";


        System.out.println("1 - PERSONEL LİSTESİ");
        System.out.println("2 - PERSONEL EKLEME");
        System.out.println("3 - PERSONEL SİLME");
        System.out.println("4 - PERSONEL GÜNCELLEME");
        System.out.println("0 - Ana menü");
        int deger = Integer.parseInt(scanner.nextLine());
       // String gecici = scanner.nextLine();
      // String gecici2 = scanner.nextLine();
        while (deger == 1 || deger == 2 || deger == 0|| deger == 3|| deger == 4) {
            if (deger == 1) {
                display(personelclass.personels);
                System.out.println();
                System.out.println("0-GERİ");
                int deger03 = Integer.parseInt(scanner.nextLine());
                if (deger03==0){
                    PersonelOlustur();
                }
                break;
            } else if (deger == 2) {
                int i=0;
                System.out.println("Lütfen yeni personelin kimlik numarasını girin:");
                getID = scanner.nextLine();
                System.out.println("Lütfen adı ve soyadını girin:");
                getAd = scanner.nextLine();
                System.out.println("Personelin bölümü nedir?");
                getBolum = scanner.nextLine();
                System.out.println("Personelin bulunduğu şirket hangisi?");
                System.out.println("");
                System.out.println("1 - AVD TEKNOLOJİ VE DANIŞMANLIK A.Ş.");
                System.out.println("2 - GEST ÖLÇÜM VE OTOMASYON A.Ş.");
                System.out.println("0 - GERİ");
                int degeralsirket = Integer.parseInt(scanner.nextLine());
                if (degeralsirket==1){
                    com.PersonelModulu.Personel pi = new Personel();
                    setSirket="AVD TEKNOLOJİ VE DANIŞMANLIK A.Ş.";
                }
                else if (degeralsirket==2){
                    com.PersonelModulu.Personel pi = new Personel();
                   setSirket= "GEST ÖLÇÜM VE OTOMASYON A.Ş.";
                } else if (degeralsirket==0) {
                    PersonelOlustur();
                }
                else {
                    System.out.println("Hatalı tuşlama yaptınız. Çıkış yapılıyor...");
                    System.exit(0);
                }
                System.out.println("Personelin işe başlama tarihi nedir? (gg/aa/yyyy olmalıdır.)");
                getIseBaslama = scanner.nextLine();
                com.PersonelModulu.Personel pi = new Personel();
                pi.setKimlik(getID);
                pi.setAd_soyad(getAd);
                pi.setBolum(getBolum);
                pi.setIseBaslama(getIseBaslama);
                pi.setSirketadi(setSirket);
                personelclass.personels.add(pi);
                pi.setCalisilanGun(islemler.tarihHesapla(getIseBaslama));
                pi.setYilIzGun(islemler.YillikIzinGunSayisi(pi.getCalisilanGun()));
                pi.setHastaIzinGun(30);
                System.out.println("Personel başarıyla oluşturuldu. Ana menüye yönlendiriliyorsunuz...");
                islemler.anaMenu();

            } else if (deger==3) {

                personeliSil(scanner);


            }
            else if (deger==4) {

                personeliGuncelle(scanner);


            }
            else if (deger == 0) {
                islemler.anaMenu();
                break;
            } else {
                System.out.println("Hatalı tuşlama yaptınız. Lütfen tekrar deneyin.");
                deger = scanner.nextInt();
            }
            break;
        }
    }
}