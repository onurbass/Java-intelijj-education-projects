package com.onurbas.repository.entity;

import com.onurbas.repository.ICrud;
import com.onurbas.repository.enums.EAddress;
import com.onurbas.repository.enums.EGender;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import javax.persistence.*;
import java.util.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity

@Table(name= "tbl_user")

public class User implements ICrud<User> {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Embedded
    private Name name;
    @Column(nullable = false, unique = true)
    private String username;
    @Column(nullable = false,length = 32)

    private String password;
    @Transient
    private int age;
    @Enumerated(EnumType.STRING)
    private EGender gender;

    @ElementCollection
    @Builder.Default
    private  Set<String> ilgiAlanları=new HashSet<>();


    @ElementCollection
    @MapKeyEnumerated(EnumType.STRING)
    @Builder.Default
    private Map<EAddress, Address> adressler = new HashMap<>();

    @Override
    public User save(User user) {

        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }
}
