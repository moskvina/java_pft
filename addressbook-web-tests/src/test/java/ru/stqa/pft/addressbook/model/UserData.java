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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    UserData userData = (UserData) o;

    if (firstname != null ? !firstname.equals(userData.firstname) : userData.firstname != null) return false;
    return lastname != null ? lastname.equals(userData.lastname) : userData.lastname == null;

  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "UserData{" +
            "firstname='" + firstname + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';


  }
}
