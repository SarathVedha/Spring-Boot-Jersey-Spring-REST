package com.vedha.service.impl;

import com.vedha.service.ApiService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Slf4j
@Service
@RequiredArgsConstructor
public class SpringApiServiceImpl implements ApiService {

    private final RestClient restClient;

    @Override
    public String callGetAllRestApi() {

        // https://api.restful-api.dev/objects

        ResponseEntity<String> entity = restClient.get().uri(uriBuilder -> uriBuilder.path("/objects").build()).retrieve().toEntity(String.class);

        return entity.getBody();
    }

    @Override
    public String callGetRestApiById(String id) {

        // https://api.restful-api.dev/objects/7

        ResponseEntity<String> entity = restClient.get().uri(uriBuilder -> uriBuilder.path("/objects/" + id).build()).retrieve().toEntity(String.class);

        return entity.getBody();
    }

    @Override
    public String callDeleteRestApiById(String id) {

        // https://api.restful-api.dev/objects/6

        ResponseEntity<String> entity = restClient.delete().uri(uriBuilder -> uriBuilder.path("/objects/" + id).build()).retrieve().toEntity(String.class);

        return entity.getBody();
    }
}
