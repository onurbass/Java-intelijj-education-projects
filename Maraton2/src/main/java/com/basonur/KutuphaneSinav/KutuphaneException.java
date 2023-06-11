package com.basonur.KutuphaneSinav;

// Custom Exception
public class KutuphaneException extends Exception {

    private String mesajj;

    public KutuphaneException(String mesaj) {
        super(mesaj);
        this.mesajj = mesaj;
    }

    public String getMesaj() {
        return mesajj;
    }

    public void setMesaj(String mesaj) {
        this.mesajj = mesaj;
    }
}
