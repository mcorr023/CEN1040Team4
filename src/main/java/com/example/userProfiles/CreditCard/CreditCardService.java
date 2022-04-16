package com.example.userProfiles.CreditCard;

import com.example.userProfiles.userProfile.Profile;
import com.example.userProfiles.userProfile.ProfileRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditCardService {

  private final ProfileRepository profileRepository;
  private final CreditCardRepository creditCardRepository;


  @Autowired
  public CreditCardService(ProfileRepository profileRepository,
      CreditCardRepository creditCardRepository) {
    this.profileRepository = profileRepository;
    this.creditCardRepository = creditCardRepository;
  }

  //For Get
  public List<CreditCard> getCard(){

    return creditCardRepository.findAll();
  }

  //For Post
  public void addNewCreditCard(CreditCard creditCard){

    creditCardRepository.save(creditCard);

    System.out.println(creditCard);
  }

  public CreditCard assignCreditCardToProfile(Long cardId, Long profileId){

    CreditCard creditCard = creditCardRepository.findById(cardId).get();
    Profile profile = profileRepository.findById(profileId).get();

    creditCard.assignProfile(profile);

    return creditCardRepository.save(creditCard);

  }

}

