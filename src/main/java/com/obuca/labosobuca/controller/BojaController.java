package com.obuca.labosobuca.controller;

import com.obuca.labosobuca.controller.response.BojeWrappedResponse;
import com.obuca.labosobuca.entity.Boja;
import com.obuca.labosobuca.repository.BojaRepository;
import org.springframework.http.HttpStatus;
import com.obuca.labosobuca.exception.ZahtjevIznimka;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/boje")
public class BojaController {

    private final BojaRepository bojaRepository;

    public BojaController(BojaRepository bojaRepository) {
        this.bojaRepository = bojaRepository;
    }

    @GetMapping 
    @ResponseStatus(HttpStatus.OK)
    public BojeWrappedResponse noFilter() {
        final List<Boja> boje = bojaRepository.noFilter();

        return new BojeWrappedResponse("OK","Boje učitane", boje);
    }

}
