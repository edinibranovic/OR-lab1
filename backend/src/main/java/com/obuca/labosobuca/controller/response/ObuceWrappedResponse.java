package com.obuca.labosobuca.controller.response;

import com.obuca.labosobuca.entity.Obuca;

import java.util.List;

public class ObuceWrappedResponse {

    private String status;
    private String message;
    private List<Obuca> response;

    public ObuceWrappedResponse(String status, String message, List<Obuca> response) {
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

    public List<Obuca> getResponse() {
        return response;
    }

    public void setResponse(List<Obuca> response) {
        this.response = response;
    }
}
