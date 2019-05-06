package quizmarket;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import quizmarket.controllers.QuizController;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(QuizController.class)
@EnableJpaRepositories("quizmarket")
public class QuizTest {

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void testGetAllQuizzes() throws Exception {
        this.mockMvc.perform(get("/quiz/")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Quiz 1")));
    }

}