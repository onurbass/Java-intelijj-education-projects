package com.basonur.Soru4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class AppMain {
    public static void main(String[] args) {

        List<Urun> urunList = List.of(new Urun("kola", 15.0),
                new Urun("ekmek", 5.0),

                new Urun("süt", 25.0),
                new Urun("yogurt", 35.0),
                new Urun("kahve", 30.0),
                new Urun("deterjan", 70.0));
        Map<String, Double> urunMap = new HashMap<>();
        urunMap = urunList.stream().filter(x -> x.fiyat > 20 && x.fiyat < 50)
                .collect(Collectors.toMap(x -> x.name, x -> x.fiyat));

        for (Entry<String, Double> urunFiyat : urunMap.entrySet()) {
            System.out.println(urunFiyat);
        }
    }
}
