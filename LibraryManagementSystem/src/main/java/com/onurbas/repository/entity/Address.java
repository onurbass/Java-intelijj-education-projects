package com.onurbas.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private  String country;
    private String city;

    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "address")
    @Builder.Default
    private Set<UserInfo> userInfos=new HashSet<>();
}
