package com.onurbas.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

//Name classı Kisi classına embeddable olarak setlendi
@Embeddable
public class Name {
  private String firstName;
  private String lastName;
}
