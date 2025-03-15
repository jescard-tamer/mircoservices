package com.example.service_b.core.client;

import com.example.service_b.core.FetchRepositoriesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class RepoFetcherClient implements IRepoFetcherClient {
    private final RepoClient repoClient;

    @Override
    public FetchRepositoriesResponse fetch() {
        System.out.println(repoClient.getRepos().getBody());
        return repoClient.getRepos().getBody();
    }
}
