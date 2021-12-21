package com.obuca.labosobuca.entity;

import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "obuca")
public class Obuca {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "marka")
    private String marka;
    @Column(name = "model")
    private String model;
    @Column(name = "spol")
    private String spol;
    @Column(name = "velicina")
    private Integer velicina;
    @Column(name = "godProizvodnje")
    private Integer godProizvodnje;
    @Column(name = "materijal")
    private String materijal;
    @Column(name = "vrsta")
    private String vrsta;
    @Column(name = "visinaDona")
    private String visinaDona;
    @Column(name = "tipZatvaranja")
    private String tipZatvaranja;
    @ManyToMany
    @JoinTable(name = "ima", joinColumns = @JoinColumn(name = "obucaid"), inverseJoinColumns = @JoinColumn(name = "bojaid"))
    private List<Boja> boje;
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
    public String getSpol() {
        return spol;
    }
    public void setSpol(String spol) {
        this.spol = spol;
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
    public List<Boja> getBoje() {
        return boje;
    }
    public void setBoje(List<Boja> boje) {
        this.boje = boje;
    }
}
