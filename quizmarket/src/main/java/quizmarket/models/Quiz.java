package quizmarket.models;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="quiz")
public class Quiz {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotNull
  @Size(min = 3, max = 80)
  private String title;

  @NotNull
  @Size(min = 3, max = 255)
  private String description;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name="author_id", nullable=false)
  private User author;

  @OneToMany(
      mappedBy = "quiz", fetch = FetchType.EAGER,
      cascade = CascadeType.ALL,
      orphanRemoval = true
  )
  private List<Question> questions = new ArrayList<>();

  public Quiz() { }

  public Quiz(long id) {
    this.id = id;
  }

  public Quiz(String name, String description) {
    this.description = description;
    this.title = name;
  }

  public long getId() {
    return id;
  }

  public void setId(long value) {
    this.id = value;
  }

  public String getTitle() {
    return this.title;
  }
  
  public void setTitle(String name) {
    this.title = title;
  }
  
  public String getDescription() {
    return this.description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public User getAuthor() { return author; }

  public void setAuthor(User author) { this.author = author; }

  public List<Question> getQuestions() { return questions; }

  public void setQuestions(List<Question> questions) { this.questions = questions; }
  
} // class Quiz
