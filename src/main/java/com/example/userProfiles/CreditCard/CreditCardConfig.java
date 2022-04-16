package com.example.userProfiles.CreditCard;

import com.example.userProfiles.userProfile.Profile;
import com.example.userProfiles.userProfile.ProfileRepository;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CreditCardConfig {

  Profile profile;
  ProfileRepository profileRepository;

  @Bean
  CommandLineRunner commandLineRunner2(CreditCardRepository creditCardRepository){
    return args -> {
      CreditCard card1 = new CreditCard(
              "9843126754328675",
              "9/2022",
              873
      );

      CreditCard card2 = new CreditCard(
              "0127532985473167",
              "03/2025",
              965
      );

      creditCardRepository.saveAll(List.of(card1, card2));
    };
  }

}
