package com.example.service_b.api;

import com.example.service_b.core.FetchRepositoriesResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ApiMapper {
    ApiMapper INSTANCE = Mappers.getMapper(ApiMapper.class);
    FetchRepositoriesApiResponse map(FetchRepositoriesResponse response);
}
