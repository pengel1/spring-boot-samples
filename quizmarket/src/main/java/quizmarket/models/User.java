package quizmarket.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Size(min = 3, max = 80)
  private String firstName;

  @NotNull
  @Size(min = 3, max = 80)
  private String lastName;

  @NotNull
  @Size(min = 2, max = 80)
  private String email;

  @NotNull
  @Size(min = 2, max = 255)
  private String image;

  public User() { }

  public User(long id) {
    this.id = id;
  }

  public User(String firstName, String lastName, String email, String image) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.image = image;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
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

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }
  
} // class Catalog
