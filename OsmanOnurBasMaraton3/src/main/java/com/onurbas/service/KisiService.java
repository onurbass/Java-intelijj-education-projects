package com.onurbas.service;

import com.onurbas.repository.KisiRepository;
import com.onurbas.entity.Kisi;

import java.util.List;

public class KisiService {

  private KisiRepository kisiRepository;

  public KisiService() {
	this.kisiRepository = new KisiRepository();
  }

  public Kisi save(Kisi kisi) {
	return kisiRepository.save(kisi);
  }

  public Kisi findById(Long id) {
	return kisiRepository.findById(id);
  }
  public List<Kisi> findAll() {
	return kisiRepository.findAll();
  }
  public void update(Kisi kisi) {
	kisiRepository.update(kisi);
  }
}
