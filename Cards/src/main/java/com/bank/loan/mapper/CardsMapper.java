package com.bank.loan.mapper;

import com.bank.loan.dto.CardsDto;
import com.bank.loan.entity.Cards;

public class CardsMapper {
    public static CardsDto mapToCardsDto(Cards cards, CardsDto cardsDto) {
        cardsDto.setCardNumber(cards.getCardNumber());
        cardsDto.setCardType(cards.getCardType());
        cardsDto.setCardId(cardsDto.getCardId());
        cardsDto.setAvailableAmount(cards.getAvailableAmount());
        cardsDto.setMobileNumber(cards.getMobileNumber());
        cardsDto.setTotalLimit(cards.getTotalLimit());
        return cardsDto;
    }

    public static Cards mapToCards(CardsDto cardsDto, Cards cards) {
        cards.setCardNumber(cards.getCardNumber());
        cards.setCardType(cardsDto.getCardType());
        cards.setAvailableAmount(cardsDto.getAvailableAmount());
        cards.setUsedAmount(cardsDto.getUsedAmount());
        cards.setMobileNumber(cardsDto.getMobileNumber());
        cards.setTotalLimit(cardsDto.getTotalLimit());
        return cards;
    }
}
