package com.novae.back.service;

import com.novae.back.model.Franchise;
import com.novae.back.repository.IFranchiseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FranchiseServiceImpl implements IFranchiseService {

    @Autowired
    private IFranchiseDao iFranchiseDao;


    @Override
    @Transactional(readOnly = true)
    public List<Franchise> findAll() {
        return (List<Franchise>) iFranchiseDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Franchise findFranchise(Franchise franchise) {
        return (Franchise) iFranchiseDao.findByName(franchise.getNameFranchise());
    }

    @Override
    @Transactional(readOnly = true)
    public Franchise findById(Long idFranchise) {
        return iFranchiseDao.findById(idFranchise).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Franchise> findFranchiseById(Long idFranchise) {
        return (Optional<Franchise>) iFranchiseDao.findById(idFranchise);
    }

    @Override
    @Transactional
    public Franchise updateFranchise(Franchise franchise) {
        return (Franchise) iFranchiseDao.save(franchise);
    }

    @Override
    @Transactional
    public void deleteFranchise(Franchise franchise) {
        iFranchiseDao.deleteById(franchise.getIdFranchise());
    }

    @Override
    @Transactional
    public void deleteFranchise(Long idFranchise) {
        iFranchiseDao.deleteById(idFranchise);
    }
}
