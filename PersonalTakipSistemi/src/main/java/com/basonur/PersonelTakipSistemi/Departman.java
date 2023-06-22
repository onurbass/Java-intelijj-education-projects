package com.basonur.PersonelTakipSistemi;

import java.util.ArrayList;
import java.util.List;

public class Departman {
    private String isim;

    private  List<Personel> departmandakiPersoneller;

    public Departman(String isim) {
        this.isim = isim;
        this.departmandakiPersoneller=new ArrayList<>();
    }



    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public List<Personel> getDepartmandakiPersoneller() {
        return departmandakiPersoneller;
    }

    public void setDepartmandakiPersoneller(List<Personel> departmandakiPersoneller) {
        this.departmandakiPersoneller = departmandakiPersoneller;
    }

    @Override
    public java.lang.String toString() {
        return "Departman{" +
                "departman=" + isim +

                '}';
    }
}
