package com.onurbas.repository.entity;

import lombok.*;

import javax.persistence.Embeddable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Embeddable
public class Name {
    private String firstName;
    private String middleName;
    private String lastName;


}

