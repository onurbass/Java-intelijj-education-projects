package com.basonur.PersonelTakipSistemi;

import java.security.KeyStore;
import java.sql.SQLOutput;
import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;

public class PersonelManager {
    Scanner scanner = new Scanner(System.in);
    private static List<Departman> departmanlar = new ArrayList();
    private static List<Personel> personeller = new ArrayList<>();
    private static Map<String, Personel> personelById = new HashMap<>();

    public static void main(String[] args) {
        PersonelManager personelManager = new PersonelManager();
        personelManager.departmanOlustur();
        Hizmetli hizmetli = new Hizmetli("fsfs", 31, 31f, LocalDate.of(1998, 5, 5));
        Hizmetli hizmetli2 = new Hizmetli("fsfs", 31, 31f, LocalDate.of(1998, 5, 5));
        Hizmetli hizmetli3 = new Hizmetli("fsfs", 31, 31f, LocalDate.of(1998, 5, 5));
        Hizmetli hizmetli4 = new Hizmetli("fsfs", 31, 31f, LocalDate.of(1998, 5, 5));
        personelManager.secimSistemi();
    }

    public void departmanOlustur() {
        departmanlar.add(new Departman("Hizmet"));
        departmanlar.add(new Departman("Teknik"));
        departmanlar.add(new Departman("Yonetim"));
        departmanlar.add(new Departman("IK"));
        departmanlar.add(new Departman("Muhasebe"));
        departmanlar.add(new Departman("Buro"));
    }

    public void personelEkle() {
        String isim = Utility.stringDegerAlma("Personelin ismini giriniz");
        int yas = Utility.intDegerAlma("Personelin yaşını gir");
        float maas = (float) Utility.doubleDegerAlma("Personelin maaşını giriniz.");
        LocalDate iseGiris = Utility.stringTarihAlma("İşe başlama tarihi girin yil-ay-gün");
        for (Departman departman : departmanlar
        ) {
            System.out.println(departman);
        }
        String secilenDepartmanAdi = Utility.stringDegerAlma("Seçilen departmanın adını girin");
        Departman secilenDepartman = null;
        int secilenDepartmanIndex = -1;
        for (int i = 0; i < departmanlar.size(); i++) {
            if (departmanlar.get(i).getIsim().equals(secilenDepartmanAdi)) {
                secilenDepartmanIndex = i;
                break;
            }
        }
        if (secilenDepartmanIndex != -1) {
            secilenDepartman = departmanlar.get(secilenDepartmanIndex);
        } else {
            System.out.println("Seçilen departman bulunamadı.");
        }
        Personel personel = new Personel(isim, yas, maas, iseGiris);
        if (secilenDepartman != null) {
            personel.setDepartman(secilenDepartman);
        }
        personeller.add(personel);
        System.out.println("Personel işlemi başarılır. Girilen personel =>" + personel);
    }

    public void personelListele() {
        for (Personel personel :
                personeller) {
            System.out.println(personel);
        }
    }

    public void personelDüzenle() {
        personelListele();
        int personelSirasi = Utility.intDegerAlma("Düzenlemek istediğiniz personeli seçiniz.");
        String isim = Utility.stringDegerAlma("Personelin ismini giriniz");
        personeller.get(personelSirasi - 1).setIsim(isim);
        float maas = (float) Utility.doubleDegerAlma("Personelin maaşını giriniz.");
        personeller.get(personelSirasi - 1).setMaas(maas);
        for (Departman departman : departmanlar
        ) {
            System.out.println(departman);
        }
        int departmanSecim = Utility.intDegerAlma("Departmanı seçin");
        personeller.get(personelSirasi - 1).setDepartman(departmanlar.get(departmanSecim - 1));
        System.out.println("Personel düzenlenmiştir.==");
        System.out.println(personeller.get(personelSirasi - 1));
    }

    public void departmanEkle() {
        String departmanAdi = Utility.stringDegerAlma("Eklenecek departmanın adını girin");
        departmanlar.add(new Departman(departmanAdi));
        System.out.println("Departman ekleme işlemi başarılı");
        departmanListesi();
    }

    public void departmanListesi() {
        for (Departman departman :
                departmanlar) {
            System.out.println(departman);
        }
    }


    public void departmandakiPersoneller() {
        Map<Departman, List<Personel>> departmandakiPersoneller = new HashMap<>();
        for (Departman departman : departmanlar
        ) {
            departmandakiPersoneller.put(departman, departman.getDepartmandakiPersoneller());
        }

        departmandakiPersoneller.forEach((departman, list) ->
        {
            System.out.println("Departman => " + departman.getIsim());
            System.out.println("Personeller => ");
            list.stream().map(x -> x.getIsim()).forEach(System.out::println);
        });
    }

    public void enCokPersoneliBul() {
        Optional<Departman> enCokPersonel = departmanlar.stream().max(Comparator.comparingInt(x -> x.getDepartmandakiPersoneller().size()));
        if (enCokPersonel.isPresent()) {
            Departman departman = enCokPersonel.get();
            System.out.println("En çok personele sahip departman =>"+departman.getIsim());
            System.out.println("Personel sayisi => "+departman.getDepartmandakiPersoneller().size());

        } else {
            System.out.println("Başarısız");
        }
    }


    public static <T> void ekle(List<T> list, T object) {
        list.add(object);
        System.out.println(object + " eklenmiştir ");
    }

    public static List<Departman> getDepartmanlar() {
        return departmanlar;
    }

