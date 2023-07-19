package com.onurbas.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "CUSTOMER")
public class Customer {
    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private CustomerDetail customerDetail;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", nullable = false)
    private int id;

    @Column(name = "TITLE", length = 25)
    private String title;

    @Column(name = "FIRST_NAME", length = 40, nullable = false)
    private String firstname;

    @Column(name = "LAST_NAME", length = 60)
    private String lastname;


}
