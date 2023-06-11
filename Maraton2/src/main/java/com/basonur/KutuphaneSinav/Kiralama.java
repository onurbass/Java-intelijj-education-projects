package com.basonur.KutuphaneSinav;

public class Kiralama {
    private static int kiralamaNo;
    private int id;
    private Kasiyer kasiyer;
    private Musteri musteri;
    private Kitap kitap;
    private long tarih;




    public Kiralama() {
    }

    public Kiralama(int id, Kasiyer kasiyer, Musteri musteri, Kitap kitap) {
        this.id = ++kiralamaNo;
        this.kasiyer = kasiyer;
        this.musteri = musteri;
        this.kitap = kitap;
        this.tarih = System. currentTimeMillis();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Kasiyer getKasiyer() {
        return kasiyer;
    }

    public void setKasiyer(Kasiyer kasiyer) {
        this.kasiyer = kasiyer;
    }

    public Musteri getMusteri() {
        return musteri;
    }

    public void setMusteri(Musteri musteri) {
        this.musteri = musteri;
    }

    public Kitap getKitap() {
        return kitap;
    }

    public void setKitap(Kitap kitap) {
        this.kitap = kitap;
    }

    public long getTarih() {
        return tarih;
    }

    public void setTarih(long tarih) {
        this.tarih = tarih;
    }

    @Override
    public String toString() {
        return "Kiralama{" +
                "id=" + id +
                ", kasiyer=" + kasiyer +
                ", musteri=" + musteri +
                ", kitap=" + kitap +
                ", tarih=" + tarih +
                '}';
    }
}
