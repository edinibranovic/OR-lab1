package com.obuca.labosobuca.entity;

import javax.persistence.*;

@Entity
@Table(name = "boja")
public class Boja {

    @Id
    @Column(name = "id")
    private Long id;
    @Column(name = "naziv")
    private String naziv;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
