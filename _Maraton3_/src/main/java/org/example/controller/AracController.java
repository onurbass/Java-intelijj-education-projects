package org.example.controller;

import org.example.entity.Arac;
import org.example.service.AracService;

import java.util.List;

public class AracController {

    private AracService aracService;

    public AracController() {
        this.aracService = new AracService();
    }

    public Arac save(Arac arac) {
        return aracService.save(arac);
    }

    public Arac findById(Long id) {
        return aracService.findById(id);
    }

    public List<Arac> kiradakiAraclar() {
        return aracService.kiradakiAraclar();
    }

    public List<Arac> musaitAracler() {
        return aracService.musaitAraclar();
    }

}
