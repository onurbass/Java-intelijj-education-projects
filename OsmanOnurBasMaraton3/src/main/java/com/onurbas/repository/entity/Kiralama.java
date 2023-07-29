package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EDurum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
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
    private LocalDate kiralamaTarihi;
    private int period;
    private double gunlukKiralamaUcreti;

    @ManyToOne
    @JoinColumn(name = "kisi_id")
    private Kisi kiralayanKisi; // Kisi sınıfından referans

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arac_id") // Kiralanan araca dair referans için yabancı anahtar sütunu belirleme
    private Arac kiralananArac;

}
