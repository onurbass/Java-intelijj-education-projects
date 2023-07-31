package com.onurbas.entity;

import lombok.*;
import com.onurbas.entity.enums.EDurum;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Arac {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "marka")
  private String marka;

  @Column(name = "model")
  private String model;

  //Ayırt edici özellik olarak saseNo belirlendi -unique = true, nullable = false
  @Column(name = "sase_no", unique = true, nullable = false)
  private String saseNo;

  @Builder.Default
  @Enumerated(EnumType.STRING)
  @Column(name = "durum")
  private EDurum durum = EDurum.MUSAIT;

  //Iki taraflı ilişki. Kiralama classına maplendi.
  // Araca yapılan işlem kiralamayı etkilemesi için cascadeType.all olarak setlendi
  @ToString.Exclude
  @OneToMany(mappedBy = "arac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Kiralama> kiralamaList;

}
