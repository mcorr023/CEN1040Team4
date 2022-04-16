package com.example.userProfiles.userProfile;

import com.example.userProfiles.CreditCard.CreditCard;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table
public class Profile {

  @Id
  @SequenceGenerator(
      name = "profile_sequence",
      sequenceName = "profile_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "profile_sequence"
  )
  private Long id;                //To identify users in database
  private String userName;        //Email Username
  private String password;        //User password
  private String name;            //Name
  private String optionalEmail;   //Optional email address
  private String homeAddress;     //Home address


  //Constructors
  public Profile() {
  }

  //No id
  public Profile(String userName, String password) {
    this.userName = userName;
    this.password = password;
  }

  //With id
  public Profile(Long id, String userName, String password) {
    this.id = id;
    this.userName = userName;
    this.password = password;
  }

  //The one that is actually called
  public Profile(String userName, String password, String name, String optionalEmail, String homeAddress) {
    this.userName = userName;
    this.password = password;
    this.name = name;
    this.optionalEmail = optionalEmail;
    this.homeAddress = homeAddress;
  }


  @JsonIgnore
  @OneToMany(
      mappedBy = "profile"
  )

  //Credit Card
  private Set<CreditCard> card = new HashSet<>();

  //toString
  @Override
  public String toString() {
    return "Profile{" +
        "id=" + id +
        ", userName='" + userName + '\'' +
        ", password='" + password + '\'' +
        ", Name='" + name + '\'' +
        ", OptionalEmail='" + optionalEmail + '\'' +
        '}';
  }


  //Getters
  public Long getId() {

    return id;
  }

  public String getUserName() {

    return userName;
  }

  public String getPassword() {

    return password;
  }

  public String getName() {

    return name;
  }

  public String getOptionalEmail() {

    return optionalEmail;
  }

  public String getHomeAddress() {

    return homeAddress;
  }

  public Set<CreditCard> getCard() {

    return card;
  }


  //Setters
  public void setId(Long id) {

    this.id = id;
  }

  public void setUserName(String userName) {

    this.userName = userName;
  }

  public void setPassword(String password) {

    this.password = password;
  }

  public void setName(String name) {

    this.name = name;
  }

  public void setOptionalEmail(String optionalEmail) {

    this.optionalEmail = optionalEmail;
  }

  public void setHomeAddress(String homeAddress) {

    this.homeAddress = homeAddress;
  }
}
