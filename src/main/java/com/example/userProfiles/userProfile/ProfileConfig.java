package com.example.userProfiles.userProfile;

import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProfileConfig {

  //Includes sample user profiles (AmigosCode)
  @Bean
  CommandLineRunner commandLineRunner(ProfileRepository profileRepository) {
    return args -> {
      Profile user1 = new Profile(
              "achac040@fiu.edu",
              "GoPanthers!",
              "Amanda Chacin-Livinalli",
              "ambchacin@gmail.com",
              "11200 SW 8th St, Miami, FL 33199"
      );

      Profile user2 = new Profile(
              "fernando200@fiu.edu",
              "secondUser",
              "Fernando Collante",
              "fernandoFernando.com",
              "3000 NE 151st St, North Miami, FL 33181"
      );

      profileRepository.saveAll(List.of(user1, user2));

    };

  }
}
