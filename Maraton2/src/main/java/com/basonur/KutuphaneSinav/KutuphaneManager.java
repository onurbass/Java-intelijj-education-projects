package com.basonur.KutuphaneSinav;

import java.util.*;
import java.util.stream.Collectors;

public class KutuphaneManager implements IKutuphane {


    private static final String FIRMA_ADI = "KUTUPHANE";

    private static List<Kitap> kitaplar = new ArrayList<>();
    private static List<Musteri> musteriler = new ArrayList<>();
    private static List<Kasiyer> kasiyerler = new ArrayList<>();
    private static List<Kiralama> kiralamalar = new ArrayList<>();

    Scanner scanner =new Scanner(System.in);
    private static <T> void listeyeEkle(List<T> gelenListe, T gelenNesne) {
        gelenListe.add(gelenNesne);
    }

    private void musteriOlustur() {
        Musteri musteri1 = new Musteri( "Serkan");
        Musteri musteri2 = new Musteri( "Burak");
        Musteri musteri3 = new Musteri( "Osman");
        Musteri musteri4 = new Musteri("Gizem");
        listeyeEkle(musteriler, musteri1);
        listeyeEkle(musteriler, musteri2);
        listeyeEkle(musteriler, musteri3);
        listeyeEkle(musteriler, musteri4);
    }

    private void kasiyerOlustur() {
        Kasiyer kasiyer1 = new Kasiyer( "Salih", 30000.0);
        Kasiyer kasiyer2 = new Kasiyer( "Aysu", 40000.0);
        Kasiyer kasiyer3 = new Kasiyer( "Orhun", 35000.0);
        listeyeEkle(kasiyerler, kasiyer1);
        listeyeEkle(kasiyerler, kasiyer2);
        listeyeEkle(kasiyerler, kasiyer3);
    }

    private void kitapOlustur() {


        listeyeEkle(kitaplar, new Kitap( "Felsefe Taşı"));
        listeyeEkle(kitaplar, new Kitap( "Sırlar Odası"));
        listeyeEkle(kitaplar, new Kitap( "Azkaban Tutsagı"));
        listeyeEkle(kitaplar, new Kitap( "Ateş Kadehi"));
        listeyeEkle(kitaplar, new Kitap( "Anka Yoldaşlığı"));
        listeyeEkle(kitaplar, new Kitap( "Melez Prens"));
        listeyeEkle(kitaplar, new Kitap( "Ölüm Yadigarları"));
        listeyeEkle(kitaplar, new Kitap( "Witcher 1"));
        listeyeEkle(kitaplar, new Kitap( "Witcher 2"));
        listeyeEkle(kitaplar, new Kitap( "Witcher 3"));


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

    private void kiralamaOlustur() {
        Kiralama kiralama1 = new Kiralama(1, kasiyerler.get(0), musteriler.get(0), kitaplar.get(0));
        kitaplar.get(0).setDurum(EDurum.KIRADA);

        Kiralama kiralama2 = new Kiralama(2, kasiyerler.get(1), musteriler.get(1), kitaplar.get(1));
        kitaplar.get(1).setDurum(EDurum.KIRADA);

        Kiralama kiralama3 = new Kiralama(3, kasiyerler.get(2), musteriler.get(2), kitaplar.get(2));
        kitaplar.get(2).setDurum(EDurum.KIRADA);

        Kiralama kiralama4 = new Kiralama(4, kasiyerler.get(0), musteriler.get(3), kitaplar.get(3));
        kitaplar.get(3).setDurum(EDurum.KIRADA);

        Kiralama kiralama5 = new Kiralama(5, kasiyerler.get(3), musteriler.get(4), kitaplar.get(7));
        kitaplar.get(7).setDurum(EDurum.KIRADA);

        Kiralama kiralama6 = new Kiralama(7, kasiyerler.get(0), musteriler.get(0), kitaplar.get(10));
        kitaplar.get(10).setDurum(EDurum.KIRADA);

        Kiralama kiralama7 = new Kiralama(8, kasiyerler.get(1), musteriler.get(2), kitaplar.get(4));
        kitaplar.get(4).setDurum(EDurum.KIRADA);

        listeyeEkle(kiralamalar, kiralama1);
        listeyeEkle(kiralamalar, kiralama2);
        listeyeEkle(kiralamalar, kiralama3);
        listeyeEkle(kiralamalar, kiralama4);
        listeyeEkle(kiralamalar, kiralama5);
        listeyeEkle(kiralamalar, kiralama6);
        listeyeEkle(kiralamalar, kiralama7);

    }


    @Override
    public boolean kiralamaYap() throws KutuphaneException {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Kasiyer id : ");
        int kasiyerId = Integer.parseInt(scanner.nextLine());
        Kasiyer kasiyer = kasiyerler.get(kasiyerId - 1);

        System.out.println("----------------------------------");

        System.out.print("Müşteri id : ");
        int musteriId = Integer.parseInt(scanner.nextLine());
        Musteri musteri = musteriler.get(musteriId - 1);

        System.out.println("----------------------------------");

        System.out.println("Kirada olmayan kitaplar");

        kitaplar.stream()
                .filter(kutuphane -> kutuphane.getDurum().equals(EDurum.KUTUPHANEDE))
                .forEach(x -> {
                    System.out.println(x.getId() + " - " + x.getIsim() + " - " + x.getDurum());
                });

        System.out.println("Lütfen bir seçim yapınız");
        int kitapId = Integer.parseInt(scanner.nextLine());
        Kitap kitap = kitaplar.get(kitapId - 1);

        if (kitap.getDurum().equals(EDurum.KIRADA)) {
            throw new KutuphaneException("Kitap kirada. İşlem başarısız oldu.");
        } else {
            Kiralama kiralama = new Kiralama(kiralamalar.size() + 1, kasiyer, musteri, kitap);
            kiralamalar.add(kiralama);
            System.out.println("Kiralama başarılı ");
            return true;
        }

    }

    @Override
    public Kitap kitapAra() throws KutuphaneException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen kitap adını giriniz.");
        String arananKitap = scanner.nextLine();

        Optional<Kitap> kitap = kitaplar
                .stream()
                .filter(kutuphane -> kutuphane.getIsim().equalsIgnoreCase(arananKitap)).findFirst();

        if (kitap.isEmpty()) {
            throw new KutuphaneException("Kitap bulunamadı");
        }else {
            return kitap.get();
        }


    }

