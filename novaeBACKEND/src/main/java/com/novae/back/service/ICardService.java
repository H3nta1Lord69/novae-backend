package com.novae.back.service;

import com.novae.back.model.Card;

import java.util.List;
import java.util.Optional;

/**
 * System functionality
 */

public interface ICardService {

    /**
     * Methods and conditions for queries and searches
     */

    /**
     *
     * @return All the data from the db
     */
    public List<Card> findAll();

    /**
     *
     * @param card
     * @return save to update
     */
    public void save(Card card);

    /**
     *
     * @param card
     * @return find entry by num_card
     */
    public Card findCard(Card card);

    /**
     *
     * @param idCard
     * @return find entry by id_card
     */
    public Card findById(Long idCard);

    /**
     *
     * @param card
     * @return find entry by franchise
     */
    public Card findByFranchise(Card card);

    /**
     *
     * @param id
     * @return find entry from the foreign key by Id
     */
    public List<Card> getPersonCards(Long id);

    /**
     *
     * @param idCard
     * @return find entry by Id
     */
    public Optional<Card> findCardById(Long idCard);

    /**
     *
     * @param card
     * @return update entry in Card
     */
    public Card updateCard(Card card);

    /**
     *
     * @param card
     * @return delete entry by field
     */
    public void deleteCard(Card card);

    /**
     *
     * @param idCard
     * @return delete entry by id_card
     */
    public void deleteCard(Long idCard);

    /**
     *
     * @return delete all entries
     */
    public void deleteAllCard();

}
