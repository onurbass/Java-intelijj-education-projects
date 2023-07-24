package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EBookTypes;
import com.onurbas.repository.enums.EStatus;
import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private int pageCount;
    @Enumerated(EnumType.STRING)
    private EBookTypes bookType;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.AVAILABLE;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    @ToString.Exclude
    private Author author;

}
