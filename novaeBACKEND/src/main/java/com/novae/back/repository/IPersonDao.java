package com.novae.back.repository;

import com.novae.back.model.Person;
import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IPersonDao extends CrudRepository<Person, Long> {

    public Person findByUid(String uid);

    public Person findByEmail(String email);

    public Person findByEmailAndPassword(String email, String password);

    public Optional<Person> findById(Long idPerson);

}
