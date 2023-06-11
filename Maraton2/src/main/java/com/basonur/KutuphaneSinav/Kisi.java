package com.basonur.KutuphaneSinav;

public class Kisi {

    private String isim;

    public Kisi(String isim) {

        this.isim = isim;
    }




    public String getIsim() {
        return isim;
    }
    public void setIsim(String isim) {
        this.isim = isim;
    }



    @Override
    public String toString() {
        return "Kisi{" +

                ", isim='" + isim + '\'' +
                '}';
    }
}
