public class Araba {
    private static int id;
    private int nesneID;
    private String isim;
    private EDurum durum;

    public Araba() {
    }

    public int getNesneID() {
        return nesneID;
    }

    public void setNesneID(int nesneID) {
        this.nesneID = nesneID;
    }

    public Araba(String isim) {
        nesneID=++id;
        this.isim = isim;
        this.durum = EDurum.GALERIDE;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public EDurum getDurum() {
        return durum;
    }

    public void setDurum(EDurum durum) {
        this.durum = durum;
    }

    @Override
    public String toString() {
        return "Araba{" +
                "ID=" + nesneID +
                ", isim='" + isim + '\'' +
                ", durum=" + durum +
                '}';
    }
}
