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

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ObuceWrappedResponse findAll() {

        List<Obuca> obuce = obucaRepository.findAll();

        if (!obuce.isEmpty()) {
            return new ObuceWrappedResponse("OK","Obuće učitane", obuce);
        } else {
            throw new ZahtjevIznimka("Obuće");
        }
    }

    @GetMapping("/id/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> IdFiltriranje(@PathVariable String marka) {

        return obucaRepository.findByMarka(marka);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ObucaWrappedResponse addBoja(@RequestBody Obuca obuca) {

        obucaRepository.save(obuca);

        final Obuca createdObuca = obucaRepository.save(obuca);

        return new ObucaWrappedResponse("OK","Stvorena obuća", createdObuca);

    }

    @PutMapping ("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public ObucaWrappedResponse editObuca(@RequestBody Obuca newObuca, @PathVariable Integer id) {

        Optional<Obuca> foundObuca = obucaRepository.findById(id);

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

    @DeleteMapping ("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteObuca(@PathVariable Integer id) {

        Optional<Obuca> foundObuca = obucaRepository.findById(id);

        if(foundObuca.isPresent()) {
            obucaRepository.delete(foundObuca.get());
            return "Izbrisana obuća";

        } else {
            throw new ZahtjevIznimka("Izmijenjivanje obuće");
        }
    }

    @GetMapping("/marka/{marka}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> MarkaFiltriranje(@PathVariable String marka) {

        return obucaRepository.findByMarka(marka);
    }

    @GetMapping("/model/{model}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> ModelFiltriranje(@PathVariable String model) {

        return obucaRepository.findByModel(model);
    }

    @GetMapping("/velicina/{velicina}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VelicinaFiltriranje(@PathVariable String velicina) {

        return obucaRepository.findByVelicina(Integer.parseInt(velicina));
    }

    @GetMapping("/godProizvodnje/{godProizvodnje}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> GodProizvodnjeFiltriranje(@PathVariable String godProizvodnje) {

        return obucaRepository.findByGodProizvodnje(Integer.parseInt(godProizvodnje));
    }

    @GetMapping("/spol/{spol}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> SpolFiltriranje(@PathVariable String spol) {

        return obucaRepository.findBySpol(spol);
    }

    @GetMapping("/vrsta/{vrsta}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VrstaFiltriranje(@PathVariable String vrsta) {

        return obucaRepository.findByVrsta(vrsta);
    }

    @GetMapping("/materijal/{materijal}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> MaterijalFiltriranje(@PathVariable String materijal) {

        return obucaRepository.findByMaterijal(materijal);
    }

    @GetMapping("/visinaDona/{visinaDona}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> VisinaDonaFiltriranje(@PathVariable String visinaDona) {

        return obucaRepository.findByVisinaDona(visinaDona);
    }

    @GetMapping("/tipZatvaranja/{tipZatvaranja}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> TipZatvaranjaFiltriranje(@PathVariable String tipZatvaranja) {

        return obucaRepository.findByTipZatvaranja(tipZatvaranja);
    }
    
    @GetMapping("/boja/{bojaNaziv}")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Obuca> BojeFiltriranje(@PathVariable String bojaNaziv) {

        List<Boja> foundBoje = new ArrayList<>();

        foundBoje = Stream.of(bojaRepository.findByNaziv(bojaNaziv)).flatMap(Collection::stream).distinct().collect(Collectors.toList());

        return obucaRepository.findByBojeIn(foundBoje);
    }
    
}
