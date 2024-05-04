package com.vedha.controller;

import com.vedha.service.ApiService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class ApiController {

    private final ApiService jerseyApiServiceImpl;

    private final ApiService springApiServiceImpl;

    @Operation(summary = "Get All By Jersey", description = "Get All By Jersey RESTFULL API", tags = "Jersey API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/jersey/all", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJerseyApi() {

        return ResponseEntity.ok(jerseyApiServiceImpl.callGetAllRestApi());
    }

    @Operation(summary = "Get All By Spring", description = "Get All By Spring RESTFULL API", tags = "Spring API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/spring/all", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSpringApi() {

        return ResponseEntity.ok(springApiServiceImpl.callGetAllRestApi());
    }

    @Operation(summary = "Get By Id Jersey", description = "Get By Id Jersey RESTFULL API", tags = "Jersey API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/jersey/byId", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getJerseyApiById(@RequestParam(value = "id", defaultValue = "1") @Parameter(description = "Id", example = "1") String id) {

        return ResponseEntity.ok(jerseyApiServiceImpl.callGetRestApiById(id));
    }

    @Operation(summary = "Get By Id Spring", description = "Get By Id Spring RESTFULL API", tags = "Spring API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @GetMapping(value = "/spring/byId", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getSpringApiById(@RequestParam(value = "id", defaultValue = "1") @Parameter(description = "Id", example = "1") String id) {

        return ResponseEntity.ok(springApiServiceImpl.callGetRestApiById(id));
    }

    @Operation(summary = "Delete By Id Jersey", description = "Delete By Id Jersey RESTFULL API", tags = "Jersey API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @DeleteMapping(value = "/jersey/byId", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteJerseyApiById(@RequestParam(value = "id", defaultValue = "1") @Parameter(description = "Id", example = "1") String id) {

        return ResponseEntity.ok(jerseyApiServiceImpl.callDeleteRestApiById(id));
    }

    @Operation(summary = "Delete By Id Spring", description = "Delete By Id Spring RESTFULL API", tags = "Spring API")
    @ApiResponse(responseCode = "200", description = "HTTP Status 200 OK")
    @DeleteMapping(value = "/spring/byId", consumes = MediaType.ALL_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteSpringApiById(@RequestParam(value = "id", defaultValue = "1") @Parameter(description = "Id", example = "1") String id) {

        return ResponseEntity.ok(springApiServiceImpl.callDeleteRestApiById(id));
    }
}
