package com.basonur.Soru3Ucak;

import java.util.HashMap;
import java.util.Map;

public class EkonomiYolcu extends Yolcu {
    private final int EKONOMIFIYAT = 100;

    Map<EFirmaAdi, Integer> biletlerMap = new HashMap<>();

    public EkonomiYolcu(int id, String ad, String soyad) {
        super(id, ad, soyad);

    }

    @Override
    public void yolcuBilgileriniGetir() {
        System.out.println("Yolcu bilgileri --> " + toString() + " Biletleri " + biletlerMap);
    }

    @Override
    public void biletAl(EFirmaAdi firmaAdi) {
        int biletFiyatı = getBASEFIYAT() + getEKONOMIFIYAT();
        if (!biletlerMap.containsKey(firmaAdi)) {
            biletlerMap.put(firmaAdi, biletFiyatı);
            System.out.println(getAd() + " Adlı yolcu " + firmaAdi + " firmasından EKONOMI sınıf bilet almıştır. Biletleriniz=> " + biletlerMap);
        } else {
            biletFiyatı = biletFiyatı + biletlerMap.get(firmaAdi);
            biletlerMap.put(firmaAdi, biletFiyatı);
            System.out.println(firmaAdi + " Adlı firmadan 1 bilet daha alınmıştır" + biletlerMap);
        }
    }

    @Override
    public void checkInYap() {
        if (isCheckIn()) System.out.println(getAd() + " için zaten check in yapılmıştır uçağa binebilirsiniz");
        else {
            System.out.println(getAd() + " için check in yapılmıştır iyi uçuşlar");
            setCheckIn(true);
        }

    }

    @Override
    public void ucagaBin() {
        if (isCheckIn()) {
            System.out.println(getAd() + " " + getKoltukNo() + " no'lu koltukta uçağa binebilirsiniz");
        } else System.out.println("Ucaga binmek için lütfen checkin yapın.");

    }

    public int getEKONOMIFIYAT() {
        return EKONOMIFIYAT;
    }


    @Override
    public String toString() {
        return "Ekonomi Yolcusu " + getAd();
    }
}
