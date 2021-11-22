package com.novae.back.service;

import com.novae.back.model.Person;
import com.novae.back.repository.IPersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    /**
     * Interface Injection
     */
    @Autowired
    private IPersonDao iPersonDao;

    /**
     *
     * Overrides the base class method
     * @return All the data from Person
     */
    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return (List<Person>) iPersonDao.findAll();
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return save entries
     */
    @Override
    public void save(Person person) {
        iPersonDao.save(person);
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return find entry by email
     */
    @Override
    @Transactional(readOnly = true)
    public Person findPersonByEmail(Person person) {
        return (Person) iPersonDao.findByEmail(person.getEmail());
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return login check method
     */
    @Override
    public Person checkPersonLogin(Person person) {
        return (Person) iPersonDao.findByEmailAndPassword(person.getEmail(), person.getPassword());
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return find entry by uid
     */
    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return (Person) iPersonDao.findByUid(person.getUid());
    }

    /**
     *
     * Overrides the base class method
     * @param idPerson
     * @return find entry by id_person
     */
    @Override
    @Transactional(readOnly = true)
    public Person findById(Long idPerson) {
        return iPersonDao.findById(idPerson).orElse(null);
    }

    /**
     *
     * Overrides the base class method
     * @param idPerson
     * @return find entry by id_person
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findPersonById(Long idPerson) {
        return (Optional<Person>) iPersonDao.findById(idPerson);
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return update entry in Person
     */
    @Override
    @Transactional
    public Person updatePerson(Person person) {
        return (Person) iPersonDao.save(person);
    }

    /**
     *
     * Overrides the base class method
     * @param person
     * @return delete entry by field
     */
    @Override
    @Transactional
    public void deletePerson(Person person) {
        iPersonDao.deleteById(person.getIdPerson());
    }

    /**
     *
     * Overrides the base class method
     * @param idPerson
     * @return delete entry by id_person
     */
    @Override
    @Transactional
    public void deletePerson(Long idPerson) {
        iPersonDao.deleteById(idPerson);
    }

    /**
     *
     * Overrides the base class method
     * @return delete all entries
     */
    @Override
    @Transactional
    public void deleteAllPerson() {
        iPersonDao.deleteAll();
    }
}
