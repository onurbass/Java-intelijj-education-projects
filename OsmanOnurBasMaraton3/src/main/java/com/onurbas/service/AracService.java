package com.onurbas.service;

import com.onurbas.entity.enums.EDurum;
import com.onurbas.repository.AracRepository;
import com.onurbas.entity.Arac;
import com.onurbas.repository.IAracRapor;

import java.util.List;

public class AracService  {

  private AracRepository aracRepository;

  public AracService() {
	this.aracRepository = new AracRepository();
  }

  public Arac save(Arac arac) {
	// Sase numarasının unique olup olmadığını kontrol et
//	if (aracRepository.aracKayitliMi(arac.getSaseNo())) {
//	  System.out.println("Bu sase numarası zaten kayıtlı: " + arac.getSaseNo());
//	  return arac;
//	}
	// Diğer gerekli işlemleri yap ve aracı kaydet
	aracRepository.save(arac);
	System.out.println("Araç başarıyla kaydedildi.");
	return arac;
  }
  public void update(Arac arac) {
	aracRepository.update(arac);
  }
  public Arac findById(Long id) {
	return aracRepository.findById(id);
  }
  public List<Arac> findAll() {
	return aracRepository.findAll();
  }


  public List<Arac> aracDurumSorgu(EDurum eDurum) {

	return aracRepository.aracDurumSorgu(eDurum);
  }


  public List<Arac> musterininKiraladigiArabalar(Long id) {
	return aracRepository.musterininKiraladigiArabalar(id);
  }
}

