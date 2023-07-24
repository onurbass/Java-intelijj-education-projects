package com.onurbas;

import com.onurbas.repository.AracRepository;
import com.onurbas.repository.KiralamaRepository;
import com.onurbas.repository.KisiRepository;
import com.onurbas.repository.entity.*;
import com.onurbas.repository.enums.EDurum;
import com.onurbas.utility.HibernateUtility;
import com.sun.xml.bind.v2.TODO;
import org.hibernate.Session;

import javax.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * kişiyi oluştururken kiralamasını oluşturabilmeliyim.
 * kişi oluştururma içerisinde kiralayı oluştururken bir araç listesi verebilmeliyim
 * böylece kişiyi kaydettiğim esnada hem kiralama hem araçlar kaydedilmiş olur
 * ancak araçlar halihazırda sistemde kayıtlı olmalı ve default değeri kiralanabilir olmalı
 * yani kiralama işlemine verilecek liste kayıtlı arabalardan olmalı
 * kiralamaOluştur metoduna ihtiyacım yok kişi oluşturmadan bir kiralama oluşmaz???(düşün)
 * arabaOluştur metodu kesin olmalı
 * kişiOluştur metodu olabilir sonradan sisteme kayıtta yapılabilir deneme amaçlı yapalım
 * geçmiş kiralamalar olabilir bunlar sistemde kayıtlı tutulabilir
 * araçlar oluşturulacağı için bir araba bir id ye denk gelecek yada stok tutmam lazım aynı arabadan kaç tane var gibi
 * kirada- boşta olan araçları listelemem gerek stok yaparsam bunu yapabilir miyim sorgulamam gerek
 * stok olması durumunda metotlarımı buna göre kontrol etmeliyim
 * kişi kiralama araç ilişkisi mantıklı gibi
 * kişi birden çok kiralama yapabilir
 * bir kiralama bir arabaya denk gelir tek kiralama işleminde birden çok araba kiralanabilir mi????
 * en kolayı kiralamayı tek bi arabayla eşleştirmek fazla araba olsa bile birden çok aynı zamanla kiralama işlemi tutulabilir
 *
 *
 * ilişkiler **
 *
 *
 *
 * */

public class Main {
    Scanner scanner = new Scanner(System.in);
    static KisiRepository kisiRepository = new KisiRepository();
    static AracRepository aracRepository = new AracRepository();
    static KiralamaRepository kiralamaRepository = new KiralamaRepository();


    public static void main(String[] args) {


        // Araçları oluştur ve veritabanına kaydet
        Arac arac = Arac.builder().yil(1998).marka("merco").model("model1").build();
        Arac arac2 = Arac.builder().yil(1998).marka("merco2").model("model2").build();
        Arac arac3 = Arac.builder().yil(1998).marka("merco3").model("model3").build();
        aracRepository.save(arac);
        aracRepository.save(arac2);
        aracRepository.save(arac3);

        // Kiralamaları oluştur ve veritabanına kaydet
        Kiralama kiralama1 = Kiralama.builder().arac(arac).gunlukKiralamaUcreti(500d).build();
        Kiralama kiralama2 = Kiralama.builder().arac(arac2).gunlukKiralamaUcreti(500d).build();
        Kiralama kiralama3 = Kiralama.builder().arac(arac3).gunlukKiralamaUcreti(500d).build();


        // Kişi oluştur ve Kiralamaları ekle, ardından veritabanına kaydet
        Kisi kisi = Kisi.builder().tcKimlikNo("52144605658").name(Name.builder().firstName("onur").lastName("bas").build()).build();
        kiralama1.setKiralayanKisi(kisi);
        kiralama2.setKiralayanKisi(kisi);
        kiralama3.setKiralayanKisi(kisi);
        kisi.getKiralama().add(kiralama1);
        kisi.getKiralama().add(kiralama2);
        kisi.getKiralama().add(kiralama3);
        kisiRepository.save(kisi);
        Main main = new Main();
        main.kiradakiAraclar().forEach(System.out::println);
    }

    public void anaMenu() {

        String tercih = "";

        do {
            System.out.println("********************************************");
            System.out.println("*****ARAC KIRALAMA UYGULAMASI***************");
            System.out.println("********************************************");
            System.out.println("1-Arac Ekle");
            System.out.println("2-Arac Arama");
            System.out.println("3-Kisi Ekleme");
            System.out.println("4-Kiralama");
            System.out.println("5-Rapor");
            System.out.println("0-CIKIS");
            System.out.print("Seciniz....: ");

            tercih = scanner.nextLine();

            switch (tercih) {
                case "1":
                    System.out.println("Arac Ekleme secildi.");
                    // Burada araç ekleme işlemleri yapılabilir.
                    break;
                case "2":
                    System.out.println("Arac Arama secildi.");
                    // Burada araç arama işlemleri yapılabilir.
                    break;
                case "3":
                    System.out.println("Kisi Ekleme secildi.");
                    // Burada kişi ekleme işlemleri yapılabilir.
                    break;
                case "4":
                    System.out.println("Kiralama secildi.");
                    // Burada kiralama işlemleri yapılabilir.
                    break;
                case "5":
                    raporMenu();
                    break;
                case "0":
                    System.out.println("CIKIS secildi. Programdan cikiliyor...");
                    break;
                default:
                    System.out.println("Gecersiz secim! Lutfen tekrar deneyin.");
                    break;
            }

        } while (!tercih.equals("0"));

        scanner.close();
    }

