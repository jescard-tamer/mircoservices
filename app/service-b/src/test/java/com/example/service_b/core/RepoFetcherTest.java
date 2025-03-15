package com.example.service_b.core;

import com.example.service_b.core.client.IRepoFetcherClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class RepoFetcherTest {
    private IRepoFetcher fetcher;
    private IRepoFetcherClient fetcherClient;

    @BeforeEach
    void setup() {
        fetcherClient = mock(IRepoFetcherClient.class);
        fetcher = new RepoFetcher(fetcherClient);
    }

    @Test
    void should_return_data_correctly() {
        when(fetcherClient.fetch()).thenReturn(FetchRepositoriesResponse.builder().repo("batata").randomData("data").build());

        assertEquals(FetchRepositoriesResponse.builder().repo("batata").randomData("data").build(), fetcher.fetchRepos());
    }
}