package com.novae.back.service;

import com.novae.back.model.Card;
import com.novae.back.repository.ICardDao;
import com.novae.back.service.ICardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImpl implements ICardService {

    @Autowired
    private ICardDao iCardDao;

    @Override
    @Transactional(readOnly = true)
    public List<Card> findAll() {
        return (List<Card>) iCardDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Card findCard(Card card) {
        return (Card) iCardDao.findByNumCard(card.getNumCard());
    }

    @Override
    @Transactional(readOnly = true)
    public Card findById(Long idCard) {
        return iCardDao.findById(idCard).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Card> findCardById(Long idCard) {
        return (Optional<Card>) iCardDao.findById(idCard);
    }

    @Override
    @Transactional
    public Card updateCard(Card card) {
        return (Card) iCardDao.save(card);
    }

    @Override
    @Transactional
    public void deleteCard(Card card) {
        iCardDao.deleteById(card.getIdCard());
    }

    @Override
    @Transactional
    public void deleteCard(Long idCard) {
        iCardDao.deleteById(idCard);
    }
}
