package com.example.service_b.core;

import com.example.service_b.core.client.IRepoFetcherClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RepoFetcher implements IRepoFetcher {
    private final IRepoFetcherClient fetcherClient;

    @Override
    public FetchRepositoriesResponse fetchRepos() {
        return fetcherClient.fetch();
    }
}
