package com.example.service_b.api;

import com.example.service_b.core.FetchRepositoriesResponse;
import org.junit.jupiter.api.Test;

class ApiMapperTest {

    @Test
    void test() {
        System.out.println(ApiMapper.INSTANCE.map(FetchRepositoriesResponse.builder().repo("ava").randomData("rand").build()));
    }
}