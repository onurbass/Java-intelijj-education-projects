package com.basonur.Soru1PersonelTakipSistemi;

import java.time.LocalDate;
import java.util.Objects;

public  class Personel  {
    //yeni oluşturulan departmana personel ekleyebilmek için abstract yapılamamaktadır
    private String isim;
    private int yas;
    private float maas;
    private LocalDate iseGiris;
    private Departman departman;
    private String id;

    public Personel(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public Personel(String isim, int yas, float maas) {
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
    }

    public Personel(String isim, int yas, float maas, LocalDate iseGiris) {
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.iseGiris = iseGiris;
    }

    public String getId() {
        return id;
    }
    public LocalDate getIseGiris() {
        return iseGiris;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }

    public float getMaas() {
        return maas;
    }

    public void setMaas(float maas) {
        this.maas = maas;
    }

    public void setIseGiris(LocalDate iseGiris) {
        this.iseGiris = iseGiris;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Personel{");
        sb.append("isim='").append(isim).append('\'');
        sb.append(", yas=").append(yas);
        sb.append(", maas=").append(maas);
        sb.append(", iseGiris=").append(iseGiris);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personel personel)) return false;
        return getYas() == personel.getYas() && Float.compare(personel.getMaas(), getMaas()) == 0 && Objects.equals(getIsim(), personel.getIsim()) && Objects.equals(getIseGiris(), personel.getIseGiris()) && Objects.equals(getDepartman(), personel.getDepartman());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIsim(), getYas(), getMaas(), getIseGiris(), getDepartman());
    }
}
