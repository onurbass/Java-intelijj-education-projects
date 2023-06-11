package com.basonur.KutuphaneSinav;

public class Kasiyer extends Kisi {
    private static  int idNo=0;
    private int id;
    private double maas;

    public Kasiyer( String isim, double maas) {
        super( isim);
        this.maas = maas;
        this.id=++idNo;
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        Kasiyer.idNo = idNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getMaas() {
        return maas;
    }

    public void setMaas(double maas) {
        this.maas = maas;
    }

    @Override
    public String toString() {
        return "Kasiyer{" +
                "id=" + id +
                ", maas=" + maas +
                "} " + super.toString();
    }
}
