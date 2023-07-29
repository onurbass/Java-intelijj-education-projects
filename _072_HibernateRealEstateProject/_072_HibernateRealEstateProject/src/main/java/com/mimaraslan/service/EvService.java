package com.mimaraslan.service;

import com.mimaraslan.model.Arac;
import com.mimaraslan.repository.EvRepository;

import java.util.List;

public class EvService {

    private EvRepository evRepository;

    public EvService() {
        this.evRepository = new EvRepository();
    }

    public Arac evOlustur(Arac arac) {
        return evRepository.evOlustur(arac);
    }

    public Arac evAraById(Long id) {
        return evRepository.evAraById(id);
    }

    public List<Arac> kiradakiEvler() {
        return evRepository.kiradakiEvler();
    }

    public List<Arac> musaitEvler() {
        return evRepository.musaitEvler();
    }
}
