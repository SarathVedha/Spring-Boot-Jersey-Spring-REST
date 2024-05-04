package com.vedha.service.impl;

import com.vedha.service.ApiService;
import jakarta.ws.rs.client.Invocation;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeoutException;

@Slf4j
@Service
@RequiredArgsConstructor
public class JerseyApiServiceImpl implements ApiService {

    private final WebTarget webTarget;

    @Override
    public String callGetAllRestApi() {

        // https://api.restful-api.dev/objects

        Invocation.Builder invocationBuilder = webTarget.path("/objects").request(MediaType.APPLICATION_JSON);
        Response response = invocationBuilder.get();

        return response.readEntity(String.class);
    }

    @Override
    public String callGetRestApiById(String id) {

        // https://api.restful-api.dev/objects/7

        Invocation.Builder request = webTarget.path("/objects/" + id).request(MediaType.APPLICATION_JSON);
        Response response = request.get();

        return response.readEntity(String.class);
    }

    public String callGetAsyncRestApiById(String id) throws ExecutionException, InterruptedException, TimeoutException {

        // https://api.restful-api.dev/objects/7

        Invocation.Builder request = webTarget.path("/objects/" + id).request(MediaType.APPLICATION_JSON);
        Future<Response> responseFuture = request.async().get();

        // This will wait for 3 seconds to get the response
        // Response response = responseFuture.get(3, TimeUnit.SECONDS);

        return "Async Triggered";
    }

    @Override
    public String callDeleteRestApiById(String id) {

        // https://api.restful-api.dev/objects/6

        Invocation.Builder request = webTarget.path("/objects/" + id).request(MediaType.APPLICATION_JSON);
        Response delete = request.delete();

        return delete.readEntity(String.class);
    }
}
