package com.basonur.PersonelTakipSistemi;

import java.time.LocalDate;

public class GenelMudur extends Personel {
    private static int idNo = 1;
    private String id;


    public GenelMudur(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id = "GM-" + idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id,this);
        setDepartman(PersonelManager.getDepartmanlar().get(2));
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
        GenelMudur.idNo = idNo;
    }

    @Override
    public String toString() {
        return "GenelMudur{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
