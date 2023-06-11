package com.basonur.KutuphaneSinav;

import java.util.List;

public interface IKutuphane {

    boolean kiralamaYap() throws KutuphaneException;


    Kitap kitapAra() throws KutuphaneException;

    Musteri musteriAra() throws KutuphaneException;

    List<Kitap> kiralananKitapListesi() throws KutuphaneException;

}
