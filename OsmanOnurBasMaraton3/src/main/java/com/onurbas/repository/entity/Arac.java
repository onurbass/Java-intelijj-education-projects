package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EDurum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Arac {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aracId;
    private String marka;
    private String model;
    private int yil;

    @Builder.Default
    private EDurum eDurum=EDurum.KIRALANABILIR;


}
