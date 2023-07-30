package com.onurbas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Kiralama {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Builder.Default
  private LocalDate kiralamaTarihi = LocalDate.now();
  private LocalDate kiralamaBitisTarihi;

  //sadece hesaplama için kullanılacağından Transient
  @Transient
  private int period;

  //Iki taraflı ilişki
  // Kiralama silindiğinde kişi silinmemesi için cascade remove hariç hepsi seçildi
  @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH} )
 // @ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
  private Kisi kisi;

  //Iki taraflı ilişki
  // Kiralama silindiğinde arac silinmemesi için cascade remove hariç hepsi seçildi
  @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
  //@ManyToOne(fetch = FetchType.LAZY,cascade =CascadeType.ALL)
  private Arac arac;

}
