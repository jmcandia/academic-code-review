package edu.fixture.tasks;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TaskControllerTest {
    @Autowired MockMvc mvc;

    @Test void createsTask() throws Exception {
        mvc.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\"Read\"}"))
                .andExpect(status().isCreated());
    }
    @Test void rejectsBlankTitle() throws Exception {
        mvc.perform(post("/tasks").contentType(MediaType.APPLICATION_JSON).content("{\"title\":\" \"}"))
                .andExpect(status().isBadRequest());
    }
    @Test void unknownTaskIsNotFound() throws Exception {
        mvc.perform(get("/tasks/9999")).andExpect(status().isNotFound());
    }
}
