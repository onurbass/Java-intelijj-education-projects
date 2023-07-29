package org.example.service;

import org.example.entity.Arac;
import org.example.entity.Kiralama;
import org.example.repository.KiralamaRepository;

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
