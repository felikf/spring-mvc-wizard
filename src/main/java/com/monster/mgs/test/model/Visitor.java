package com.monster.mgs.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VISITOR")
public class Visitor {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "VISITOR_ID")
  private Long id;

  @Column(name="FIRST_NAME", length = Constants.MAX_NAME_LENGTH, nullable = false)
  private String firstName;
  @Column(name="LAST_NAME", length = Constants.MAX_NAME_LENGTH, nullable = false)
  private String lastName;
  @Column(name="EMAIL_ADDRESS", length = Constants.MAX_EMAIL_LENGTH, nullable = false, unique = true)
  private String emailAddress;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmailAddress() {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress) {
    this.emailAddress = emailAddress;
  }
}
