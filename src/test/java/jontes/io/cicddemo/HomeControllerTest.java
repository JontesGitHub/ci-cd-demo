package jontes.io.cicddemo;

import jontes.io.cicddemo.controller.HomeController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(HomeController.class)
public class HomeControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Value("${welcome.message}")
    private String welcomeMessage;

    @DisplayName("should return welcome message on /")
    @Test
    public void homeEndpoint() throws Exception {
        // when
        MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get("/")).andReturn().getResponse();

        //then
        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(welcomeMessage);
    }

    @DisplayName("should return the sum of two path variables on /add")
    @Test
    public void addEndpoint() throws Exception {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int valueOne = random.nextInt(100);
            int valueTwo = random.nextInt(100);
            // when
            MockHttpServletResponse response = mockMvc.perform(MockMvcRequestBuilders.get(String.format("/add/%d/%d",valueOne,valueTwo))).andReturn().getResponse();

            //then
            assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
            assertThat(response.getContentAsString()).isEqualTo(String.valueOf(valueOne+valueTwo));
        }
    }
}
