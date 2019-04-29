package quizmarket;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import quizmarket.controllers.LoginController;

@RunWith(SpringRunner.class)
@WebMvcTest(LoginController.class)
public class LoginTest {

    @Autowired
    private MockMvc mockMvc;

    private String testToken = "asdofadslfjadsofiasjfi34j4j34fjjafasiofjsaoe";

    @Test
    public void testSignUp() throws Exception {
        this.mockMvc.perform(post("/signup")
                .param("first_name", "John")
                .param("last_name", "Doe")
                .param("token", testToken)
                .param("email", "John@gmail.com")
                .param("image", "http://image.com/123")).andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().string(containsString("1")));
    }

    @Test
    public void testLogin() throws Exception {
        this.mockMvc.perform(post("/signup")
                .param("first_name", "John")
                .param("last_name", "Doe")
                .param("token", testToken)
                .param("email", "John@gmail.com")
                .param("image", "http://image.com/123")).andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().string(containsString("1")));

        this.mockMvc.perform(post("/login")
                .param("token", testToken)
                .param("email", "John@gmail.com")).andDo(print()).andExpect(status().isOk())
                .andExpect(
                        content().string(containsString("1")));
    }

    @Test
    public void testInvalidLogin() throws Exception {
        this.mockMvc.perform(post("/login")
                .param("token", "faketoken")
                .param("email", "John@gmail.com")).andDo(print()).andExpect(status().isBadRequest());
    }

    @Test
    public void testSignUpInvalidInput() throws Exception {
        this.mockMvc.perform(post("/signup")
                .param("first_name", "John")
                .param("image", "http://image.com/123")).andDo(print()).andExpect(status().isBadRequest());
    }
}