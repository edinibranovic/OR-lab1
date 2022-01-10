package com.obuca.labosobuca.dokumentacija;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/openapi")
public class DokumentacijaController {

    @Autowired
    private ResourceLoader resourceLoader;


    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public Resource loadOpenApi() {

        final Resource resource = resourceLoader.getResource("classpath:openapi.json");

        return resource;
    }
}

