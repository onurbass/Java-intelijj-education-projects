package com.mimaraslan.controller;

import com.mimaraslan.model.Arac;
import com.mimaraslan.service.EvService;

import java.util.List;

public class EvController {

    private EvService evService;

    public EvController() {
        this.evService = new EvService();
    }

    public Arac evOlustur(Arac arac) {
        return evService.evOlustur(arac);
    }

    public Arac evAraById(Long id) {
        return evService.evAraById(id);
    }

    public List<Arac> kiradakiEvler() {
        return evService.kiradakiEvler();
    }

    public List<Arac> musaitEvler() {
        return evService.musaitEvler();
    }

}
