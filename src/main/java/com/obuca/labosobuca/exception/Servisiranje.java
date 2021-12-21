package com.obuca.labosobuca.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Servisiranje {

    @ExceptionHandler(value = {ZahtjevIznimka.class})
    public ResponseEntity<Object> servisiraj(ZahtjevIznimka e ) {

        HttpStatus notFound = HttpStatus.NOT_FOUND;
        HttpStatus notOwned = HttpStatus.METHOD_NOT_ALLOWED;

        if (e.getMessage().equals("Obuće")) {
            Iznimka apiException = new Iznimka(notOwned,"Greška");
            return new ResponseEntity<>(apiException, notFound);
        }
        
        if (e.getMessage().equals("Izmijenjivanje obuće")) {
            Iznimka apiException = new Iznimka(notFound, "Ne postoji ova obuća");
            return new ResponseEntity<>(apiException, notFound);
        }

        return null;
    }

}
