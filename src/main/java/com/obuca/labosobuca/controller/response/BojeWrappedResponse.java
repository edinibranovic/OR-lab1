package com.obuca.labosobuca.controller.response;

import com.obuca.labosobuca.entity.Boja;
import java.util.*;

public class BojeWrappedResponse {

    private String status;
    private String message;
    private List<Boja> response;

    public BojeWrappedResponse(String status, String message, List<Boja> response) {
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

    public List<Boja> getResponse() {
        return response;
    }

    public void setResponse(List<Boja> response) {
        this.response = response;
    }
}
