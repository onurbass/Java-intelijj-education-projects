package com.basonur.Soru3Ucak;

public class AppMain {
    public static void main(String[] args) {
        Yolcu yolcu1 = new BusinessYolcu(1, "Onur", "Bas", false);
        Yolcu yolcu2 = new EkonomiYolcu(6, "Ahmet", "Demir");
        Yolcu yolcu3 = new BusinessYolcu(2, "Aslı", "Bahar", true);
        System.out.println("****BUSINESS VIP YOLCU****");
        yolcu3.biletAl(EFirmaAdi.ADJ);
        yolcu3.biletAl(EFirmaAdi.THY);
        System.out.println("****");
        yolcu3.ucagaBin();
        yolcu3.ucagaBin();
        yolcu3.checkInYap();
        yolcu3.checkInYap();
        yolcu3.ucagaBin();
        yolcu3.yolcuBilgileriniGetir();
        System.out.println("******* EKONOMI YOLCU *******");
        yolcu2.biletAl(EFirmaAdi.ADJ);
        yolcu2.biletAl(EFirmaAdi.THY);
        yolcu2.biletAl(EFirmaAdi.THY);
        yolcu2.biletAl(EFirmaAdi.THY);
        System.out.println("****");
        yolcu2.ucagaBin();
        yolcu2.ucagaBin();
        yolcu2.checkInYap();
        yolcu2.checkInYap();
        yolcu2.ucagaBin();
        yolcu2.yolcuBilgileriniGetir();
        System.out.println("******** BUSINESS YOLCU********");
        yolcu1.biletAl(EFirmaAdi.ADJ);
        yolcu1.biletAl(EFirmaAdi.THY);
        System.out.println("****");
        yolcu1.ucagaBin();
        yolcu1.ucagaBin();
        yolcu1.checkInYap();
        yolcu1.checkInYap();
        yolcu1.ucagaBin();
        yolcu1.yolcuBilgileriniGetir();

    }

    public static void biletAl(Yolcu yolcu, EFirmaAdi firmaAdi) {
        yolcu.biletAl(firmaAdi);
    }


    public void checkInYap(Yolcu yolcu) {

    }


    public void ucagaBin(Yolcu yolcu) {

    }
}
