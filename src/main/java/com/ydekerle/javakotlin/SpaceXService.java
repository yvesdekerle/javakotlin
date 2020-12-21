package com.ydekerle.javakotlin;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.nonNull;
import static java.util.stream.Collectors.toUnmodifiableList;
import static org.apache.logging.log4j.util.Strings.isNotEmpty;

public class SpaceXService {

    private final SpaceXClient client;

    public SpaceXService(final SpaceXClient client) {
        this.client = client;
    }

    public List<Launch> launches(final String filter) {
        final var launches = client.launches().stream().filter(Objects::nonNull).collect(toUnmodifiableList());

        if(isNotEmpty(filter))
            return filterList(launches, filter);

        return launches;
    }

    private List<Launch> filterList(final List<Launch> launches, final String filter) {
        return launches.stream()
            .filter(launch ->
                nonNull(launch.getName()) &&
                launch.getName().contains(filter)
            )
            .collect(toUnmodifiableList());
    }

}
