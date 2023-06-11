package com.basonur.Soru4;

public class Urun {
    String name;
    double fiyat;

    public Urun(String name, double fiyat) {
        this.name = name;
        this.fiyat = fiyat;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getFiyat() {
        return fiyat;
    }

    public void setFiyat(double fiyat) {
        this.fiyat = fiyat;
    }
}
