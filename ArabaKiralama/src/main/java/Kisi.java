public class Kisi {
    private static int id=0;
    private int nesneID;


    public void setNesneID(int nesneID) {
        this.nesneID = nesneID;
    }

    private String isim;

    public Kisi() {
    }

    public Kisi(String isim) {
        nesneID=++id;
        this.isim = isim;
    }


    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Kisi.id = id;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }
    public int getNesneID() {
        return nesneID;
    }

    @Override
    public String toString() {
        return "Kisi{" +
                "ID=" + nesneID +
                ", isim='" + isim + '\'' +
                '}';
    }
}
