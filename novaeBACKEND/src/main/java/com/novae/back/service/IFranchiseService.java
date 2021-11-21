package com.novae.back.service;

import com.novae.back.model.Franchise;

import java.util.List;
import java.util.Optional;

public interface IFranchiseService {

    public List<Franchise> findAll();

    public Franchise findFranchise(Franchise franchise);

    public Franchise findById(Long idFranchise);

    public Optional<Franchise> findFranchiseById(Long idFranchise);

    public Franchise updateFranchise(Franchise franchise);

    public void deleteFranchise(Franchise franchise);

    public void deleteFranchise(Long idFranchise);

}
