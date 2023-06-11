package com.mimaraslan;

import java.util.HashMap;

public class MapOrnek2_HashMap {

    public static void main(String[] args) {

       //   Map <String, String> plakaListesi = new HashMap<>();
        HashMap <String, String> plakaListesi = new HashMap<>();
        plakaListesi.put("Ankara", "06");
        plakaListesi.put("İzmir", "35");
        plakaListesi.put("Nevşehir", "50");
        plakaListesi.put("Yozgat", "66");
        plakaListesi.put("Adana", "01");
        plakaListesi.put("Konya", "42");
        plakaListesi.put("Kocaeli", null);
        plakaListesi.put(null, "27");
        plakaListesi.put(null, null);
        plakaListesi.put(null, null);
        System.out.println(plakaListesi);

        for (  String anahtar : plakaListesi.keySet()) {
            System.out.println( "Şehirlerin plaka numaları :  " + anahtar + "  " + plakaListesi.get(anahtar));
        }



    }
}
