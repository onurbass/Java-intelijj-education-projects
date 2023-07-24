package com.onurbas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private int kisiId;
    private Name name;
    @Column(name = "tc",unique = true,nullable = false,length = 15)
    private String tcKimlikNo;
    private String telefon;
    private Adres adres;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "kiralayanKisi")
    @Builder.Default
    private List<Kiralama> kiralama = new ArrayList<>();
}
