package com.example.userProfiles.userProfile;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class ProfileService {

  private final ProfileRepository profileRepository;

  @Autowired
  public ProfileService(ProfileRepository profileRepository) {

    this.profileRepository = profileRepository;
  }

  //Returns all profiles in list format
  public List<Profile> getProfile() {

    return profileRepository.findAll();
  }

  //Returns all users matching with the same username in list format
  public List<Profile> getByUserName(String userName) {

    return profileRepository.findByUserName(userName);

  }

  //Makes new profile
  public void createProfile(Profile profile) {

    Optional<Profile> profileByUserName = profileRepository
        .findByName(profile.getUserName());

    //Checks to see if username exists
    if (profileByUserName.isPresent()) {
      throw new IllegalStateException("Error: User name is already taken!");
    }

    profileRepository.save(profile);

    System.out.println(profile);
  }

  //Updates User Profile information
  @Transactional
  public void updateInfo(String userName, String password, String name, String optionalEmail, String homeAddress) {

    Profile profile = profileRepository.findUserByName(userName);

    //Password
    if (password != null && password.length() > 0 &&
        !Objects.equals(profile.getPassword(), password)) {
      profile.setPassword(password);
    }

    //Name
    if (name != null && name.length() > 0 && !Objects.equals(profile.getName(), name)) {

      profile.setName(name);
    }

    //Optional email
    if (optionalEmail != null && optionalEmail.length() > 0 &&
        !Objects.equals(profile.getOptionalEmail(), optionalEmail)) {
      profile.setOptionalEmail(optionalEmail);
    }

    //Home address
    if (homeAddress != null && homeAddress.length() > 0 &&
        !Objects.equals(profile.getHomeAddress(), homeAddress)) {
      profile.setHomeAddress(homeAddress);
    }

  }
}