    public static void setDepartmanlar(List<Departman> departmanlar) {
        PersonelManager.departmanlar = departmanlar;
    }

    public static List<Personel> getPersoneller() {
        return personeller;
    }

    public static void setPersoneller(List<Personel> personeller) {
        PersonelManager.personeller = personeller;
    }

    public static Map<String, Personel> getPersonelById() {
        return personelById;
    }

    public static void setPersonelById(Map<String, Personel> personelById) {
        PersonelManager.personelById = personelById;
    }

    public void secimSistemi() {
        int anaMenuSecim;
        int altMenuSecim;

        do {
            anaMenu();
            anaMenuSecim = scanner.nextInt();

            switch (anaMenuSecim) {
                case 1:
                    do {
                        personelIslemleriMenu();
                        altMenuSecim = scanner.nextInt();
                        switch (altMenuSecim) {
                            case 1:
                                System.out.println("Personel Ekleme işlemi seçildi.");
                                personelEkle();

                                break;
                            case 2:
                                System.out.println("Personel Listesi işlemi seçildi.");
                                personelListele();

                                break;
                            case 3:
                                System.out.println("Personel Düzenleme işlemi seçildi.");
                                personelDüzenle();
                                break;
                            case 4:
                                System.out.println("Departman Ekleme işlemi seçildi.");
                                departmanEkle();
                                break;
                            case 5:
                                System.out.println("Departman Listesi işlemi seçildi.");
                                departmanListesi();
                                break;
                            case 0:
                                System.out.println("Ana menüye dönülüyor...");
                                break;
                            default:
                                System.out.println("Geçersiz bir seçim yaptınız.");
                                break;
                        }
                    } while (altMenuSecim != 0);
                    break;

                case 2:
                    do {
                        muhasebeIslemleriMenu();
                        altMenuSecim = scanner.nextInt();
                        switch (altMenuSecim) {
                            case 1:
                                System.out.println("Maaş Personel tanımlama işlemi seçildi.");

                                break;
                            case 2:
                                System.out.println("Ödeme Listesi işlemi seçildi.");

                                break;
                            case 0:
                                System.out.println("Ana menüye dönülüyor...");
                                break;
                            default:
                                System.out.println("Geçersiz bir seçim yaptınız.");
                                break;
                        }
                    } while (altMenuSecim != 0);
                    break;

                case 3:
                    do {
                        raporlamaMenu();
                        altMenuSecim = scanner.nextInt();
                        switch (altMenuSecim) {
                            case 1:
                                System.out.println("Departman Personel Listesi işlemi seçildi.");
                                departmandakiPersoneller();
                                break;
                            case 2:
                                System.out.println("En Çok Personel Bulunan Departman işlemi seçildi.");
                                enCokPersoneliBul();
                                break;
                            case 3:
                                System.out.println("Departmanlara göre maaş ortalamaları işlemi seçildi.");
                                departmanMaasOrtalamasıHesapla();
                                break;
                            case 4:
                                System.out.println("Müdürlerin sorumlu olduğu departman listesi işlemi seçildi.");

                                break;
                            case 5:
                                System.out.println("Kayıt tarihlerine göre personellerin sıralı listesi işlemi seçildi.");

                                break;
                            case 6:
                                System.out.println("Aynı gün içinde işe başlayan personellerin listesi işlemi seçildi.");

                                break;
                            case 0:
                                System.out.println("Ana menüye dönülüyor...");
                                break;
                            default:
                                System.out.println("Geçersiz bir seçim yaptınız.");
                                break;
                        }
                    } while (altMenuSecim != 0);
                    break;

                case 0:
                    System.out.println("Programdan çıkılıyor...");
                    break;

                default:
                    System.out.println("Geçersiz bir seçim yaptınız.");
                    break;
            }

        } while (anaMenuSecim != 0);
    }

    public static void anaMenu() {
        System.out.println("Ana Menü");
        System.out.println("1. Personel İşlemleri");
        System.out.println("2. Muhasebe İşlemleri");
        System.out.println("3. Raporlamalar");
        System.out.println("0. Çıkış");
        System.out.print("Seçiminizi yapın: ");
    }

    public static void personelIslemleriMenu() {
        System.out.println("Personel İşlemleri");
        System.out.println("1. Personel Ekleme");
        System.out.println("2. Personel Listesi");
        System.out.println("3. Personel Düzenleme");
        System.out.println("4. Departman Ekleme");
        System.out.println("5. Departman Listesi");
        System.out.println("0. Ana Menüye Dön");
        System.out.print("Seçiminizi yapın: ");
    }

    public static void muhasebeIslemleriMenu() {
        System.out.println("Muhasebe İşlemleri");
        System.out.println("1. Maaş Personel tanımlama");
        System.out.println("2. Ödeme Listesi");
        System.out.println("0. Ana Menüye Dön");
        System.out.print("Seçiminizi yapın: ");
    }

    public static void raporlamaMenu() {
        System.out.println("Raporlamalar");
        System.out.println("1. Departman Personel Listesi");
        System.out.println("2. En Çok Personel Bulunan Departman");
        System.out.println("3. Departmanlara göre maaş ortalamaları");
        System.out.println("4. Müdürlerin sorumlu olduğu departman listesi");
        System.out.println("5. Kayıt tarihlerine göre personellerin sıralı listesi");
        System.out.println("6. Aynı gün içinde işe başlayan personellerin listesi");
        System.out.println("0. Ana Menüye Dön");
        System.out.print("Seçiminizi yapın: ");
    }
}



