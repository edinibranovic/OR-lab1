package com.obuca.labosobuca.controller;

import com.obuca.labosobuca.controller.response.BojeWrappedResponse;
import com.obuca.labosobuca.entity.Boja;
import com.obuca.labosobuca.entity.Obuca;
import com.obuca.labosobuca.repository.BojaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        final List<Boja> boje = bojaRepository.findAll();

        return new BojeWrappedResponse("OK","Boje učitane", boje);
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Boja> IdFiltriranje(@PathVariable Integer id) {

        return bojaRepository.findById(id);
    }

}
