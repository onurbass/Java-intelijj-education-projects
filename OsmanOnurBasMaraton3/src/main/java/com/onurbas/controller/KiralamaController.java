package com.onurbas.controller;

import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;
import com.onurbas.service.KiralamaService;

import java.util.List;

public class KiralamaController {

    private KiralamaService kiralamaService;

    public KiralamaController() {
        this.kiralamaService = new KiralamaService();
    }


    public Kiralama save(Kiralama kiralama) {
        kiralamaService.setKiralamaBitisTarihi(kiralama);
        return kiralamaService.save(kiralama);
    }

    public List<Arac> kiralanmisArabalar(Long id) {
        return kiralamaService.kiralananAraclarByKisiId(id);
    }
}
