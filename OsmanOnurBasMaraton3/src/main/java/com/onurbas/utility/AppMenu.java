package com.onurbas.utility;

import com.onurbas.entity.Name;
import com.onurbas.controller.AracController;
import com.onurbas.controller.KiralamaController;
import com.onurbas.controller.KisiController;
import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;
import com.onurbas.entity.Kisi;
import com.onurbas.entity.enums.EDurum;
import java.util.List;
import java.util.Scanner;

public class AppMenu {
    static Scanner scanner = new Scanner(System.in);
    static AracController aracController;
    static KiralamaController kiralamaController;
    static KisiController kisiController;

    public AppMenu() {
        this.aracController = new AracController();
        this.kiralamaController = new KiralamaController();
        this.kisiController = new KisiController();
    }

    public void anaMenu() {

        int secim = 0;

        do {
            System.out.println("*******************************************");
            System.out.println("******** ARAÇ KİRALAMA UYGULAMASI *********");
            System.out.println("*******************************************");

            System.out.println("1- Arac Ekle");
            System.out.println("2- Arac Ara");
            System.out.println("3- Kişi Ekle");
            System.out.println("4- Arac Kirala");
            System.out.println("5- Rapor");
            System.out.println("0- Çıkış");

            secim = scanner.nextInt();
            scanner.nextLine();

            switch (secim) {
                case 1:
                    System.out.println("Arac ekle seçildi..");
                    aracEkle();
                    break;

                case 2:
                    System.out.println("Arac ara seçildi..");
                    aracAra();
                    break;

                case 3:
                    System.out.println("Kisi ekle seçildi..");
                    kisiEkle();
                    break;

                case 4:
                    System.out.println("Arac kirala seçildi..");
                    aracKirala();
                    break;

                case 5:
                    System.out.println("Rapor seçildi..");
                    rapor();
                    break;

                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    break;
            }

        } while (secim != 0);
    }

    public void aracEkle() {

        System.out.println("Lütfen aracın markasını giriniz");
        String marka = scanner.nextLine();

        System.out.println("Lütfen aracın modelini giriniz");
        String model = scanner.nextLine();
        System.out.println("Lütfen aracın Şasi No giriniz (*Zorunlu)");
        String saseNo = scanner.nextLine();

        Arac arac = Arac.builder().marka(marka).model(model).saseNo(saseNo).build();

        aracController.save(arac);
    }

    public void aracAra() {

        System.out.println("Lütfen arac id sini giriniz");
        Long id = scanner.nextLong();

        Arac arac = aracController.findById(id);
        System.out.println(arac);
    }

    public void aracKirala() {

        System.out.println("Lütfen arac id sini giriniz");
        Long id = scanner.nextLong();

        Arac arac = aracController.findById(id);
        arac.setDurum(EDurum.KIRADA);
        System.out.println("ARAC BİLGİSİ: " + arac);


        System.out.println("Lütfen kiralamak isteyen kisi id sini giriniz");
        Long kisiId = scanner.nextLong();

        Kisi kisi = kisiController.kisiAraById(kisiId);
        System.out.println("KİŞİ BİLGİSİ:" + kisi);


        Kiralama kiralama = Kiralama.builder()
                .arac(arac)
                .kisi(kisi)
                .build();
        kiralamaController.save(kiralama);
    }

    public void kisiEkle() {
        System.out.println("Yeni kişi kayıt oluşturuluyor..");

        System.out.println("Lütfen isminizi giriniz: ");
        String ad = scanner.nextLine();

        System.out.println("Lütfen soyisminizi giriniz");
        String soyad = scanner.nextLine();

        System.out.println("Lütfen tc giriniz (*Zorunlu)");
        String tcNo = scanner.nextLine();

        Kisi kisi = Kisi.builder()
                .name(Name.builder().firstName(ad).lastName(soyad).build()).tcNo(tcNo)
                .build();

        kisiController.save(kisi);
    }

    public void rapor() {

        int secim = 0;

        do {

            System.out.println("**************************");
            System.out.println("******** RAPORLAR ********");
            System.out.println("**************************");

            System.out.println("1- Şuan Kirada olan Araclar");
            System.out.println("2- Boşta müsait olan Araclar");
            System.out.println("3- Herhangi bir müşterinin kiraladığı Araclar");
            System.out.println("0- Çıkış");

            secim = scanner.nextInt();

            switch (secim) {
                case 1:
                    System.out.println("Şu an kirada olan araclar aranıyor. ");
                    kiradakiAraclar();
                    break;

                case 2:
                    System.out.println("Boşta müsait olan araclar aranıyor.");
                    musaitAraclar();
                    break;

                case 3:
                    System.out.println("Herhangi bir müşterinin kiraladığı araclar aranıyor.");
                    System.out.println("Kiralamaları aranacak kişi id girin.");
                    herhangiBirMusterininKiraladigiAraclar(scanner.nextLong());
                    break;


                case 0:
                    System.out.println("Çıkış yapılıyor...");
                    break;

                default:
                    break;
            }

        } while (secim != 0);
    }

    public void kiradakiAraclar() {
        List<Arac> araclerListesi = aracController.kiradakiAraclar();
        for (Arac arac : araclerListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }

    public void musaitAraclar() {
        List<Arac> araclarListesi = aracController.musaitAracler();
        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }

    public void herhangiBirMusterininKiraladigiAraclar(Long id) {
        List<Arac> araclarListesi = kiralamaController.kiralanmisArabalar(id);
        for (Arac arac : araclarListesi) {
            System.out.println("Durumu: " + arac.getDurum() + "\t Id: " + arac.getId() + "\t Marka: " + arac.getMarka() +
                    "\t Model: " + arac.getModel());
        }
    }

}

