import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class OtoGaleri implements IOtoGaleri {
    private  final String OTO_ISIM="OTOGALERI";
    private  static List<Araba> arabalar = new ArrayList<>();
    private  static List<Musteri> musteriler = new ArrayList<>();
    private  static List<Kasiyer> kasiyerler = new ArrayList<>();
    private  static List<Kiralama> kiralamalar = new ArrayList<>();



    public static <T> void listeyeEkle(List<T> list, T object) {
        int toplam=0;
        list.add(object);
    }

    public String randomIsım() {
        Random random = new Random();
        char[] array = new char[5]; // length is bounded by 7
        String generatedString = "";
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) random.nextInt(65, 90);
        }
        generatedString = String.valueOf(array);
        return generatedString;
    }


    public void musteriVeKasiyerOlustur() {
        Musteri musteri = new Musteri( randomIsım());
        Musteri musteri2 = new Musteri( randomIsım());
        Musteri musteri3 = new Musteri( randomIsım());
        Musteri musteri4 = new Musteri( randomIsım());
        Musteri musteri5 = new Musteri(randomIsım());
        Kasiyer kasiyer2 = new Kasiyer(randomIsım(),10000);
        Kasiyer kasiyer1 = new Kasiyer(randomIsım(),11000);
        listeyeEkle(musteriler,musteri);
        listeyeEkle(musteriler,musteri2);
        listeyeEkle(musteriler,musteri3);
        listeyeEkle(musteriler,musteri4);
        listeyeEkle(musteriler,musteri5);
        listeyeEkle(kasiyerler,kasiyer1);
        listeyeEkle(kasiyerler,kasiyer2);
    }

    public   void arabaOlustur(){
        for (int i = 0; i < 5; i++) {
            listeyeEkle(arabalar,new Araba(randomIsım()));
        }

    }
 public void kiralamaOlustur(){

 }
    @Override
    public Araba arabaAra() {
        return null;
    }

    @Override
    public Kasiyer kiralamaYap() {
        return null;
    }

    @Override
    public Musteri musteriAra() {
        return null;
    }

    @Override
    public List<Araba> kiralananArabalarListesi() {
        return null;
    }

    public String getOTO_ISIM() {
        return OTO_ISIM;
    }

    public static List<Araba> getArabalar() {
        return arabalar;
    }

    public static void setArabalar(List<Araba> arabalar) {
        OtoGaleri.arabalar = arabalar;
    }

    public static List<Musteri> getMusteriler() {
        return musteriler;
    }

    public static void setMusteriler(List<Musteri> musteriler) {
        OtoGaleri.musteriler = musteriler;
    }

    public static List<Kasiyer> getKasiyerler() {
        return kasiyerler;
    }

    public static void setKasiyerler(List<Kasiyer> kasiyerler) {
        OtoGaleri.kasiyerler = kasiyerler;
    }

    public static List<Kiralama> getKiralamalar() {
        return kiralamalar;
    }

    public static void setKiralamalar(List<Kiralama> kiralamalar) {
        OtoGaleri.kiralamalar = kiralamalar;
    }
}
