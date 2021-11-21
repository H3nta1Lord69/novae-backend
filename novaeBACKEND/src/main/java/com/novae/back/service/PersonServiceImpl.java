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

    @Autowired
    private IPersonDao iPersonDao;

    @Override
    @Transactional(readOnly = true)
    public List<Person> findAll() {
        return (List<Person>) iPersonDao.findAll();
    }

    @Override
    public void save(Person person) {
        iPersonDao.save(person);
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPersonByEmail(Person person) {
        return (Person) iPersonDao.findByEmail(person.getEmail());
    }

    @Override
    public Person checkPersonLogin(Person person) {
        return (Person) iPersonDao.findByEmailAndPassword(person.getEmail(), person.getPassword());
    }

    @Override
    @Transactional(readOnly = true)
    public Person findPerson(Person person) {
        return (Person) iPersonDao.findByUid(person.getUid());
    }

    @Override
    @Transactional(readOnly = true)
    public Person findById(Long idPerson) {
        return iPersonDao.findById(idPerson).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Person> findPersonById(Long idPerson) {
        return (Optional<Person>) iPersonDao.findById(idPerson);
    }

    @Override
    @Transactional
    public Person updatePerson(Person person) {
        return (Person) iPersonDao.save(person);
    }

    @Override
    @Transactional
    public void deletePerson(Person person) {
        iPersonDao.deleteById(person.getIdPerson());
    }

    @Override
    @Transactional
    public void deletePerson(Long idPerson) {
        iPersonDao.deleteById(idPerson);
    }

    @Override
    @Transactional
    public void deleteAllPerson() {
        iPersonDao.deleteAll();
    }
}
