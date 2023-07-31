package com.onurbas.controller;

import com.onurbas.entity.Arac;
import com.onurbas.entity.Kiralama;
import com.onurbas.service.KiralamaService;

import java.util.List;

public class KiralamaController {

  private KiralamaService kiralamaService;

  public KiralamaController() {
	this.kiralamaService = new KiralamaService();
  }

  public Kiralama save(Kiralama kiralama) {
	kiralamaService.setKiralamaBitisTarihi(kiralama);
	return kiralamaService.save(kiralama);
  }

  public List<Kiralama> findAll() {
	return kiralamaService.findAll();
  }

  public void update(Kiralama kiralama) {
	kiralamaService.update(kiralama);
  }

  public Kiralama findById(Long id) {
	return kiralamaService.findById(id);
  }

}
