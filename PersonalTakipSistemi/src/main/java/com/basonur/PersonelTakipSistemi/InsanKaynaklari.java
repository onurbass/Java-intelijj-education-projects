package com.basonur.PersonelTakipSistemi;

import java.time.LocalDate;

public class InsanKaynaklari extends Personel {
    private static int idNo=1;
    private String id;

    public InsanKaynaklari(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id="IK-"+idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id,this);
        setDepartman(PersonelManager.getDepartmanlar().get(3));
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
        InsanKaynaklari.idNo = idNo;
    }

    @Override
    public java.lang.String toString() {
        return "InsanKaynaklari{" +
                "id=" + id +
                "} " + super.toString();
    }
}
