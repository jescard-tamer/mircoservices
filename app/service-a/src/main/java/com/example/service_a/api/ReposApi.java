package com.example.service_a.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("service-a")
public interface ReposApi {

    @GetMapping("repos")
    ResponseEntity<FetchReposApiResponse> fetchAllRepos();
}