    private void raporMenu() {
        String secim;

        do {
            System.out.println("************RAPOR MENUSU********************");
            System.out.println("1- Su anda kirada olan araçların listesi");
            System.out.println("2- Şu anda boşta olan araçların listesi");
            System.out.println("3- Herhangi bir müşterinin kiraladığı araçların listesi");
            System.out.println("0- Rapor menüsünden çıkış");
            System.out.print("Seciniz....: ");

            secim = scanner.nextLine();

            switch (secim) {
                case "1":
                    System.out.println("Su anda kirada olan araçlarin listesi:");
                    kiradakiAraclar();
                    break;
                case "2":
                    System.out.println("Su anda bos durumda olan araçlarin listesi:");
                    bostakiAraclar();
                    break;
                case "3":
                    System.out.println("Kiralama yapan bir müşterinin araçları:");
                    musterininKiraladigiArac();
                    break;
                case "0":
                    System.out.println("Rapor menüsünden çıkış yapıldı.");
                    break;
                default:
                    System.out.println("Gecersiz secim! Lutfen tekrar deneyin.");
                    break;
            }

        } while (!secim.equals("0"));
    }

    private List<Arac> kiradakiAraclar() {
        //burada araçtaki EDurumu kirada yapıp onlarda ayıklanabilir.
        List<Arac> kiradakiAraclarList;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String hql = "select a from Arac as a where a.aracId IN (select k.arac.aracId from Kiralama as k)";
            TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);
            kiradakiAraclarList = typedQuery.getResultList();
        } catch (Exception e) {
            // Hata yönetimini burada yapabilirsiniz.
            e.printStackTrace();
            kiradakiAraclarList = new ArrayList<>(); // Varsayılan boş liste dönebilirsiniz veya null dönebilirsiniz.
        }
        return kiradakiAraclarList;
    }

    private List<Arac> bostakiAraclar() {
        List<Arac> bostakiAraclarList;
        try (Session session = HibernateUtility.getSessionFactory().openSession()) {
            String hql = "select a from Arac as a where a.eDurum =:durum";
            TypedQuery<Arac> typedQuery = session.createQuery(hql, Arac.class);
            typedQuery.setParameter("durum", EDurum.KIRALANABILIR);
            bostakiAraclarList = typedQuery.getResultList();
            System.out.println("Boştaki araçlar ->");
            bostakiAraclarList.forEach(System.out::println);
        } catch (Exception e) {

            e.printStackTrace();
            bostakiAraclarList = new ArrayList<>();
        }
        return bostakiAraclarList;
    }

    public void kiralamaYap() {


        while (true) {
            System.out.print("Daha önce kiralama yaptınız mı? (Evet/Hayır): ");
            String dahaOnceKiralama = scanner.nextLine();

            if (dahaOnceKiralama.equalsIgnoreCase("evet")) {
                System.out.print("TC Kimlik No'nuzu girin: ");
                String tcKimlikNo = scanner.nextLine();
                // TODO kimliğe göre kullanıcıyı bul ve araç kiralama listesine seçtiği aracı ekle
                tcyeGoreBul();

                break;

            } else if (dahaOnceKiralama.equalsIgnoreCase("hayır")) {
                kisiOlustur();


            } else {
                System.out.println("Geçersiz giriş. Lütfen 'Evet' ya da 'Hayır' şeklinde cevap verin.");
            }
        }

        scanner.close();
    }

    private void tcyeGoreBul() {
    }

    public void kisiOlustur() {

        while (true) {
            System.out.println("Yeni Kullanıcı Bilgilerini Girin:");
            System.out.print("Adınız: ");
            String ad = scanner.nextLine();
            System.out.print("Soyadınız: ");
            String soyad = scanner.nextLine();
            System.out.print("TC Kimlik No: ");
            String tcKimlikNo = scanner.nextLine();
//            System.out.println("Şehir :");
//            String sehir = scanner.nextLine();
//            System.out.println("Ulke :");
//            String ulke = scanner.nextLine();
            Kisi kisi = Kisi.builder()
                    .tcKimlikNo(tcKimlikNo)
                    .name(Name.builder().firstName(ad).lastName(soyad).build())
//                   .adres(Adres.builder().sehir(sehir).ulke(ulke).build())
                    .build();
            kisiRepository.save(kisi);
            // Kullanıcı bilgileri doğrulama işlemleri yapılabilir
            // ...

            // Yeni kullanıcı oluşturulur ve veritabanına eklenir
            // ...

            System.out.println("Yeni kullanıcı başarıyla oluşturuldu.");

            // Doğru bilgiler girilene kadar döngü devam eder
            System.out.print("Yeni kiralama yapmak için 'Evet', çıkmak için 'Hayır' yazın: ");
            String devamEt = scanner.nextLine();

            if (devamEt.equalsIgnoreCase("hayır")) {
                break; // Döngüden çıkılır
            }
        }

        scanner.close();
    }

    private static void musterininKiraladigiArac() {
    }


    public void aracOlustur() {

    }


    public void kiralamaOlustur() {

    }
}