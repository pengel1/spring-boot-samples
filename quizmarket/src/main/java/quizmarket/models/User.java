package quizmarket.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Table(name="user")
@JsonIgnoreProperties(value = { "token", "email" })
public class User implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Column(name="first_name")
  @Size(min = 3, max = 80)
  private String firstName;

  @NotNull
  @Size(min = 3, max = 80)
  @Column(name="last_name")
  private String lastName;

  @NotNull
  @Column(name="email")
  @Size(min = 2, max = 80)
  private String email;

  @NotNull
  @Column(name="image")
  @Size(min = 2, max = 255)
  private String image;

  @NotNull
  @Column(name="token")
  @Size(min = 2, max = 255)
  private String token;

  public User() { }

  public User(long id) {
    this.id = id;
  }

  public User(String firstName, String lastName, String token, String email, String image) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.image = image;
    this.token = token;
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

  public String getImage() { return image; }

  public void setImage(String image) { this.image = image; }

  public String getToken() {
    return this.token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Collection<? extends GrantedAuthority> getAuthorities(){
    return null;
  }

  public String getPassword(){
    return token;
  }

  public String getUsername(){
    return email;
  }

  public boolean isAccountNonExpired(){
    return true;
  }

  public boolean isAccountNonLocked(){
    return true;
  }

  public boolean isCredentialsNonExpired(){
    return true;
  }

  public boolean isEnabled(){
    return true;
  }


} // class User
