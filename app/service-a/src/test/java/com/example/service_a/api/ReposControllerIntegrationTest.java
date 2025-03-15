package com.example.service_a.api;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = {ReposController.class})
class ReposControllerIntegrationTest {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    void should_return_200_when_fetching() throws Exception {
        mockMvc.perform(get("/service-a/repos")).andExpect(status().isOk());
    }

    @Test
    void should_return_data() throws Exception {
        String contentAsString = mockMvc.perform(get("/service-a/repos")).andReturn().getResponse().getContentAsString();
        FetchReposApiResponse response = objectMapper.readValue(contentAsString, new TypeReference<>() {
        });

        assertEquals(FetchReposApiResponse.builder().repo("batata").randomData("data").build(), response);
    }
}