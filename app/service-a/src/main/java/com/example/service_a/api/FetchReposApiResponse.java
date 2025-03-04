package com.example.service_a.api;

import lombok.Builder;
import lombok.Singular;
import lombok.Value;
import lombok.extern.jackson.Jacksonized;

import java.util.List;

@Value
@Builder
@Jacksonized
public class FetchReposApiResponse {
    @Singular
    List<String> repos;
    String randomData;
}
