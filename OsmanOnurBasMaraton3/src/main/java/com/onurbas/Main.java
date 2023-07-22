package com.onurbas;

import com.onurbas.repository.AracRepository;
import com.onurbas.repository.KiralamaRepository;
import com.onurbas.repository.KisiRepository;
import com.onurbas.repository.entity.Arac;
import com.onurbas.repository.entity.Kiralama;
import com.onurbas.repository.entity.Kisi;
import com.onurbas.repository.entity.Name;
import com.onurbas.utility.HibernateUtility;
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

    Arac arac;

    public static void main(String[] args) {
        KisiRepository kisiRepository = new KisiRepository();
        AracRepository aracRepository = new AracRepository();
        KiralamaRepository kiralamaRepository = new KiralamaRepository();

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
        Kisi kisi = Kisi.builder()
                .name(Name.builder().firstName("onur").lastName("bas").build())
                .email("bacs")
                .build();
        kiralama1.setKiralayanKisi(kisi);
        kiralama2.setKiralayanKisi(kisi);
        kiralama3.setKiralayanKisi(kisi);
        kisi.getKiralama().add(kiralama1);
        kisi.getKiralama().add(kiralama2);
        kisi.getKiralama().add(kiralama3);
        kisiRepository.save(kisi);
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
                    raporMenu(scanner);
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

    private void raporMenu(Scanner scanner) {
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
    private  void bostakiAraclar() {
    }



    private static void musterininKiraladigiArac() {
    }


    public void aracOlustur() {

    }

    public void kisiOlustur() {

    }

    public void kiralamaOlustur() {

    }
}