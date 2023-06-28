package com.basonur.Soru1PersonelTakipSistemi;


import java.time.LocalDate;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class PersonelManager implements IIslev {
    Scanner scanner = new Scanner(System.in);
    private static List<Departman> departmanlar = new ArrayList();
    private static List<Personel> personeller = new ArrayList<>();
    private static Map<String, Personel> personelById = new HashMap<>();

    public static void main(String[] args) {
        PersonelManager personelManager = new PersonelManager();
        personelManager.departmanOlustur();
        personelManager.defPersonelOlustur();
        personelManager.secimSistemi();
    }

    public void departmanOlustur() {
        departmanlar.add(new Departman("Hizmet"));
        departmanlar.add(new Departman("Teknik"));
        departmanlar.add(new Departman("Genel Mudur"));
        departmanlar.add(new Departman("IK"));
        departmanlar.add(new Departman("Muhasebe"));
        departmanlar.add(new Departman("Buro"));
        departmanlar.add(new Departman("Mudur"));
    }

    public void defPersonelOlustur() {
        Mudur mudur = new Mudur("Ali", 31, 11000f, LocalDate.of(2020, 6, 7));
        Mudur mudur1 = new Mudur("Kerim", 65, 25000f, LocalDate.of(2016, 8, 7));
        Mudur mudur2 = new Mudur("Mustafa", 56, 25000f, LocalDate.of(2016, 8, 7));
        Hizmetli hizmetli1 = new Hizmetli("Onur", 30, 10000f, LocalDate.of(2020, 6, 7));
        GenelMudur genelMudur = new GenelMudur("Veli", 25, 35000f, LocalDate.of(2016, 8, 7));
        InsanKaynaklari insanKaynaklari = new InsanKaynaklari("Ahmet", 33, 13000f, LocalDate.of(2016, 8, 7));
        TeknikPersonel teknikPersonel = new TeknikPersonel("Mehmet", 31, 14000f, LocalDate.of(2019, 9, 15));
        BuroPersoneli buroPersoneli = new BuroPersoneli("Cenk", 35, 15000f, LocalDate.of(2017, 6, 20));
        MuhasebePersoneli muhasebePersoneli = new MuhasebePersoneli("Menk", 45, 16000f, LocalDate.of(2014, 3, 2));
        mudur.getMudurunDepartmanlari().add(departmanlar.get(0));
        mudur.getMudurunDepartmanlari().add(departmanlar.get(1));
        mudur1.getMudurunDepartmanlari().add(departmanlar.get(3));
        mudur1.getMudurunDepartmanlari().add(departmanlar.get(4));
        mudur2.getMudurunDepartmanlari().add(departmanlar.get(5));
    }

    public void personelEkle() {
        String secim;
        int sayac = 1;
        String isim = Utility.stringDegerAlma("Personelin ismini giriniz");
        int yas = Utility.intDegerAlma("Personelin yaşını gir");
        float maas = Float.parseFloat(Utility.stringDegerAlma("Personelin maaşını giriniz."));
        LocalDate iseGiris = Utility.stringTarihAlma("İşe başlama tarihi girin yil-ay-gün");
        scanner.nextLine();
        System.out.println("Eklenecek personelin departmanını seçin :");
        for (Departman departman : departmanlar
        ) {
            System.out.println(sayac + "-" + departman.getIsim());
            sayac++;
        }
        System.out.println("0. Çıkış");
        secim = scanner.nextLine();
        if (Integer.parseInt(secim) <= 7 && Integer.parseInt(secim) >= 1) {
            switch (secim) {
                case "1":
                    Hizmetli hizmetli = new Hizmetli(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + hizmetli);
                    break;
                case "2":
                    TeknikPersonel teknikPersonel = new TeknikPersonel(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + teknikPersonel);
                    break;
                case "3":
                    GenelMudur genelMudur = new GenelMudur(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + genelMudur);
                    break;
                case "4":
                    InsanKaynaklari insanKaynaklariPersoneli = new InsanKaynaklari(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + insanKaynaklariPersoneli);
                    break;
                case "5":
                    MuhasebePersoneli muhasebePersoneli = new MuhasebePersoneli(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + muhasebePersoneli);
                    break;
                case "6":
                    BuroPersoneli buroPersoneli = new BuroPersoneli(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + buroPersoneli);
                    break;
                case "7":
                    Mudur mudur = new Mudur(isim, yas, maas, iseGiris);
                    System.out.println("Personel ekleme başarılı. Eklenen personel => " + mudur);
                    break;
                default:
                    System.out.println("Geçersiz seçim. Lütfen tekrar deneyin.");
                    break;
            }
        } else {
            if (Integer.parseInt(secim) > 7 && Integer.parseInt(secim) <= departmanlar.size()) {
                Personel personel = new Personel(isim,yas,maas,iseGiris);
                personel.setDepartman(departmanlar.get(Integer.parseInt(secim)-1));
                departmanlar.get(Integer.parseInt(secim)-1).getDepartmandakiPersoneller().add(personel);
                System.out.println("Personel ekleme başarılı => "+personel);

            }
        }
    }

    public void personelListele() {
        int sayac = 0;
        try {
            if (!personeller.isEmpty()) {
                for (Personel personel :
                        personeller) {
                    sayac++;
                    System.out.println(sayac + ".personel=> " + personel.getIsim() + " - " + personel.getId() + " - " + personel.getDepartman().getIsim());
                }
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Personel bulunmadığından işlem başarısız");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        sayac = 0;
    }

    public void personelDüzenle() {
        try {
            if (!personeller.isEmpty()) {
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
                if (departmanSecim < departmanlar.size() && departmanSecim >= 1) {
                    delete(personeller.get(personelSirasi - 1).getDepartman().getDepartmandakiPersoneller(), personeller.get(personelSirasi - 1));
                    personeller.get(personelSirasi - 1).setDepartman(departmanlar.get(departmanSecim - 1));
                    departmanlar.get(departmanSecim - 1).getDepartmandakiPersoneller().add(personeller.get(personelSirasi - 1));
                    System.out.println("Personel düzenlenmiştir.==");
                    System.out.println(personeller.get(personelSirasi - 1));
                } else throw new RuntimeException("Yanlış departman girişi");
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Personel bulunmadığından işlem başarısız");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void departmanEkle() {
        String departmanAdi = Utility.stringDegerAlma("Eklenecek departmanın adını girin");
        try {
            if (!departmanlar.stream().anyMatch(x -> x.equals(departmanAdi))) {
                save(departmanlar, new Departman(departmanAdi));
                System.out.println("Departman ekleme işlemi başarılı");
            } else throw new PersonelTakipException(ErrorType.ZATEN_VAR, "Departman zaten mevcut");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        departmanListesi();
    }

    public void departmanListesi() {
        try {
            if (!departmanlar.isEmpty()) {
                for (Departman departman :
                        departmanlar) {
                    System.out.println(departman.getIsim());
                }
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Departman bulunamadı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void maasPersonelTanimla() {
        try {
            if (!personeller.isEmpty()) {
                personelListele();
                int personelSirasi = Utility.intDegerAlma("Düzenlemek istediğiniz personeli seçiniz.");
                float maas = (float) Utility.doubleDegerAlma("Personelin maaşını giriniz.");
                personeller.get(personelSirasi - 1).setMaas(maas);
                System.out.println("Personel maaşı düzenlenmiştir.");
                System.out.println(personeller.get(personelSirasi - 1));
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Personel bulunmadığından işlem başarısız");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void odemeListesi() {
        for (Personel personel : personeller
        ) {
            System.out.println(personel.getIsim() + "isimli personelin maasi=>" + personel.getMaas());
        }
    }

    public void departmandakiPersoneller() {
        Map<Departman, List<Personel>> departmandakiPersoneller = new HashMap<>();
        for (Departman departman : departmanlar
        ) {
            departmandakiPersoneller.put(departman, departman.getDepartmandakiPersoneller());
        }
        try {
            if (!departmandakiPersoneller.isEmpty()) {
                departmandakiPersoneller.forEach((departman, list) ->
                {
                    System.out.println("Departman => " + departman.getIsim());
                    System.out.println("Personeller => ");
                    list.stream().map(x -> x.getIsim()).forEach(System.out::println);
                });
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Departmanda personel bulunamadı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void enCokPersoneliBul() {
        Optional<Departman> enCokPersonel = departmanlar.stream().max(Comparator.comparingInt(x -> x.getDepartmandakiPersoneller().size()));
        try {
            if (enCokPersonel.isPresent()) {
                Departman departman = enCokPersonel.get();
                System.out.println("En çok personele sahip departman =>" + departman.getIsim());
                System.out.println("Personel sayisi => " + departman.getDepartmandakiPersoneller().size());
            } else {
                throw new PersonelTakipException(ErrorType.LISTE_BOS, "Departman bulunamadı");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    private void departmanMaasOrtalamasıHesapla() {
        Map<Departman, Double> departmanMaasOrt = departmanlar.stream()
                .collect(Collectors.toMap(x -> x,
                        x -> x.getDepartmandakiPersoneller()
                                .stream().mapToDouble(y -> y.getMaas()).average().orElse(0.0)));
        try {
            if (!departmanMaasOrt.isEmpty()) {
                for (Entry<Departman, Double> departmanOrtMaas : departmanMaasOrt.entrySet()
                ) {
                    System.out.println(departmanOrtMaas.getKey().getIsim() + " departmanının maaş ortalaması => " + departmanOrtMaas.getValue());
                }
            } else throw new PersonelTakipException(ErrorType.LISTE_BOS, "Ortalama bulunamadı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void mudurlerinDepartmanlari() {
        try {
            Map<Mudur, List<Departman>> mudurDepartmanMap = personeller.stream()
                    .filter(x -> x instanceof Mudur)
                    .collect(Collectors.toMap(x -> (Mudur) x, x -> ((Mudur) x).getMudurunDepartmanlari()));
            for (Entry<Mudur, List<Departman>> mudurDepartmanEntry : mudurDepartmanMap.entrySet()) {
                System.out.println(mudurDepartmanEntry.getKey().getIsim() + " => " + mudurDepartmanEntry.getValue().stream().map(Departman::getIsim)
                        .collect(Collectors.toList()));
            }
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void kayitTarihineGorePersoneller() {
        List<Personel> siraliListe = personeller.stream().sorted((Comparator.comparing(Personel::getIseGiris))).collect(Collectors.toList());
        for (Personel personel : siraliListe
        ) {
            System.out.println(personel.getIsim() + " adlı personelin işe girişi -> " + personel.getIseGiris());
        }
    }

    public void ayniGunIseBaslayanlar() {
        Map<LocalDate, List<Personel>> tarhiGorePersonelMap = personeller.stream()
                .collect(Collectors.groupingBy(Personel::getIseGiris));
        for (LocalDate tarih : tarhiGorePersonelMap.keySet()) {
            if (tarhiGorePersonelMap.get(tarih).size() >= 2) {
                System.out.println("Başlangıç günü : " + tarih);
                for (Personel personel : tarhiGorePersonelMap.get(tarih)) {
                    System.out.println(personel.getIsim());
                }
            }
        }
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
                                maasPersonelTanimla();
                                break;
                            case 2:
                                System.out.println("Ödeme Listesi işlemi seçildi.");
                                odemeListesi();
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
                                mudurlerinDepartmanlari();
                                break;
                            case 5:
                                System.out.println("Kayıt tarihlerine göre personellerin sıralı listesi işlemi seçildi.");
                                kayitTarihineGorePersoneller();
                                break;
                            case 6:
                                System.out.println("Aynı gün içinde işe başlayan personellerin listesi işlemi seçildi.");
                                ayniGunIseBaslayanlar();
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

    @Override
    public <T> void save(List<T> list, T t) {
        list.add(t);
    }

    @Override
    public <T> void delete(List<T> list, T t) {
        list.remove(t);
    }

    @Override
    public <T> List<T> findAll(List<T> list, T t) {
        List<T> bulunanlar = new ArrayList<>();
        for (T eleman : list) {
            if (eleman.equals(t)) {
                bulunanlar.add(eleman);
            }
        }
        return bulunanlar;
    }

    @Override
    public void findById() {
        String arananId = Utility.stringDegerAlma("Aranacak idyi girin");
        Optional<Personel> arananPersonel = personeller.stream()
                .filter(x -> x.getDepartman().getDepartmandakiPersoneller().stream()
                        .anyMatch(y -> y.getId().equals(arananId)))
                .findFirst();
        try {
            if (arananPersonel.isPresent()) {
                Personel personel = arananPersonel.get();
                System.out.println("Aranan id bulundu. Personel bilgileri ->\n" + personel);
            } else throw new PersonelTakipException(ErrorType.LISTEDE_YOK, "Aranan id bulunamadı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    @Override
    public void deleteById() {
        String arananId = Utility.stringDegerAlma("Aranacak idyi girin");
        Personel arananPersonel = personeller.stream()
                .filter(x -> x.getDepartman().getDepartmandakiPersoneller().stream()
                        .anyMatch(y -> y.getId().equals(arananId)))
                .findFirst().orElse(null);
        try {
            if (arananPersonel != null) {
                System.out.println("Aranan id bulundu ve silindi ->\n" + arananPersonel);
                delete(personeller, arananPersonel);
            } else throw new PersonelTakipException(ErrorType.LISTEDE_YOK, "Aranan id bulunamadı");
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }
}



