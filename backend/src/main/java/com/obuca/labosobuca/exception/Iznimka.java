package com.obuca.labosobuca.exception;

import org.springframework.http.HttpStatus;

public class Iznimka {

    private final HttpStatus httpStatus;
    private final String msg;

    public Iznimka(HttpStatus httpStatus, String msg) {
        this.httpStatus = httpStatus;
        this.msg = msg;
    }

    public HttpStatus getStatus() {
        return httpStatus;
    }
    public String getMessage() {
        return msg;
    }
}
