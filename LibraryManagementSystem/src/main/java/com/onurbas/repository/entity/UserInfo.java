package com.onurbas.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    @Transient
    private String about;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private Set<Address> address;

}
