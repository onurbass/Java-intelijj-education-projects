import java.time.LocalDate;

public class Personel {
private String isim;
private int yas;
private float maas;
private LocalDate iseGiris;
private Departman departman;

    public Personel(String isim, int yas) {
        this.isim = isim;
        this.yas = yas;
    }

    public Personel(String isim, int yas, float maas) {
        this.isim = isim;
        this.yas = yas;
        this.maas=maas;
    }

    public Personel(String isim, int yas, float maas, LocalDate iseGiris) {
        this.isim = isim;
        this.yas = yas;
        this.maas = maas;
        this.iseGiris = iseGiris;


    }


    public LocalDate getIseGiris() {
        return iseGiris;
    }

    public void setIseGiris(LocalDate iseGiris) {
        this.iseGiris = iseGiris;
    }

    public Departman getDepartman() {
        return departman;
    }

    public void setDepartman(Departman departman) {
        this.departman = departman;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }


    public float getMaas() {
        return maas;
    }

    public void setMaas(float maas) {
        this.maas = maas;
    }

    public void setMaas(int maas) {
        this.maas = maas;
    }

    public int getYas() {
        return yas;
    }

    public void setYas(int yas) {
        this.yas = yas;
    }


    @Override
    public java.lang.String toString() {
        return "Personel{" +
                "isim=" + isim +
                ", yas=" + yas +
                ", maas=" + maas +
                ", iseGiris=" + iseGiris +
                ", departman=" + departman +
                '}';
    }
}
