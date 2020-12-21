package com.ydekerle.javakotlin;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class SpaceXClient {

    private static final String SPACEX_URL = "https://api.spacexdata.com/v4/launches";
    private final RestTemplate restTemplate;

    public SpaceXClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Launch> launches() {
        try {
            return List.of(
                requireNonNull(
                    restTemplate
                    .getForEntity(SPACEX_URL, Launch[].class)
                    .getBody()
                )
            );
        } catch(RestClientException e) {
            return List.of();
        }
    }
}
