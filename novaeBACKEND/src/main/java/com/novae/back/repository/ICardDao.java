package com.novae.back.repository;

import com.novae.back.model.Card;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Data Access Object. To retrieve the information from the DB
 */

public interface ICardDao extends CrudRepository<Card, Long> {

    /**
     *
     * @param numCard
     * @return num_card from Card
     */
    public Card findByNumCard(String numCard);

    /**
     *
     * @param franchise
     * @return franchise from Card
     */
    public Card findByFranchise(String franchise);

    /**
     *
     * @param idCard
     * @return Id from Card
     */
    public Optional<Card> findById(Long idCard);

    /**
     *
     * @param id
     * @return id_person from Person
     */
    public List<Card> findByPersonId(Long id);

}