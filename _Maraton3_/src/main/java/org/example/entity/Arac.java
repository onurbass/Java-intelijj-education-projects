package org.example.entity;

import lombok.*;
import org.example.entity.enums.EDurum;
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

    @Column(name = "sase_no" ,unique = true,nullable = false)
    private String saseNo;


    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EDurum durum = EDurum.MUSAIT;

    @ToString.Exclude
    @OneToMany(mappedBy = "arac", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Kiralama> kiralamaList;

}
