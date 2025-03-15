package com.example.service_b.api;

import com.example.service_b.core.FetchRepositoriesResponse;
import com.example.service_b.core.IRepoFetcher;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@EnableWebMvc
@AutoConfigureMockMvc
@SpringBootTest
class ControllerIntegrationTest {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private IRepoFetcher fetcher;

    @Test
    void should_return_200() throws Exception {
        mockMvc.perform(get("/service-b/batata"))
                .andExpect(status().isOk());
    }

    @Test
    void should_return_data_correctly() throws Exception {
        when(fetcher.fetchRepos()).thenReturn(FetchRepositoriesResponse.builder()
                .repos(List.of("repo"))
                .randomData("random")
                .build());

        String reponseAsString = mockMvc.perform(get("/service-b/batata"))
                .andReturn()
                .getResponse().getContentAsString();

        FetchRepositoriesApiResponse response = objectMapper.readValue(reponseAsString, new TypeReference<>() {
        });
        Assertions.assertEquals(getFetchRepositoriesApiResponse(), response);

    }

    private static FetchRepositoriesApiResponse getFetchRepositoriesApiResponse() {
        return FetchRepositoriesApiResponse.builder()
                .repos(List.of("repo"))
                .randomData("random")
                .build();
    }

}