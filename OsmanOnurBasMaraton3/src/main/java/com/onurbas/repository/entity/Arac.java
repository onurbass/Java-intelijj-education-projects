package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EDurum;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
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
    @Enumerated(EnumType.STRING)
    private EDurum eDurum=EDurum.KIRALANABILIR;


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Arac{");
        sb.append("aracId=").append(aracId);
        sb.append(", marka='").append(marka).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", yil=").append(yil);
        sb.append(", eDurum=").append(eDurum);
        sb.append('}');
        return sb.toString();
    }
}
