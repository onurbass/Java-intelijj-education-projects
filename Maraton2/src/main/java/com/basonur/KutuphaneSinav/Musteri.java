package com.basonur.KutuphaneSinav;


import java.util.ArrayList;
import java.util.List;

public class Musteri extends Kisi {
    private static  int idNo=0;
    private int id;
private List<Kitap> kiralananKitaplar;

    public Musteri( String isim) {
        super(isim);
        this.kiralananKitaplar = new ArrayList<>();
        this.id=++idNo;
    }

    public List<Kitap> getKiralananKitaplar() {
        return kiralananKitaplar;
    }

    public void setKiralananKitaplar(List<Kitap> kiralananKitaplar) {
        this.kiralananKitaplar = kiralananKitaplar;
    }

    public static int getIdNo() {
        return idNo;
    }

    public static void setIdNo(int idNo) {
        Musteri.idNo = idNo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Musteri{" +
                "id=" + id +
                ", kiralananKitaplar=" + kiralananKitaplar +
                "} " + super.toString();
    }
}
