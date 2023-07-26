package com.onurbas.repository.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(cascade = CascadeType.ALL)
    private Users users;

    @ManyToOne(cascade = CascadeType.ALL)
    private Book book;
    @Builder.Default
    private LocalDate borrowDate=LocalDate.now();

    @Transient
    private int period;
    private LocalDate returnDate;

}
