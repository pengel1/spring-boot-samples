package quizmarket;

import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication

@ComponentScan("quizmarket")
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

}
