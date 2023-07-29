package org.example.controller;

import org.example.entity.Arac;
import org.example.entity.Kiralama;
import org.example.service.KiralamaService;

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
