package com.onurbas.service;

import com.onurbas.repository.KisiRepository;
import com.onurbas.entity.Kisi;

public class KisiService {

    private KisiRepository kisiRepository;

    public KisiService() {
        this.kisiRepository = new KisiRepository();
    }


    public Kisi save(Kisi kisi) {
        return kisiRepository.save(kisi);
    }

    public Kisi kisiAraById(Long id) {
        return kisiRepository.findById(id);
    }
}
