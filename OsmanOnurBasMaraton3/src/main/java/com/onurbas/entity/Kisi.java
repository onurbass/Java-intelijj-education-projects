package com.onurbas.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Kisi {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private Name name;

  //Ayırt edici özellik olarak tc belirlendi -unique = true, nullable = false
  @Column(name = "tc", unique = true, nullable = false, length = 15)
  private String tcNo;


  @ToString.Exclude
  @OneToMany(mappedBy = "kisi", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Kiralama> kiralamaList;
}
