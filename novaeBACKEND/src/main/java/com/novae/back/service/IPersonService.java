package com.novae.back.service;

import com.novae.back.model.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonService {

    public List<Person> findAll();

    public Person findPerson(Person person);

    public Person findById(Long idPerson);

    public Optional<Person> findPersonById(Long idPerson);

    public Person updatePerson(Person person);

    public void deletePerson(Person person);

    public void deletePerson(Long idPerson);

}
