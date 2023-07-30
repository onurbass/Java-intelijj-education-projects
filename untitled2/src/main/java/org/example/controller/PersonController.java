package org.example.controller;

import org.example.entity.Person;
import org.example.repository.ICrud;
import org.example.service.PersonService;

public class PersonController {
    private PersonService personService;

    public PersonController() {
        this.personService = new PersonService();
    }
    public Person add(Person person) {
        return personService.add(person);
    }
    public Person search(Long id) {
        return personService.search(id);
    }

}
