package com.obuca.labosobuca.controller.response;

import java.util.*;

public class ObucaResponse {

    private Long id;
    private String marka;
    private String model;
    private String spol;
    private Integer velicina;
    private Integer godProizvodnje;
    private String materijal;
    private String vrsta;
    private String visinaDona;
    private String tipZatvaranja;
    private List<BojaResponse> boje;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarka() {
        return marka;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getVelicina() {
        return velicina;
    }

    public void setVelicina(Integer velicina) {
        this.velicina = velicina;
    }

    public Integer getGodProizvodnje() {
        return godProizvodnje;
    }

    public void setGodProizvodnje(Integer godProizvodnje) {
        this.godProizvodnje = godProizvodnje;
    }

    public String getMaterijal() {
        return materijal;
    }

    public void setMaterijal(String materijal) {
        this.materijal = materijal;
    }

    public String getVrsta() {
        return vrsta;
    }

    public void setVrsta(String vrsta) {
        this.vrsta = vrsta;
    }

    public String getVisinaDona() {
        return visinaDona;
    }

    public void setVisinaDona(String visinaDona) {
        this.visinaDona = visinaDona;
    }

    public String getTipZatvaranja() {
        return tipZatvaranja;
    }

    public void setTipZatvaranja(String tipZatvaranja) {
        this.tipZatvaranja = tipZatvaranja;
    }

    public List<BojaResponse> getBoje() {
        return boje;
    }

    public void setBoje(List<BojaResponse> boje) {
        this.boje = boje;
    }
}
