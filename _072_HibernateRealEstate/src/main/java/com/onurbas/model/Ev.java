package com.onurbas.model;

import com.onurbas.repository.enums.EDurum;
import lombok.*;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class Ev {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long evId;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EDurum eDurum=EDurum.KIRALANABILIR;



}
