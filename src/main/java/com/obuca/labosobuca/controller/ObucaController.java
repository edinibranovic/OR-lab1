package com.obuca.labosobuca.controller;


import com.obuca.labosobuca.controller.response.ObucaWrappedResponse;
import com.obuca.labosobuca.controller.response.ObuceWrappedResponse;
import com.obuca.labosobuca.entity.Boja;
import com.obuca.labosobuca.entity.Obuca;
import com.obuca.labosobuca.exception.ZahtjevIznimka;
import com.obuca.labosobuca.repository.BojaRepository;
import com.obuca.labosobuca.repository.ObucaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/obuce")
public class ObucaController {

    private final ObucaRepository obucaRepository;
    private final BojaRepository bojaRepository;

    public ObucaController(ObucaRepository obucaRepository, BojaRepository bojaRepository) {
        this.obucaRepository = obucaRepository;
        this.bojaRepository = bojaRepository;
    }

    @GetMapping ("/wrapped")
    @ResponseStatus(HttpStatus.OK)
    public ObuceWrappedResponse findAllWrapped() {

        List<Obuca> obuce = obucaRepository.noFilter();

        if (!obuce.isEmpty()) {
            return new ObuceWrappedResponse("OK","Obuće učitane", obuce);
        } else {
            throw new ZahtjevIznimka("Obuće");
        }
    }

    @PostMapping ("/wrapped")
    @ResponseStatus(HttpStatus.CREATED)
    public ObucaWrappedResponse addObuca(@RequestBody Obuca obuca) {

        bojaRepository.saveAll(obuca.getBoje());

        final Obuca createdObuca = obucaRepository.save(obuca);

        return new ObucaWrappedResponse("OK","Stvorena obuća", createdObuca);

    }

    @PutMapping ("/wrapped/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ObucaWrappedResponse addObuca(@RequestBody Obuca newObuca, @PathVariable Long id) {

        Optional<Obuca> foundObuca = obucaRepository.IdFilter(id);

        if(foundObuca.isPresent()) {
            foundObuca
                    .map(obuca -> {
                        obuca.setMarka(newObuca.getMarka());
                        obuca.setModel(newObuca.getModel());
                        obuca.setSpol(newObuca.getSpol());
                        obuca.setVelicina(newObuca.getVelicina());
                        obuca.setGodProizvodnje(newObuca.getGodProizvodnje());
                        obuca.setMaterijal(newObuca.getMaterijal());
                        obuca.setVrsta(newObuca.getVrsta());
                        obuca.setBoje(newObuca.getBoje());
                        obuca.setVisinaDona(newObuca.getVisinaDona());
                        obuca.setTipZatvaranja(newObuca.getTipZatvaranja());
                        return obucaRepository.save(obuca);
                    });
            return new ObucaWrappedResponse("OK","Izmijenjena obuća", newObuca);
        } else {
            throw new ZahtjevIznimka("Izmijenjivanje obuće");
        }
    }

    @DeleteMapping ("/wrapped/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteObuca(@PathVariable Long id) {

        Optional<Obuca> foundObuca = obucaRepository.IdFilter(id);

        if(foundObuca.isPresent()) {
            obucaRepository.delete(foundObuca.get());
            return "Izbrisana obuća";

        } else {
            throw new ZahtjevIznimka("Izmijenjivanje obuće");
        }
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Obuca> noFilter() {

        List<Obuca> obuce = obucaRepository.noFilter();

        return obuce;
    }

    @GetMapping("/marka/{marka}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> MarkaFiltriranje(@PathVariable String marka) {

        return obucaRepository.MarkaFilter(marka);
    }

    @GetMapping("/model/{model}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> ModelFiltriranje(@PathVariable String model) {

        return obucaRepository.ModelFilter(model);
    }

    @GetMapping("/velicina/{velicina}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VelicinaFiltriranje(@PathVariable String velicina) {

        return obucaRepository.VelicinaFilter(Integer.parseInt(velicina));
    }

    @GetMapping("/godProizvodnje/{godProizvodnje}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> GodProizvodnjeFiltriranje(@PathVariable String godProizvodnje) {

        return obucaRepository.GodProizvodnjeFilter(Integer.parseInt(godProizvodnje));
    }

    @GetMapping("/spol/{spol}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> SpolFiltriranje(@PathVariable String spol) {

        return obucaRepository.SpolFilter(spol);
    }

    @GetMapping("/vrsta/{vrsta}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VrstaFiltriranje(@PathVariable String vrsta) {

        return obucaRepository.VrstaFilter(vrsta);
    }

    @GetMapping("/materijal/{materijal}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> MaterijalFiltriranje(@PathVariable String materijal) {

        return obucaRepository.MaterijalFilter(materijal);
    }

    @GetMapping("/visinaDona/{visinaDona}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VisinaDonaFiltriranje(@PathVariable String visinaDona) {

        return obucaRepository.VisinaDonaFilter(visinaDona);
    }

    @GetMapping("/tipZatvaranja/{tipZatvaranja}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> TipZatvaranjaFiltriranje(@PathVariable String tipZatvaranja) {

        return obucaRepository.TipZatvaranjaFilter(tipZatvaranja);
    }
    
    @GetMapping("/boja/{bojaNaziv}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> BojeFiltriranje(@PathVariable String bojaNaziv) {

        List<Boja> foundBoje = new ArrayList<>();

        foundBoje = Stream.of(bojaRepository.BojaFilter(bojaNaziv)).flatMap(Collection::stream).distinct().collect(Collectors.toList());

        return obucaRepository.BojeFilter(foundBoje);
    }
    
}
