package com.ydekerle.javakotlin;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "spacex-api")
public class SpaceXProperties {

    private final String url;
    private final String launches;

    public SpaceXProperties(String url, String launches) {
        this.url = url;
        this.launches = launches;
    }

    public String getUrl() {
        return url;
    }

    public String getLaunches() {
        return launches;
    }
}
