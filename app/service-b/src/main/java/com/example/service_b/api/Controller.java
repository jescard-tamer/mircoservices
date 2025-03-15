package com.example.service_b.api;

import com.example.service_b.core.FetchRepositoriesResponse;
import com.example.service_b.core.IRepoFetcher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class Controller implements Api {

    private final IRepoFetcher fetcher;
    private final ApiMapper mapper = ApiMapper.INSTANCE;

    @Override
    public ResponseEntity<FetchRepositoriesApiResponse> fetchRepos() {
        FetchRepositoriesResponse response = fetcher.fetchRepos();
        return ResponseEntity.ok(mapper.map(response));
    }
}
