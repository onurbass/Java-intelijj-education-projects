package com.onurbas.repository.entity;

import com.onurbas.repository.enums.EBookTypes;
import com.onurbas.repository.enums.EStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    @Enumerated(EnumType.STRING)
    private EBookTypes bookType;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private EStatus status = EStatus.AVAILABLE;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;

}
