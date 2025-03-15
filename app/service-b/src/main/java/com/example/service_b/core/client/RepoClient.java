package com.example.service_b.core.client;

import com.example.service_b.core.FetchRepositoriesResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("service-a")
public interface RepoClient {
    @GetMapping("/service-a/repos")
    ResponseEntity<FetchRepositoriesResponse> getRepos();
}
