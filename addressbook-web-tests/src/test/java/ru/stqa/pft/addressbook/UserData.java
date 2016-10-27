package ru.stqa.pft.addressbook;

public class UserData {
  private final String firstname;
  private final String lastname;
  private final String address;
  private final String homenumber;
  private final String email;

  public UserData(String firstname, String lastname, String address, String homenumber, String email) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.address = address;
    this.homenumber = homenumber;
    this.email = email;
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
}
