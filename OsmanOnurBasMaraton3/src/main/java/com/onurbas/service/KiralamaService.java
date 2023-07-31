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
  //period, kiralama tarihine eklenerek bitiş tarihi auto hesaplandı
  public void setKiralamaBitisTarihi(Kiralama kiralama) {
	kiralama.setKiralamaBitisTarihi(kiralama.getKiralamaTarihi().plusDays(kiralama.getPeriod()));
  }

  public Kiralama save(Kiralama kiralama) {
	return kiralamaRepository.save(kiralama);
  }

  public List<Kiralama> findAll() {
	return kiralamaRepository.findAll();
  }
  public void update(Kiralama kiralama) {
	kiralamaRepository.update(kiralama);
  }
  public Kiralama findById(Long id) {
	return kiralamaRepository.findById(id);
  }
}
