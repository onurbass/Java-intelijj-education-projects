package com.basonur.Soru3Ucak;

import java.util.HashMap;
import java.util.Map;

public class BusinessYolcu extends Yolcu {
    private final int BUSSINESFIYAT = 200, BUSSINESVIPFIYAT = 150;
    private boolean vipMi;

    Map<EFirmaAdi, Integer> biletlerMap = new HashMap<>();

    public BusinessYolcu(int id, String ad, String soyad, boolean vipMi) {
        super(id, ad, soyad);
        this.vipMi = vipMi;
    }

    @Override
    public void yolcuBilgileriniGetir() {
        System.out.println("Yolcu bilgileri --> " + toString() + " Biletleri " + biletlerMap);
    }

    @Override
    public void biletAl(EFirmaAdi firmaAdi) {

        int biletFiyatı = 0;
        if (vipMi) {
            biletFiyatı = getBASEFIYAT() + getBUSSINESFIYAT() + getBUSSINESVIPFIYAT();
            biletlerMap.put(firmaAdi, biletFiyatı);
            System.out.println(getAd() + " Adlı yolcu " + firmaAdi + " firmasından VIP bilet almıştır. Biletleriniz=> " + biletlerMap);
        } else {
            biletFiyatı = getBASEFIYAT() + getBUSSINESFIYAT();
            biletlerMap.put(firmaAdi, biletFiyatı);
            System.out.println(getAd() + " Adlı yolcu " + firmaAdi + " firmasından BUSINESS bilet almıştır. Biletleriniz=> " + biletlerMap);
        }
    }

    @Override
    public void checkInYap() {
        if (isCheckIn()) System.out.println(getAd() + " için zaten check in yapılmıştır uçağa binebilirsiniz");
        else {
            System.out.println(getAd() + " için check in yapılmıştır iyi uçuşlar.");
            setCheckIn(true);
        }

    }

    @Override
    public void ucagaBin() {
        if (isCheckIn()) {
            System.out.println(getAd() + " " + getKoltukNo() + " no'lu koltukta uçağa binebilirsiniz");
        } else System.out.println("Ucaga binmek için lütfen checkin yapın");

    }

    public int getBUSSINESFIYAT() {
        return BUSSINESFIYAT;
    }

    public int getBUSSINESVIPFIYAT() {
        return BUSSINESVIPFIYAT;
    }

    @Override
    public String toString() {
        return "Business Yolcusu " + getAd();
    }
}
