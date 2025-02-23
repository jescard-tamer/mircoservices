package com.example.service_b.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("batata")
public interface Api {

    @GetMapping
    ResponseEntity<FetchRepositoriesApiResponse> fetchRepos();
}
