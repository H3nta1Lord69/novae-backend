package com.novae.back.service;

import com.novae.back.model.Person;

import java.util.List;
import java.util.Optional;

/**
 * System functionality
 */

public interface IPersonService {

    /**
     * Methods and conditions for queries and searches
     */

    /**
     *
     * @return All the data from Person
     */
    public List<Person> findAll();

    /**
     *
     * @param person
     * @return save entries
     */
    public void save(Person person);

    /**
     *
     * @param person
     * @return find entry by email
     */
    public Person findPersonByEmail(Person person);

    /**
     *
     * @param person
     * @return login check method
     */
    public Person checkPersonLogin(Person person);

    /**
     *
     * @param person
     * @return find entry by uid
     */
    public Person findPerson(Person person);

    /**
     *
     * @param idPerson
     * @return find entry by id_person
     */
    public Person findById(Long idPerson);

    /**
     *
     * @param idPerson
     * @return find entry by id_person
     */
    public Optional<Person> findPersonById(Long idPerson);

    /**
     *
     * @param person
     * @return update entry in Person
     */
    public Person updatePerson(Person person);

    /**
     *
     * @param person
     * @return delete entry by field
     */
    public void deletePerson(Person person);

    /**
     *
     * @param idPerson
     * @return delete entry by id_person
     */
    public void deletePerson(Long idPerson);

    /**
     *
     * @return delete all entries
     */
    public void deleteAllPerson();

}
