package com.example.userProfiles.CreditCard;

import com.example.userProfiles.userProfile.Profile;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class CreditCard {

  @Id
  @SequenceGenerator(
      name = "card_sequence",
      sequenceName = "card_sequence",
      allocationSize = 1
  )
  @GeneratedValue(
      strategy = GenerationType.SEQUENCE,
      generator = "card_sequence"
  )
  private Long cardId;
  private String number;
  private String expiration;
  private int securityCode;


  @ManyToOne(
      cascade = CascadeType.ALL
  )
  @JoinColumn(
      name = "profile_id",
      referencedColumnName = "id"
  )
  private Profile profile;


  //Constructors
  public CreditCard() {
  }

  //The one that is actually called
  public CreditCard(String number, String expiration, int securityCode) {
    this.number = number;
    this.expiration = expiration;
    this.securityCode = securityCode;
  }

  //With id
  public CreditCard(Long cardId, String number, String expiration, int securityCode) {
    this.cardId = cardId;
    this.number= number;
    this.expiration = expiration;
    this.securityCode = securityCode;
  }

  //No id
  public CreditCard(String number, String expiration, int securityCode,
      Profile profile) {
    this.number = number;
    this.expiration = expiration;
    this.securityCode = securityCode;
    this.profile = profile;
  }

  @Override
  public String toString() {
    return "CreditCard{" +
        "cardId=" + cardId +
        ", CardNumber=" + number +
        ", expirationDate='" + expiration + '\'' +
        ", SecurityCode=" + securityCode +
        '}';
  }

  //Getters
  public Long getCardId() {

    return cardId;
  }

  public String getNumber() {

    return number;
  }

  public String getExpiration() {

    return expiration;
  }

  public int getSecurityCode() {

    return securityCode;
  }

  public Profile getProfile() {

    return profile;
  }


  //Setters
  public void setId(Long cardId) {

    this.cardId = cardId;
  }

  public void setCreditCardNum(String number) {

    this.number = number;
  }

  public void setExpirationDate(String expiration)
  {

    this.expiration= expiration;
  }

  public void setCVV(int securityCode) {

    this.securityCode = securityCode;
  }

  public void assignProfile(Profile profile){

    this.profile = profile;
  }

}
