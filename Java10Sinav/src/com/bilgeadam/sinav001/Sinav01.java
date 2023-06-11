package com.bilgeadam.sinav001;

import java.util.Scanner;

public class Sinav01 {

	public static void main(String[] args) {
		int sayiDizisi[] = { 9, 7, 5, 3, 7, 7, 3, 18, 2, 0, 7 };

		tekrariBul(sayiDizisi);
		karakterSayici("string ifade", 'g');
		yildizMetot();
		geometrikHesap();

	}

	private static void geometrikHesap() {
		Scanner scanner = new Scanner(System.in);
		int islem = 0;
		double pi = 3.14;
		do {
			System.out.println("==========Geometrik Hesaplayıcı==========");
			System.out.println("1. Kare alan hesaplama");
			System.out.println("2. Kare çevre hesaplama");
			System.out.println("3. Dikdörtgen alan hesaplama");
			System.out.println("4. Dikdörtgen çevre hesaplama");
			System.out.println("5. Daire alan hesaplama");
			System.out.println("6. Daire çevre hesaplama");
			System.out.println("7. Çıkış");

			System.out.print("Yapacağınız işlemi seçin ");
			islem = scanner.nextInt();

			switch (islem) {
			case 1:
				System.out.print("Karenin bir kenar uzunluğunu girin: ");
				int kareKenar = scanner.nextInt();
				int kareAlan = kareKenar * kareKenar;
				System.out.println("Karenin alanı: " + kareAlan);
				break;
			case 2:
				System.out.print("Karenin bir kenar uzunluğunu girin: ");
				kareKenar = scanner.nextInt();
				int kareCevre = 4 * kareKenar;
				System.out.println("Karenin çevresi: " + kareCevre);
				break;
			case 3:
				System.out.print("Dikdörtgenin kısa kenar uzunluğunu girin: ");
				int dikdortgenKisaKenar = scanner.nextInt();
				System.out.print("Dikdörtgenin uzun kenar uzunluğunu girin: ");
				int dikdortgenUzunKenar = scanner.nextInt();
				if (dikdortgenUzunKenar > dikdortgenKisaKenar) {
					int dikdortgenAlan = dikdortgenKisaKenar * dikdortgenUzunKenar;
					System.out.println("Dikdörtgenin alanı: " + dikdortgenAlan);
					break;
				} else {
					System.out.println("Yanlış giriş");
					break;
				}

			case 4:
				System.out.print("Dikdörtgenin kısa kenar uzunluğunu girin: ");
				dikdortgenKisaKenar = scanner.nextInt();
				System.out.print("Dikdörtgenin uzun kenar uzunluğunu girin: ");
				dikdortgenUzunKenar = scanner.nextInt();
				int dikdortgenCevre = 2 * (dikdortgenKisaKenar + dikdortgenUzunKenar);
				System.out.println("Dikdörtgenin çevresi: " + dikdortgenCevre);
				break;
			case 5:
				System.out.print("Dairenin yarıçapını girin: ");
				int daireYaricap = scanner.nextInt();
				double daireAlan = pi * daireYaricap * daireYaricap;
				System.out.println("Dairenin alanı: " + daireAlan);
				break;
			case 6:
				System.out.print("Dairenin yarıçapını girin: ");
				daireYaricap = scanner.nextInt();
				double daireCevre = 2 * pi * daireYaricap;
				System.out.println("Direnin çevresi = " + daireCevre);
				break;
			case 7:
				System.out.println("Çıkış yapılıyor...");
				break;
			}
			System.out.println();
		} while (islem != 7);

	}

	public static void karakterSayici(String ifade, char karakter) {
		int sayac = 0;
		for (int i = 0; i < ifade.length(); i++) {
			if (ifade.charAt(i) == karakter) {
				sayac++;
			}

		}
		System.out.println("Karakterinin sayısı : " + sayac);
	}

	public static void yildizMetot() {
		for (int i = 0; i < 4; i++) {
			System.out.println("* * * * * * *");

		}
		for (int i = 6; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				System.out.print("* ");

			}
			System.out.println();
		}

	}

	public static void tekrariBul(int[] dizi) {
		boolean tekrarKontrol = false;
		int tekrarSayisi = 0;
		int ilkTekrarEdenSayi = 0;
		for (int i = 0; i < dizi.length; i++) {
			int sayac = 0;
			for (int j = i + 1; j < dizi.length; j++) {

				if (dizi[i] == dizi[j]) {
					sayac++;
					if (tekrarKontrol == false) {
						ilkTekrarEdenSayi = dizi[i];
						tekrarKontrol = true;
					}
				}
			}
			if (sayac > 0 && sayac > tekrarSayisi) {
				tekrarSayisi = sayac;
			}
		}
		if (tekrarKontrol == true) {

			System.out.println("İlk tekrar eden sayı : " + ilkTekrarEdenSayi);
			System.out.println("Tekrar sayısı : " + (tekrarSayisi + 1));
		} else {
			System.out.println("Tekrar eden sayı yoktur.");
		}
	}
}
