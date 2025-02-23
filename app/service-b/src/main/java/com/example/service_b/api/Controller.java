package com.example.service_b.api;

import com.example.service_b.core.IRepoFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller implements Api {

    private final IRepoFetcher fetcher;
    private final ApiMapper apiMapper;

    @Override
    public ResponseEntity<FetchRepositoriesApiResponse> fetchRepos() {
        return ResponseEntity.ok(apiMapper.map(fetcher.fetchRepos()));
    }
}
