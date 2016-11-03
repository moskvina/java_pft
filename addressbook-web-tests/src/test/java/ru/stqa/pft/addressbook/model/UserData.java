package ru.stqa.pft.addressbook.model;

public class UserData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String homenumber;
  private final String email;
  private String group;

  public UserData(String firstname, String lastname, String address, String homenumber, String email, String group) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homenumber = homenumber;
    this.email = email;
    this.group = group;
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public String getAddress() {
    return address;
  }

  public String getHomenumber() {
    return homenumber;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }
}
