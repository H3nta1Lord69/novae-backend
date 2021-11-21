package com.novae.back.service;

import com.novae.back.model.Card;

import java.util.List;
import java.util.Optional;

/**
 * System functionality
 */

public interface ICardService {

    public List<Card> findAll();

    public Card findCard(Card card);

    public Card findById(Long idCard);

    public Optional<Card> findCardById(Long idCard);

    public Card updateCard(Card card);

    public void deleteCard(Card card);

    public void deleteCard(Long idCard);



}
