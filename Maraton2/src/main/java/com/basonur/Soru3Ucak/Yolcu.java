package com.basonur.Soru3Ucak;

import java.util.Random;

public abstract class Yolcu {
    private int id, koltukNo;
    private String ad;
    private String soyad;
    private boolean checkIn;
    private final int BASEFIYAT = 100;
    static Random random = new Random();

    public Yolcu(int id, String ad, String soyad) {
        this.id = id;
        this.ad = ad;
        this.soyad = soyad;
        this.koltukNo = random.nextInt(0, 200);
        this.checkIn = false;
    }

    public abstract void yolcuBilgileriniGetir();

    public abstract void biletAl(EFirmaAdi firmaAdi);

    public abstract void checkInYap();

    public abstract void ucagaBin();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKoltukNo() {
        return koltukNo;
    }

    public void setKoltukNo(int koltukNo) {
        this.koltukNo = koltukNo;
    }

    public String getAd() {
        return ad;
    }

    public void setAd(String ad) {
        this.ad = ad;
    }

    public String getSoyad() {
        return soyad;
    }

    public void setSoyad(String soyad) {
        this.soyad = soyad;
    }

    public boolean isCheckIn() {
        return checkIn;
    }

    public void setCheckIn(boolean checkIn) {
        this.checkIn = checkIn;
    }

    public int getBASEFIYAT() {
        return BASEFIYAT;
    }

    @Override
    public String toString() {
        return "Yolcu{" +
                "id=" + id +
                ", koltukNo=" + koltukNo +
                ", ad='" + ad + '\'' +
                ", soyad='" + soyad + '\'' +
                ", checkIn=" + checkIn +
                '}';
    }
}
