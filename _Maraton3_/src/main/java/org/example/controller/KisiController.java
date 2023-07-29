package org.example.controller;

import org.example.entity.Kisi;
import org.example.service.KisiService;

public class KisiController {

    private KisiService kisiService;

    public KisiController() {

        this.kisiService = new KisiService();
    }

    public Kisi save(Kisi kisi){
        return kisiService.save(kisi);
    }

    public Kisi kisiAraById(Long id) {
        return kisiService.kisiAraById(id);
    }
}
