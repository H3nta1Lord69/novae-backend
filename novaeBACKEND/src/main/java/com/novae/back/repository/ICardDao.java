package com.novae.back.repository;

import com.novae.back.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// DAO Object to access and save the data

public interface ICardDao extends CrudRepository<Card, Long> {

    public Card findByNumCard(String numCard);

    public Card findByFranchise(String franchise);

    public Optional<Card> findById(Long idCard);

    public List<Card> findByPersonId(Long id);

}