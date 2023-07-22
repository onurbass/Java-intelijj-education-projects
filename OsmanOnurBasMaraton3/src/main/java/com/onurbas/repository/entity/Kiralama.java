package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EDurum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Kiralama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int kiralamaId;
    private Date kiralamaTarihi;
    private Date kiralamaBitisTarihi;
    private double gunlukKiralamaUcreti;
    private EDurum eDurum;


    @ManyToOne
    @JoinColumn(name = "kisi_id")
    private Kisi kiralayanKisi; // Kisi sınıfından referans

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arac_id") // Kiralanan araca dair referans için yabancı anahtar sütunu belirleme
    private Arac arac;

}
