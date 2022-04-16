package com.example.userProfiles.userProfile;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//API Things
@RestController

//localhost8080 = localhost8080/api/userprofile
@RequestMapping(path = "api/userprofile")
public class ProfileController {

  private final ProfileService profileService;

  @Autowired
  public ProfileController(ProfileService profileService) {


    this.profileService = profileService;
  }

  //Get
  @GetMapping
  public List<Profile> getProfiles() {


    return profileService.getProfile();
  }


  @GetMapping("/{userName}")
  public List<Profile> getProfilesByUserName(@PathVariable String userName) {

    return profileService.getByUserName(userName);
  }

  //Post
  @PostMapping
  public void registerNewProfile(
      @RequestBody Profile profile) {   //Takes Postman Request-body JSON (?)

    profileService.createProfile(profile);
  }

  //Put
  @PutMapping(path = "/{userName}")
  public void updateProfile(
      @PathVariable String userName,
      @RequestParam(required = false) String password,
      @RequestParam(required = false) String name,
      @RequestParam(required = false) String optionalEmail,
      @RequestParam(required = false) String homeAddress)
  {
    profileService.updateInfo(userName, password, name, optionalEmail, homeAddress);
  }
}
