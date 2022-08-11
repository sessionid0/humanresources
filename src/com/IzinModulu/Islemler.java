package com.IzinModulu;

import com.PersonelModulu.Personel;
import com.PersonelModulu.PersonelIslemler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.*;
import java.util.concurrent.TimeUnit;


public class Islemler {
    com.PersonelModulu.Personel personelclass = new Personel();
    SimpleDateFormat bicim=new SimpleDateFormat("dd/M/yyyy");
    Date tarih=new Date();
    String bugununtarihis=bicim.format(tarih);
    public void anaMenu(){

        System.out.println("***********************************");
        System.out.println("      İNSAN KAYNAKLARI MODÜLÜ ");
        System.out.println("***********************************");

        System.out.println("1- Personel İzin Alımı");
        System.out.println("2- Personel Bilgileri Güncelleme");
        System.out.println("0- Çıkış");
        Scanner scanner=new Scanner(System.in);
       // int alinandeger = scanner.nextInt();


        try {
            int alinandeger = Integer.parseInt(scanner.nextLine());
            if (alinandeger == 1) {
                PersonelIzinAlimi();
            } else if (alinandeger == 2) {
                System.out.println("********************************************");
                com.PersonelModulu.PersonelIslemler personelIslemler = new PersonelIslemler();
                personelIslemler.PersonelOlustur();
            } else if (alinandeger == 0) {
                System.out.println("Çıkış yapılıyor...");
                System.exit(0);

            } else {
                System.out.println("Yanlış giriş yaptınız. Lütfen tekrar deneyin.");
                System.exit(0);
            }
        }

        catch (NumberFormatException nfe) {
            System.out.print("Lütfen rakam girdiğinizden emin olun ve tekrar deneyin.");
        }
        catch (ParseException e) {
            throw new RuntimeException(e);
        }

    };





