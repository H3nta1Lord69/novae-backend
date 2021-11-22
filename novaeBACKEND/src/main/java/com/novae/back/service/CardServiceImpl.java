package com.novae.back.service;

import com.novae.back.model.Card;
import com.novae.back.repository.ICardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements ICardService {

    /**
     * Interface Injection
     */
    @Autowired
    private ICardDao iCardDao;

    /**
     *
     * Overrides the base class method
     * @return All the data from Card
     */
    @Override
    @Transactional(readOnly = true)
    public List<Card> findAll() {
        return (List<Card>) iCardDao.findAll();
    }

    /**
     *
     * Overrides the base class method
     * @param card
     * @return save entries
     */
    @Override
    @Transactional
    public void save(Card card) {
        iCardDao.save(card);
    }

    /**
     *
     * Overrides the base class method
     * @param card
     * @return find entry by num_card
     */
    @Override
    @Transactional(readOnly = true)
    public Card findCard(Card card) {
        return (Card) iCardDao.findByNumCard(card.getNumCard());
    }

    /**
     *
     * Overrides the base class method
     * @param idCard
     * @return find entry by id_card
     */
    @Override
    @Transactional(readOnly = true)
    public Card findById(Long idCard) {
        return iCardDao.findById(idCard).orElse(null);
    }

    /**
     *
     * Overrides the base class method
     * @param card
     * @return find entry by franchise
     */
    @Override
    @Transactional(readOnly = true)
    public Card findByFranchise(Card card) {
        return (Card) iCardDao.findByFranchise(card.getFranchise());
    }

    /**
     *
     * Overrides the base class method
     * @param id
     * @return find entry from the foreign key by Id
     */
    @Override
    @Transactional
    public List<Card> getPersonCards(Long id) {
        return (List<Card>) iCardDao.findByPersonId(id);
    }

    /**
     *
     * Overrides the base class method
     * @param idCard
     * @return find entry by Id
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<Card> findCardById(Long idCard) {
        return (Optional<Card>) iCardDao.findById(idCard);
    }

    /**
     *
     * Overrides the base class method
     * @param card
     * @return update entry in Card
     */
    @Override
    @Transactional
    public Card updateCard(Card card) {
        return (Card) iCardDao.save(card);
    }

    /**
     *
     * Overrides the base class method
     * @param card
     * @return delete entry by field
     */
    @Override
    @Transactional
    public void deleteCard(Card card) {
        iCardDao.deleteById(card.getIdCard());
    }

    /**
     *
     * Overrides the base class method
     * @param idCard
     * @return delete entry by id_card
     */
    @Override
    @Transactional
    public void deleteCard(Long idCard) {
        iCardDao.deleteById(idCard);
    }

    /**
     *
     * Overrides the base class method
     * @return delete all entries
     */
    @Override
    @Transactional
    public void deleteAllCard() {
        iCardDao.deleteAll();
    }
}
