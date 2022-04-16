package com.example.userProfiles.CreditCard;


import com.example.userProfiles.userProfile.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//API things
@RestController

//localhost8080 = localhost8080/api/creditcard
@RequestMapping(path = "api/creditcard")
public class CreditCardController {

  @Autowired
  ProfileRepository profileRepository;
  @Autowired
  CreditCardRepository creditCardRepository;

  private final CreditCardService creditCardService;

  @Autowired
  public CreditCardController(CreditCardService creditCardService) {

    this.creditCardService = creditCardService;
  }

  //Get
  @GetMapping
  public List<CreditCard> getCard() {

    return creditCardService.getCard();
  }

  //Post
  @PostMapping("/registerCard")
  public void makeNewCard(@RequestBody CreditCard creditCard) {

    creditCardService.addNewCreditCard(creditCard);
  }

  //Put
  @PutMapping("/{cardId}/{profileId}")
  public CreditCard cardToProfile(
      @PathVariable Long cardId,
      @PathVariable Long profileId
  ) {
    return creditCardService.assignCreditCardToProfile(cardId, profileId);
  }

}