    @Override
    public Musteri musteriAra() throws KutuphaneException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Lütfen musteri adını giriniz.");
        String arananMusteri = scanner.nextLine();

        Optional<Musteri> musteri = musteriler
                .stream()
                .filter(mus -> mus.getIsim().equalsIgnoreCase(arananMusteri)).findFirst();

        if (musteri.isEmpty()) {
            throw new KutuphaneException("Müşteri bulunamadı");
        }

        return musteri.get();
    }

    @Override
    public List<Kitap> kiralananKitapListesi() throws KutuphaneException {

        List<Kitap> kiralananKitaplar = kitaplar.stream()
                .filter(kutuphane -> kutuphane.getDurum().equals(EDurum.KIRADA))
                .collect(Collectors.toList());

        if (kiralananKitaplar.isEmpty()) {
            throw new KutuphaneException("Şimdi kiralanan kitap yok, bulunamadı");
        }


        return kiralananKitaplar;
    }


    public static void main(String[] args) throws KutuphaneException {
        System.out.println(FIRMA_ADI);


        KutuphaneManager kutuphaneManager = new KutuphaneManager();
        kutuphaneManager.kitapOlustur();
        kutuphaneManager.kasiyerOlustur();



        listeyeEkle(musteriler, new Musteri( "Aminenur"));
        listeyeEkle(musteriler, new Musteri( "Ahmet"));
        listeyeEkle(musteriler, new Musteri( "Gani Ünal"));

        listeyeEkle(kasiyerler, new Kasiyer( "Abdullah", 33_000.0));
        listeyeEkle(kitaplar, new Kitap("Witcher 4"));
        kutuphaneManager.musteriOlustur();
        kutuphaneManager.kiralamaOlustur();
        for (Kitap kitap:kitaplar ) {
            System.out.println(kitap);
        } for (Kasiyer kasiyer:kasiyerler ) {
            System.out.println(kasiyer);
        }
        for (Musteri musteri:musteriler ) {
            System.out.println(musteri);
        }


        try {
            System.out.println(kutuphaneManager.kiralananKitapListesi());
            System.out.println(kutuphaneManager.kitapAra());
            System.out.println(kutuphaneManager.kiralamaYap());
            System.out.println(kutuphaneManager.musteriAra());
        } catch (KutuphaneException e) {
            System.out.println(e.getMesaj());
        }


        System.out.println("-----------------------------------------");
        System.out.println("Ahm ile başlayan müşterilerin listesini bul.");

        ahmIleBaslayanMusteriler().forEach(System.out::println);



        System.out.println("-----------------------------------------");
        System.out.println("Kitap adına göre kiralayan müşteriler");
        kitapAdinaGoreKirlayanMusteriler("Anka Yoldaşlığı").forEach(System.out::println);

        System.out.println("-----------------------------------------");
        System.out.println("id bilgisi verilen müşterinin kiraladığı tüm kitap listesi");
        musteriIdyeGoreKiralananKitaplar(1).forEach(System.out::println);
        ;

        System.out.println("-----------------------------------------");
        System.out.println("id bilgisi verilmiş olan kitap, kimin tarafından kiralanmış?");
        kitapIdyeGoreKiralayanMusteriler(2).forEach(System.out::println);
        ;
    }


    private static List<Musteri> ahmIleBaslayanMusteriler() {
        List<Musteri> musteriList = musteriler.stream()
                .filter(m -> m.getIsim().startsWith("Ahm"))
                .collect(Collectors.toList());
        return musteriList;
    }


    private static List<Musteri> kitapAdinaGoreKirlayanMusteriler(String kitapAdi) {
        List<Musteri> musteriList = kiralamalar.stream()
                .filter(kutuphane -> kutuphane.getKitap().getIsim().equalsIgnoreCase(kitapAdi))
                .map(mus -> mus.getMusteri())
                .collect(Collectors.toList());
        return musteriList;
    }

    private static List<Kitap> musteriIdyeGoreKiralananKitaplar(int musteriId) {

        return kiralamalar.stream().
                filter(m -> m.getMusteri().getId() == musteriId)
                .map(kutuphane -> kutuphane.getKitap())
                .collect(Collectors.toList());
    }


    private static List<Musteri> kitapIdyeGoreKiralayanMusteriler(int kitapId) {
        return kiralamalar.stream().
                filter(kutuphane -> kutuphane.getKitap().getId() == kitapId)
                .map(m -> m.getMusteri())
                .collect(Collectors.toList());
    }


}