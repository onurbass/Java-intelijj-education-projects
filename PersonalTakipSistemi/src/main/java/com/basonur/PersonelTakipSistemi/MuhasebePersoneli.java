package com.basonur.PersonelTakipSistemi;

import java.time.LocalDate;

public class MuhasebePersoneli extends Personel {
    private static int idNo=1;
    private String id;
    public MuhasebePersoneli(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);

        this.id="MP-"+idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id,this);
        setDepartman(PersonelManager.getDepartmanlar().get(4));
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        MuhasebePersoneli.idNo = idNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MuhasebePersoneli{" +
                "id='" + id + '\'' +
                "} " + super.toString();
    }
}
