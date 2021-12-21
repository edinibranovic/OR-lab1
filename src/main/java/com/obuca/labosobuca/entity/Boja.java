package com.obuca.labosobuca.entity;

import javax.persistence.*;

@Entity
@Table(name = "boja")
public class Boja {

    @Id
    @Column(name = "id")
    private Integer id;
    @Column(name = "naziv")
    private String naziv;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNaziv() {
        return naziv;
    }
    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

}
