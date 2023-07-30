package com.onurbas.repository;

import com.onurbas.entity.Arac;
import com.onurbas.entity.enums.EDurum;

import java.util.List;

public interface IAracRapor {
  List<Arac> aracDurumSorgu(EDurum eDurum);
  List<Arac> musterininKiraladigiArabalar(Long id);
}
