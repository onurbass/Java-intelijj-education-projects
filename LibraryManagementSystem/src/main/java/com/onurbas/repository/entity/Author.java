package com.onurbas.repository.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    // kitapları

    //ara tablo özelliklerini vermek için kullanıyoruz
//    @JoinTable(name = "yazar_kitap",
//    joinColumns = @JoinColumn(name = "kitap_id"),
//            inverseJoinColumns = @JoinColumn(name = "yazar_id")
//    )
    @OneToMany(mappedBy = "author", fetch = FetchType.EAGER)
    @ToString.Exclude
    List<Book> books;


}
