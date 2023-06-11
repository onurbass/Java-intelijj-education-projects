package com.bilgeadam.sinav001;

public class CustomStringTR {

	public static void main(String[] args) {
		String str1 = "Osman Onur BAŞ";
		String str2 = "Onur BAŞ";
		System.out.println(uzunluk(str1));
		System.out.println(degistir(str1, 'A', 'B'));
		System.out.println(esitmi(str1, str2));
		System.out.println(harfleriBuyut(str1));
		System.out.println(harfleriKucult(str2));
		System.out.println(indextekiKarakter(str2, 5));
		System.out.println(birlestir(str1, str2));
		System.out.println(icermeKontrol(str1, "BAŞ"));
		System.out.println(ayir(str1, 4));
		System.out.println(kacinciIndex(str1, "n"));

	}

	public static String harfleriBuyut(String ifade)// 1
	{

		return ifade.toUpperCase();
	}

	public static String harfleriKucult(String ifade)// 2
	{

		return ifade.toLowerCase();
	}

	public static String degistir(String ifade, char karakterEski, char karakterYeni)// 3
	{

		return ifade.replace(karakterEski, karakterYeni);
	}

	public static int uzunluk(String ifade)// 4
	{

		return ifade.length();
	}

	public static boolean esitmi(String ifade, String ikinciIfade)// 5
	{

		return ifade.equals(ikinciIfade);
	}

	public static char indextekiKarakter(String ifade, int index)// 6
	{

		return ifade.charAt(index);
	}

	public static String birlestir(String ifade, String ikinciIfade)// 7
	{

		return ifade.concat(ikinciIfade);
	}

	public static boolean icermeKontrol(String ifade, String kontrol)// 8
	{

		return ifade.contains(kontrol);
	}

	public static String ayir(String ifade, int index) // 9
	{

		return ifade.substring(index);
	}

	public static int kacinciIndex(String ifade, String karakter) // 10
	{

		return ifade.indexOf(karakter);
	}

}