    public int tarihHesapla(String getIseBaslama) throws ParseException {


        //iki tarih arasındaki farkı hesaplıyoruz.

            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date iseBaslama = sdf.parse(getIseBaslama);
            Date son = new Date();
            Date suanTarih = sdf.parse(sdf.format(son));
            long diffInMillies = Math.abs(suanTarih.getTime() - iseBaslama.getTime());
            long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
            int diffi= (int)diff;
            return diffi;
    }
    public int tarihHesaplaAraliktan(String getilktarih,String getsontarih) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date iseBaslama = sdf.parse(getilktarih);
        Date suanTarih = sdf.parse(getsontarih);
        long diffInMillies = Math.abs(suanTarih.getTime() - iseBaslama.getTime());
        long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
        int diffi= (int)diff;
        return diffi;
    }
    public void PersonelIzinAlimi() throws ParseException {

        Islemler islemler = new Islemler();
        System.out.println("*****************************");
        System.out.println("Lütfen aşağıdaki izin türlerinden birini seçin: ");
        System.out.println("1 - Yıllık İzin");
        System.out.println("2 - Hastalık İzni");
        System.out.println("3 - Diğer İzinler");
        System.out.println("0 - ANA MENÜ");
        Scanner scanner=new Scanner(System.in);
        int personeldeger = Integer.parseInt(scanner.nextLine());
        if (personeldeger==1){
            System.out.println("Lütfen bir personel kimlik numarası girin: ");
            String kno=scanner.nextLine();
            int index0 = -1;

            for (int i= 0; i<personelclass.personels.size(); i++){
                if (personelclass.personels.get(i).getKimlik().equals(kno)) {
                    index0 = i;
                    break;
                }
            }
            if (index0 != -1) {
                int izinhak=personelclass.personels.get(index0).getYilIzGun();
                System.out.println("Personele ait maksimum yıllık izin hakkı: "+ izinhak );
                if (izinhak!=0){
                    System.out.println("Lütfen izin başlangıç tarihini giriniz: ");
                    String ibas=scanner.nextLine();
                    System.out.println("Lütfen izin bitiş tarihini giriniz:");
                    String ibit=scanner.nextLine();
                    System.out.println("Lütfen izin adresinizi il bazında giriniz: ");
                    String gIl= scanner.nextLine().toUpperCase();
                   int gunsayi= tarihHesaplaAraliktan(ibas,ibit);
                   if (gunsayi<=izinhak){
                       int geciciizinhak=izinhak-gunsayi;
                       personelclass.personels.get(index0).setYilIzGun(geciciizinhak);
                       personelclass.personels.get(index0).setIzinTuru("YILLIK İZİN");
                       String izintur= personelclass.personels.get(index0).getIzinTuru();
                       System.out.println("İzin talebiniz başarıyla alınmıştır. İzin çıktınız hazırlanıyor....");
                       System.out.println();
                       System.out.println("*******************************************************");
                       System.out.println("***           İ Z İ N   B İ L G İ L E R İ           ***");
                       System.out.println("*******************************************************");
                       System.out.println("Şirket bilgisi: "+personelclass.personels.get(index0).getSirketAdi().toUpperCase());
                       System.out.println();
                       System.out.println("ADI SOYADI: "+ personelclass.personels.get(index0).getAd_soyad());
                       System.out.println();
                       System.out.println("TC Kimlik No: "+personelclass.personels.get(index0).getKimlik()+"               "+"Çalışılan Bölüm: "+personelclass.personels.get(index0).getBolum());
                       System.out.println();
                       System.out.println("Talep Edilen İzin Türü: "+izintur);
                       System.out.println();
                       System.out.println("İzin başlangıç tarihi: "+ibas+"       "+"İzin bitiş tarihi: "+ibit);
                       System.out.println();
                       System.out.println("İşe başlama tarihi: "+personelclass.personels.get(index0).getIseBaslama()+"          "+"İzin Süresi: "+gunsayi+" gün");
                       System.out.println();
                       System.out.println("İzin adresi: "+gIl);
                       System.out.println();
                       System.out.println("İzin talep tarihi: "+bugununtarihis);
                       System.out.println();
                       System.out.println("*******************************************************");

                       System.out.println("İşleminiz gerçekleşmiştir. \nAna menüye dönmek için herhangi bir karaktere basabilirsiniz.");
                       String herhangibirdeger= scanner.nextLine();
                       anaMenu();
                   }
                   else{
                       System.out.println("Tarih aralığında belirtilen gün sayısı, izin günü sayısını aşmaktadır. Lütfen tekrar deneyin.");
                       PersonelIzinAlimi();
                   }

                }
                else{
                    System.out.println("Personele ait mevcut izin hakkı bulunmamaktadır. Ana menüye yönlendirilme yapılacaktır.");
                    islemler.anaMenu();
                }

            }
            else{
                System.out.println("Belirtilen kimlik numarasına ait personel bulunamadı.");
                System.exit(0);

            }
        }
        else if (personeldeger==2){
            System.out.println("Lütfen bir personel kimlik numarası girin: ");
            String kno=scanner.nextLine();
            int index0 = -1;

            for (int i= 0; i<personelclass.personels.size(); i++){
                if (personelclass.personels.get(i).getKimlik().equals(kno)) {
                    index0 = i;
                    break;
                }
            }
            if (index0 != -1) {
                int izinhak=personelclass.personels.get(index0).getHastaIzinGun();
                System.out.println("Personele ait maksimum hastalık izin hakkı: "+ izinhak );
                if (izinhak!=0){
                    System.out.println("Lütfen izin başlangıç tarihini giriniz: ");
                    String ibas=scanner.nextLine();
                    System.out.println("Lütfen izin bitiş tarihini giriniz:");
                    String ibit=scanner.nextLine();
                    System.out.println("Lütfen izin adresinizi il bazında giriniz: ");
                    String gIl= scanner.nextLine().toUpperCase();
                    int gunsayi= tarihHesaplaAraliktan(ibas,ibit);
                    if (gunsayi<=izinhak){
                        int geciciizinhak=izinhak-gunsayi;
                        personelclass.personels.get(index0).setHastaIzinGun(geciciizinhak);
                        personelclass.personels.get(index0).setIzinTuru("HASTALIK İZNİ");
                        String izintur= personelclass.personels.get(index0).getIzinTuru();
                        System.out.println("İzin talebiniz başarıyla alınmıştır. İzin çıktınız hazırlanıyor....");
                        System.out.println();
                        System.out.println("*******************************************************");
                        System.out.println("***           İ Z İ N   B İ L G İ L E R İ           ***");
                        System.out.println("*******************************************************");
                        System.out.println("Şirket bilgisi: "+personelclass.personels.get(index0).getSirketAdi());
                        System.out.println();
                        System.out.println("ADI SOYADI: "+ personelclass.personels.get(index0).getAd_soyad());
                        System.out.println();
                        System.out.println("TC Kimlik No: "+personelclass.personels.get(index0).getKimlik()+"               "+"Çalışılan Bölüm: "+personelclass.personels.get(index0).getBolum());
                        System.out.println();
                        System.out.println("Talep Edilen İzin Türü: "+izintur);
                        System.out.println();
                        System.out.println("İzin başlangıç tarihi: "+ibas+"       "+"İzin bitiş tarihi: "+ibit);
                        System.out.println();
                        System.out.println("İşe başlama tarihi: "+personelclass.personels.get(index0).getIseBaslama()+"          "+"İzin Süresi: "+gunsayi+" gün");
                        System.out.println();
                        System.out.println("İzin adresi: "+gIl);
                        System.out.println();
                        System.out.println("İzin talep tarihi: "+bugununtarihis);
                        System.out.println();
                        System.out.println("*******************************************************");

                        System.out.println("İşleminiz gerçekleşmiştir. \nAna menüye dönmek için herhangi bir karaktere basabilirsiniz.");
                        String herhangibirdeger= scanner.nextLine();
                        anaMenu();
                    }
                    else{
                        System.out.println("Tarih aralığında belirtilen gün sayısı, izin günü sayısını aşmaktadır. Lütfen tekrar deneyin.");
                        PersonelIzinAlimi();
                    }

                }
                else{
                    System.out.println("Personele ait mevcut izin hakkı bulunmamaktadır. Ana menüye yönlendirilme yapılacaktır.");
                    islemler.anaMenu();
                }

            }
            else{
                System.out.println("Belirtilen kimlik numarasına ait personel bulunamadı.");
                System.exit(0);

            }
        }
        else if (personeldeger==3) {
            System.out.println("Lütfen bir personel kimlik numarası girin: ");
            String kno=scanner.nextLine();
            int index0 = -1;

            for (int i= 0; i<personelclass.personels.size(); i++){
                if (personelclass.personels.get(i).getKimlik().equals(kno)) {
                    index0 = i;
                    break;
                }
            }
            if (index0 != -1) {

                System.out.println("Diğer izin, tüm personellere ait belli sınır içermeyen izin türüdür.");
                System.out.println();
                System.out.println("Lütfen izin başlangıç tarihini giriniz: ");
                String ibas=scanner.nextLine();
                System.out.println("Lütfen izin bitiş tarihini giriniz:");
                String ibit=scanner.nextLine();
                System.out.println("Lütfen izin adresinizi il bazında giriniz: ");
                String gIl= scanner.nextLine().toUpperCase();
                int gunsayi= tarihHesaplaAraliktan(ibas,ibit);
                personelclass.personels.get(index0).setIzinTuru("DİĞER İZİN");
                String izintur= personelclass.personels.get(index0).getIzinTuru();
                System.out.println("İzin talebiniz başarıyla alınmıştır. İzin çıktınız hazırlanıyor....");
                System.out.println();
                System.out.println("*******************************************************");
                System.out.println("***           İ Z İ N   B İ L G İ L E R İ           ***");
                System.out.println("*******************************************************");
                System.out.println("Şirket bilgisi: "+personelclass.personels.get(index0).getSirketAdi().toUpperCase());
                System.out.println();
                System.out.println("ADI SOYADI: "+ personelclass.personels.get(index0).getAd_soyad());
                System.out.println();
                System.out.println("TC Kimlik No: "+personelclass.personels.get(index0).getKimlik()+"               "+"Çalışılan Bölüm: "+personelclass.personels.get(index0).getBolum());
                System.out.println();
                System.out.println("Talep Edilen İzin Türü: "+izintur);
                System.out.println();
                System.out.println("İzin başlangıç tarihi: "+ibas+"       "+"İzin bitiş tarihi: "+ibit);
                System.out.println();
                System.out.println("İşe başlama tarihi: "+personelclass.personels.get(index0).getIseBaslama()+"          "+"İzin Süresi: "+gunsayi+" gün");
                System.out.println();
                System.out.println("İzin adresi: "+gIl);
                System.out.println();
                System.out.println("İzin talep tarihi: "+bugununtarihis);
                System.out.println();
                System.out.println("*******************************************************");

                System.out.println("İşleminiz gerçekleşmiştir. \nAna menüye dönmek için herhangi bir karaktere basabilirsiniz.");
                String herhangibirdeger= scanner.nextLine();
                String herhangibirdeger2= scanner.nextLine();
                anaMenu();
            }
            else{
                System.out.println("Belirtilen kimlik numarasına ait personel bulunamadı.");
                System.exit(0);

            }
        }
        else if (personeldeger==0) {
            islemler.anaMenu();
        }
        else {
            System.out.println("Yanlış seçim. Lütfen tekrar deneyin.");
            PersonelIzinAlimi();
        }

    };

    public int YillikIzinGunSayisi(int calisilangun){
        if(calisilangun>365){
            int gun=14;
            return gun;
        }
        return 0;
    };
};
