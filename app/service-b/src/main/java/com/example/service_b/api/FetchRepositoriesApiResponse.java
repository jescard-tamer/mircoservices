package com.example.service_b.api;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FetchRepositoriesApiResponse {
    @Singular
    private List<String> repos;
    private String randomData;
}
