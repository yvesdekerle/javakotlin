package com.ydekerle.javakotlin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SpaceXController {

    private final SpaceXService service;

    public SpaceXController(SpaceXService service) {
        this.service = service;
    }

    @GetMapping("/spacex/launches")
    public List<Launch> launches(@RequestParam(value = "filter", defaultValue = "") final String filter) {
        return service.launches(filter);
    }
}
