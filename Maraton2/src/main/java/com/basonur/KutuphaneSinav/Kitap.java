package com.basonur.KutuphaneSinav;

public class Kitap {
 private static int kitapIdNo=0;
    private int id;
    private String isim;

    private EDurum durum;

    public Kitap() {
    }

    public Kitap(String isim) {
        this.isim = isim;
        this.id=++kitapIdNo;
        this.durum = EDurum.KUTUPHANEDE;
    }

    public Kitap(int id, String isim) {
        this.id = id;
        this.isim = isim;
        this.durum = EDurum.KUTUPHANEDE;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public EDurum getDurum() {
        return durum;
    }

    public void setDurum(EDurum durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Kitap{" +
                "id=" + id +
                ", isim='" + isim + '\'' +
                ", durum=" + durum +
                '}';
    }
}
