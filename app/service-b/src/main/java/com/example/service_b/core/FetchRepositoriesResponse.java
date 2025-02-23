package com.example.service_b.core;

import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FetchRepositoriesResponse {
    @Singular
    private List<String> repos;
    private String randomData;
}
