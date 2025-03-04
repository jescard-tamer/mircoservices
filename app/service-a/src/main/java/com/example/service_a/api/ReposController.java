package com.example.service_a.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReposController implements ReposApi {
    @Override
    public ResponseEntity<FetchReposApiResponse> fetchAllRepos() {
        return ResponseEntity.ok(FetchReposApiResponse.builder()
                .repo("batata")
                .randomData("data")
                .build());
    }
}
