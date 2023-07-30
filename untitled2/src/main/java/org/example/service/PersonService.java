package org.example.service;

import org.example.entity.Person;
import org.example.repository.PersonRepository;
import org.example.repository.VehicleRepository;
import org.example.utility.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PersonService {
private PersonRepository personRepository;
    public PersonService() {
        this.personRepository = new PersonRepository();
    }

    public Person add(Person person) {
        return personRepository.add(person);
    }
    public Person search(Long id) {
       return personRepository.search(id);
    }

}
