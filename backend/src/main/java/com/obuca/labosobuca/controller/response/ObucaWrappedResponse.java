package com.obuca.labosobuca.controller.response;

import com.obuca.labosobuca.entity.Obuca;

import java.util.List;

public class ObucaWrappedResponse {

    private String status;
    private String message;
    private Obuca response;

    public ObucaWrappedResponse(String status, String message, Obuca response) {
        this.status = status;
        this.message = message;
        this.response = response;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Obuca getResponse() {
        return response;
    }

    public void setResponse(Obuca response) {
        this.response = response;
    }
}
