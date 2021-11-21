package com.novae.back.repository;

import com.novae.back.model.Franchise;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IFranchiseDao extends CrudRepository<Franchise, Long> {

    public Franchise findByName(String name);

    public Optional<Franchise> findById(Long idFranchise);

}
