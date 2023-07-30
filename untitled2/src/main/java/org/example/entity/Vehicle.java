package org.example.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.entity.Enums.EVehicleStatus;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "marka")
    private String brand;
    @Column(name = "model")
    private String model;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    private EVehicleStatus status = EVehicleStatus.AVAILABLE;
}
