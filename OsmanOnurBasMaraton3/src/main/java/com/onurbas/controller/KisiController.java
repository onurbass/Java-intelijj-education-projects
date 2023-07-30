package com.onurbas.controller;

import com.onurbas.entity.Kisi;
import com.onurbas.service.KisiService;

import java.util.List;

public class KisiController {

  private KisiService kisiService;

  public KisiController() {

	this.kisiService = new KisiService();
  }

  public Kisi save(Kisi kisi) {
	return kisiService.save(kisi);
  }

  public Kisi kisiAraById(Long id) {
	return kisiService.kisiAraById(id);
  }
  public List<Kisi> findAll() {
	return kisiService.findAll();
  }
}
