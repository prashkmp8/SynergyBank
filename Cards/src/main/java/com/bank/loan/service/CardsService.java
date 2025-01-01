package com.bank.loan.service;

import com.bank.loan.constant.CardsConstants;
import com.bank.loan.dto.CardsDto;
import com.bank.loan.entity.Cards;
import com.bank.loan.entity.CardsType;
import com.bank.loan.exception.CardAlreadyExistsException;
import com.bank.loan.exception.ResourceNotFoundException;
import com.bank.loan.mapper.CardsMapper;
import com.bank.loan.repository.CardsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class CardsService {
    private CardsRepository cardsRepository;

    public CardsService(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    public void createCard(String mobileNumber)  {
        Optional<Cards> optionalCards= cardsRepository.findByMobileNumber(mobileNumber);
        if(optionalCards.isPresent()){
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber "+mobileNumber);
        }
        cardsRepository.save(createNewCard(mobileNumber));
    }
    private Cards createNewCard(String mobileNumber) {
        Cards newCard = new Cards();
        long randomCardNumber = 100000000000L + new Random().nextInt(900000000);
        newCard.setCardNumber(Long.toString(randomCardNumber));
        newCard.setMobileNumber(mobileNumber);
        newCard.setCardType(CardsType.CREDIT.name());
        newCard.setTotalLimit(CardsConstants.NEW_CARD_LIMIT);
        newCard.setUsedAmount(0L);
        newCard.setAvailableAmount(CardsConstants.NEW_CARD_LIMIT);
        return newCard;
    }

    public CardsDto fetchCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardsMapper.mapToCardsDto(cards, new CardsDto());
    }

    public Cards getCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return cards;
    }

    public boolean updateCard(CardsDto cardsDto) {
        Cards cards = cardsRepository.findByCardNumber(cardsDto.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardsDto.getCardNumber()));
        CardsMapper.mapToCards(cardsDto, cards);
        cardsRepository.save(cards);
        return  true;
    }
    public boolean deleteCard(String mobileNumber) {
        Cards cards = cardsRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardsRepository.deleteById(cards.getCordId());
        return true;
    }
}
