package com.onurbas.lesson002_GSON;

public class Calisan {
    private   int calisanId;
    private   String adi;
    private  String soyadi;
    private  String departman;
    private  float maas;

    public int getCalisanId() {
        return calisanId;
    }

    public void setCalisanId(int calisanId) {
        this.calisanId = calisanId;
    }

    public String getAdi() {
        return adi;
    }

    public void setAdi(String adi) {
        this.adi = adi;
    }

    public String getSoyadi() {
        return soyadi;
    }

    public void setSoyadi(String soyadi) {
        this.soyadi = soyadi;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    public float getMaas() {
        return maas;
    }

    public void setMaas(float maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "Calisan{" +
                "calisanId=" + calisanId +
                ", adi='" + adi + '\'' +
                ", soyadi='" + soyadi + '\'' +
                ", departman='" + departman + '\'' +
                ", maas=" + maas +
                '}';
    }
}
