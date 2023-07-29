package org.example.entity;

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
    private LocalDate kiralamaTarihi=LocalDate.now();

    private LocalDate kiralamaBitisTarihi;

    @Transient
    private int period;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Kisi kisi;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Arac arac;

}
