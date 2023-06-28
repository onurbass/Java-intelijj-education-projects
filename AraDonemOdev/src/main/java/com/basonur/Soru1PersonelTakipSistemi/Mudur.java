package com.basonur.Soru1PersonelTakipSistemi;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Mudur extends Personel {
    private static int idNo = 1;
    private String id;
    private List<Departman> mudurunDepartmanlari;

    public Mudur(String isim, int yas, float maas, LocalDate iseGiris) {
        super(isim, yas, maas, iseGiris);
        setDepartman(PersonelManager.getDepartmanlar().get(6));
        getDepartman().getDepartmandakiPersoneller().add(this);
        this.id = "M-" + idNo++;
        PersonelManager.getPersoneller().add(this);
        PersonelManager.getPersonelById().put(this.id, this);
        this.mudurunDepartmanlari = new ArrayList<>();
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        Mudur.idNo = idNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Departman> getMudurunDepartmanlari() {
        return mudurunDepartmanlari;
    }

    public void setMudurunDepartmanlari(List<Departman> mudurunDepartmanlari) {
        this.mudurunDepartmanlari = mudurunDepartmanlari;
    }


    @Override
    public String toString() {
        return "Mudur{" +
                "id='" + id + '\'' +
                ", mudurunDepartmanlari=" + mudurunDepartmanlari +
                "} " + super.toString();
    }
}
