package com.onurbas.controller;

import com.onurbas.entity.Arac;
import com.onurbas.entity.enums.EDurum;
import com.onurbas.service.AracService;

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

  public void update(Arac arac) {
	aracService.update(arac);
  }
  public List<Arac> findAll() {
	return aracService.findAll();
  }

  public List<Arac> aracDurumSorgu(EDurum eDurum) {
	return aracService.aracDurumSorgu(eDurum);
  }
  public List<Arac> musterininKiraladigiArabalar(Long id){

	return aracService.musterininKiraladigiArabalar(id);
  }


}
