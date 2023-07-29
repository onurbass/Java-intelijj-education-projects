package org.example.service;

import org.example.entity.Arac;
import org.example.repository.AracRepository;

import java.util.List;

public class AracService {

    private AracRepository aracRepository;

    public AracService() {
        this.aracRepository = new AracRepository();
    }


    public Arac save(Arac arac) {
        // Sase numarasının unique olup olmadığını kontrol et
        if (aracRepository.aracKayitliMi(arac.getSaseNo())) {
            System.out.println("Bu sase numarası zaten kullanılıyor: " + arac.getSaseNo());
            return arac;
        }

        // Diğer gerekli işlemleri yap ve aracı kaydet
        aracRepository.save(arac);
        System.out.println("Araç başarıyla kaydedildi.");
        return arac;
    }

    public Arac findById(Long id) {
        return aracRepository.findById(id);
    }

    public List<Arac> kiradakiAraclar() {
        return aracRepository.kiradakiAraclar();
    }

    public List<Arac> musaitAraclar() {
        return aracRepository.musaitAraclar();
    }
}
