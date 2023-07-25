package com.onurbas.model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Kisi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kisiId;
    private Name name;
    @Column(name = "tc", unique = true, nullable = false, length = 15)
    private String tcKimlikNo;
    private String telefon;
    private Adres adres;

    @ToString.Exclude
    @OneToMany(mappedBy = "kiralayanKisi",cascade = CascadeType.ALL)
    @Builder.Default
    private List<Kiralama> kiralamList=new ArrayList<>();

}
