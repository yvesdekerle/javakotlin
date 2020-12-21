package com.ydekerle.javakotlin;

import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static java.util.Objects.requireNonNull;

public class SpaceXClient {

    private final RestTemplate restTemplate;
    private final SpaceXProperties spaceXProperties;

    public SpaceXClient(RestTemplate restTemplate, SpaceXProperties spaceXProperties) {
        this.restTemplate = restTemplate;
        this.spaceXProperties = spaceXProperties;
    }

    public List<Launch> launches() {
        try {
            return List.of(
                requireNonNull(
                    restTemplate
                    .getForEntity(buildLaunchesUrl(), Launch[].class)
                    .getBody()
                )
            );
        } catch(RestClientException e) {
            return List.of();
        }
    }

    private String buildLaunchesUrl() {
        return spaceXProperties.getUrl() + spaceXProperties.getLaunches();
    }
}
