package quizmarket.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="catalog")
public class Catalog {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Size(min = 3, max = 80)
  private String description;

  @NotNull
  @Size(min = 2, max = 80)
  private String name;

  public Catalog() { }

  public Catalog(long id) {
    this.id = id;
  }

  public Catalog(String name, String description) {
    this.description = description;
    this.name = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getName() {
    return this.name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
} // class Catalog
