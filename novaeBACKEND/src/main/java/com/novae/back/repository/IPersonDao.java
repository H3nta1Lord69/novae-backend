package com.novae.back.repository;

import com.novae.back.model.Person;
import org.apache.catalina.LifecycleState;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object. To retrieve the information from the DB
 */
public interface IPersonDao extends CrudRepository<Person, Long> {

    /**
     *
     * @param uid
     * @return uid from Person
     */
    public Person findByUid(String uid);

    /**
     *
     * @param email
     * @return email from Person
     */
    public Person findByEmail(String email);

    /**
     *
     * @param email
     * @param password
     * @return Email & Password validation from Person
     */
    public Person findByEmailAndPassword(String email, String password);

    /**
     *
     * @param idPerson
     * @return id_person from Person
     */
    public Optional<Person> findById(Long idPerson);

}
