package com.onurbas.service;

import com.onurbas.repository.KiralamaRepository;
import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;

import java.util.List;

public class KiralamaService {

    private KiralamaRepository kiralamaRepository;

    public KiralamaService() {
        this.kiralamaRepository = new KiralamaRepository();
    }

    public void kiradakiEvler() {
        kiralamaRepository.kiradakiAraclar();
    }

    public Kiralama save(Kiralama kiralama) {
        return kiralamaRepository.save(kiralama);
    }

    public List<Arac> kiralananAraclarByKisiId(Long id) {
        return kiralamaRepository.kiralananAraclarByKisiId(id);
    }

    public void setKiralamaBitisTarihi(Kiralama kiralama) {
        kiralama.setKiralamaBitisTarihi(kiralama.getKiralamaTarihi().plusDays(kiralama.getPeriod()));
    }
}
