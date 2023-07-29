package org.example.service;

import org.example.entity.Kisi;
import org.example.repository.KisiRepository;

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
