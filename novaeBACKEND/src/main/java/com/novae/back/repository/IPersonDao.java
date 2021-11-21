package com.novae.back.repository;

import com.novae.back.model.Person;
import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonDao extends CrudRepository<Person, Long> {

    public Person findByUID(String uid);

    public List<Person> findByName(String namePerson);

    public Optional<Person> findById(Long idPerson);

}
