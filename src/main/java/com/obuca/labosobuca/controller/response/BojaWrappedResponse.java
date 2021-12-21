package com.obuca.labosobuca.controller.response;

import com.obuca.labosobuca.entity.Boja;

public class BojaWrappedResponse {

    private String status;
    private String message;
    private Boja response;

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

    public Boja getResponse() {
        return response;
    }

    public void setResponse(Boja response) {
        this.response = response;
    }
}
