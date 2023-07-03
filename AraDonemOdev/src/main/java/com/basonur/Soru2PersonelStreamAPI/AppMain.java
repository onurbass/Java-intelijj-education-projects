package com.basonur.Soru2PersonelStreamAPI;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class AppMain {
    public static void main(String[] args) {
        List<Personel> personelListesi = new ArrayList<>();
        personelListesi.add(new Personel("Ahmet", 30));
        personelListesi.add(new Personel("Ayşe", 25));
        personelListesi.add(new Personel("Mehmet", 35));
        personelListesi.add(new Personel("Fatma", 28));
        personelListesi.add(new Personel("Ali", 32));
        personelListesi.add(new Personel("Zeynep", 29));
        personelListesi.add(new Personel("Mustafa", 40));
        personelListesi.add(new Personel("Esra", 27));
        personelListesi.add(new Personel("Ömer", 33));
        personelListesi.add(new Personel("Gül", 26));
        personelListesi.add(new Personel("Hakan", 31));
        personelListesi.add(new Personel("Elif", 24));
        personelListesi.add(new Personel("Serkan", 38));
        personelListesi.add(new Personel("Deniz", 23));
        personelListesi.add(new Personel("Sevgi", 30));
        personelListesi.add(new Personel("Murat", 37));
        personelListesi.add(new Personel("Selin", 22));
        personelListesi.add(new Personel("Cem", 29));
        personelListesi.add(new Personel("Pınar", 36));
        personelListesi.add(new Personel("Emre", 27));

       long otuzdanBuyuk= personelListesi.stream()
                .filter(personel -> personel.getYas() > 30)
                .count();

        System.out.println("Yaşı 30'dan büyük olan personellerin sayısı: " + otuzdanBuyuk);

        long aIleBaslayanlar = personelListesi.stream()
                .filter(personel -> personel.getAd().startsWith("A"))
                .count();

        System.out.println("İsimleri A harfiyle başlayan personellerin sayısı: " + aIleBaslayanlar);

        String enYasliPersonel = personelListesi.stream()
                .max(Comparator.comparingInt(Personel::getYas))
                .map(Personel::getAd)
                .orElse("");

        System.out.println("Yaşı en büyük olan personelin adı: " + enYasliPersonel);

        int alininYasi = personelListesi.stream()
                .filter(x -> x.getAd().equals("Ali"))
                .map(y-> y.getYas())
                .findFirst()
                .orElse(0);

        System.out.println("İsmi Ali olan personelin yaşı: " + alininYasi);

        List<String> enKucukUcPersonel = personelListesi.stream()
                .sorted(Comparator.comparingInt(x->x.getYas()))
                .limit(3)
                .map(y->y.getAd())
                .collect(Collectors.toList());

        System.out.println("Yaşı en küçük olan 3 personelin isimleri: " + enKucukUcPersonel);

        long yasAraligi = personelListesi.stream()
                .filter(personel -> personel.getYas() >= 25 && personel.getYas() <= 35)
                .count();

        System.out.println("Yaşı 25 ile 35 arasında olan personellerin sayısı: " + yasAraligi);

        List<String> dorttenUzunIsımler = personelListesi.stream()
                .filter(x -> x.getAd().length() > 4)
                .map(y -> y.getAd())
                .collect(Collectors.toList());

        System.out.println("İsimleri 4 harften uzun olan personellerin isimleri: " + dorttenUzunIsımler);

        List<String> enBuyukIkiPersonel = personelListesi.stream()
                .sorted(Comparator.comparingInt(Personel::getYas).reversed())
                .limit(2)
                .map(Personel::getAd)
                .collect(Collectors.toList());

        System.out.println("Yaşı en büyük 2 personelin isimleri: " + enBuyukIkiPersonel);

        List<String> aIleBitenler = personelListesi.stream()
                .filter(personel -> personel.getAd().endsWith("a"))
                .map(personel -> personel.getAd().toUpperCase())
                .collect(Collectors.toList());

        System.out.println("İsimleri a harfi ile biten personellerin isimleri: " + aIleBitenler);

        double isimUzunlukOrt = personelListesi.stream()
                .mapToDouble(personel -> personel.getAd().length())
                .average()
                .orElse(0.0);

        System.out.println("İsimlerin uzunluğunun ortalaması: " + isimUzunlukOrt);

        int enUzunIsım = personelListesi.stream()
                .max(Comparator.comparingInt(p->p.getAd().length())).map(b->b.getYas()).get();


        System.out.println("İsmi en uzun olan personelin yaşı: " + enUzunIsım);

        boolean ahmetVarMi = personelListesi.stream()
                .anyMatch(personel -> personel.getAd().equalsIgnoreCase("ahmet"));

        System.out.println("İsimlerden herhangi biri ahmet mi? " + ahmetVarMi);

        List<String> tersSiralanmisIsimListesi = personelListesi.stream()
                .map(personel -> new StringBuilder(personel.getAd()).reverse().toString())
                .sorted()
                .collect(Collectors.toList());

        System.out.println("İsimleri ters çevirilmiş olarak alfabetik olarak sıralanmış liste: " + tersSiralanmisIsimListesi);

        List<String> eHarfiOlanlar = personelListesi.stream()
                .filter(personel -> personel.getAd().contains("e") || personel.getAd().contains("E"))
                .map(x -> x.getAd())
                .collect(Collectors.toList());

        System.out.println("e harfi geçen personellerin isimleri: " + eHarfiOlanlar);



        Map<String, Integer> enKucukKisi2 = personelListesi.stream()
                .min(Comparator.comparingInt(Personel::getYas)).stream().collect(Collectors.toMap(x->x.getAd(),y->y.getYas()));


        System.out.println("Yaşı en küçük olan personelin adı ve yaşı map: " + enKucukKisi2);


    }
}
