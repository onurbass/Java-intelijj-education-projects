package com.onurbas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Kiralama {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kiralamaId;
    @Builder.Default
    private LocalDate kiralamaTarihi=LocalDate.now();
    private int periyotYil;
    private double aylikKira;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "kisi_id")
    private Kisi kiralayanKisi;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "arac_id")
    private Ev ev;

}
