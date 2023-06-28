package com.basonur.Soru1PersonelTakipSistemi;

import java.time.LocalDate;

public class BuroPersoneli extends Personel {
    private static int idNo = 1;
    private String id;

    public BuroPersoneli(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);
        this.id = "BP-" + idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id, this);
        setDepartman(PersonelManager.getDepartmanlar().get(5));
        getDepartman().getDepartmandakiPersoneller().add(this);
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
        BuroPersoneli.idNo = idNo;
    }

    @Override
    public String toString() {
        return "BuroPersoneli{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
