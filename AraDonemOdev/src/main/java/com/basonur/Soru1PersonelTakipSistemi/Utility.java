package com.basonur.Soru1PersonelTakipSistemi;

import java.time.LocalDate;
import java.util.Optional;
import java.util.Scanner;

public class Utility {
    static Scanner scanner = new Scanner(System.in);

    public static int intDegerAlma(String sorgu) {
        boolean kontrol = false;
        int sayi = 0;
        do {
            System.out.println(sorgu);
            try {
                sayi = scanner.nextInt();
                kontrol = false;
            } catch (Exception e) {
                System.out.println(e.toString());
                kontrol = true;
            } finally {
                scanner.nextLine();
            }
        } while (kontrol);
        return sayi;
    }

    public static double doubleDegerAlma(String sorgu) {
        boolean kontrol = false;
        double sayi = 0;
        do {
            System.out.println(sorgu);
            try {
                sayi = Double.parseDouble(scanner.nextLine());
                kontrol = false;
            } catch (Exception e) {
                System.out.println(e.toString());
                kontrol = true;
            }
        } while (kontrol);
        return sayi;
    }

    public static long longDegerAlma(String sorgu) {
        boolean kontrol = false;
        long sayi = 0;
        do {
            System.out.println(sorgu);
            try {
                sayi = Long.parseLong(scanner.nextLine());
                kontrol = false;
            } catch (Exception e) {
                System.out.println(e.toString());
                kontrol = true;
            }
        } while (kontrol);
        return sayi;
    }

    public static String stringDegerAlma(String sorgu) {
        System.out.println(sorgu);
        return scanner.nextLine();
    }

    public static LocalDate stringTarihAlma(String sorgu) {
        boolean kontrol = false;
        LocalDate date = null;
        do {
            try {
                System.out.println(sorgu);
                date = LocalDate.parse(scanner.nextLine());
                kontrol = false;
            } catch (Exception e) {
                System.out.println(e.toString() + ": lütfen yıl-ay-gun formatında bir tarih girin");
                kontrol = true;
            }
        } while (kontrol);
        return date;
    }

    public static Optional<LocalDate> stringTarihDegeriniTarihDegerineCevir(String tarih) {
        boolean kontrol = false;
        LocalDate date = null;
        try {
            date = LocalDate.parse(tarih);
            kontrol = false;
        } catch (Exception e) {
            System.out.println(e.toString() + ": lütfen yıl-ay-gun formatında bir tarih girin");
            kontrol = true;
        }
        return Optional.ofNullable(date);
    }

    public static void cizgiCek() {
        System.out.println("===============");
    }
}
