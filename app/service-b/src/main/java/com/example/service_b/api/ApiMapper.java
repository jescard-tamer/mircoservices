package com.example.service_b.api;

import com.example.service_b.core.FetchRepositoriesResponse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ApiMapper {
    FetchRepositoriesApiResponse map(FetchRepositoriesResponse response);
}
