package com.basonur.Soru1PersonelTakipSistemi;

import java.time.LocalDate;

public class Hizmetli extends Personel {
    private static int idNo = 1;
    private String id;


    public Hizmetli(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);
        setDepartman(PersonelManager.getDepartmanlar().get(0));
        getDepartman().getDepartmandakiPersoneller().add(this);
        this.id = "H-" + idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id, this);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        Hizmetli.idNo = idNo;
    }


    @Override
    public String toString() {
        return "Hizmetli{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
