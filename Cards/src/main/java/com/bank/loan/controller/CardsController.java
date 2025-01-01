package com.bank.loan.controller;

import com.bank.loan.constant.CardsConstants;
import com.bank.loan.dto.CardsDto;
import com.bank.loan.dto.ResponseDto;
import com.bank.loan.entity.Cards;
import com.bank.loan.mapper.CardsMapper;
import com.bank.loan.service.CardsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/bank/cards")
@Tag(
      name="Cards rest service which used to create crud functionalities",
      description = "Cards rest service which used to create crud functionalities"
)
public class CardsController {

    private CardsService cardsService;

    public CardsController(CardsService cardsService) {
        this.cardsService = cardsService;
    }

    @PostMapping
    @Operation(
            description = "method is used to create cards"
    )
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "created new cards based on mobile number")
    )
    public ResponseEntity<ResponseDto> createCards(@RequestParam String mobileNumber) {
        cardsService.createCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(CardsConstants.MESSAGE_201,HttpStatus.CREATED)
        );
    }

    @GetMapping
    @Operation(
            description = "method is used to fetch each card associated with mobile number"
    )
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "fetched cards with mobile number")
    )
    public ResponseEntity<CardsDto> getCards(@RequestParam String mobileNumber) {
        CardsDto cards= cardsService.fetchCard(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(cards);
    }

    @PutMapping
    @Operation(
            description = "method is used to update each card associated with mobile number"
    )
    @ApiResponses(
            @ApiResponse(responseCode = "200", description = "modified cards with mobile number")
    )
    public ResponseEntity<ResponseDto> getCards(@RequestBody CardsDto cardsDto,@RequestParam String mobileNumber) {
        Cards cards= cardsService.getCard(mobileNumber);
        boolean isUpdated= cardsService.updateCard(CardsMapper.mapToCardsDto(cards,new CardsDto()));
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(CardsConstants.MESSAGE_200,HttpStatus.OK));
    }
}
