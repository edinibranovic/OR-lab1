package com.obuca.labosobuca.repository;

import com.obuca.labosobuca.entity.Boja;
import com.obuca.labosobuca.entity.Obuca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ObucaRepository extends JpaRepository<Obuca, Long>, JpaSpecificationExecutor<Obuca> {

    List<Obuca> noFilter();
    Optional<Obuca> IdFilter(Long id);
    List<Obuca> MarkaFilter(String marka);
    List<Obuca> ModelFilter(String model);
    List<Obuca> VelicinaFilter(Integer velicina);
    List<Obuca> GodProizvodnjeFilter(Integer godProizvodnje);
    List<Obuca> SpolFilter(String spol);
    List<Obuca> VrstaFilter(String vrsta);
    List<Obuca> MaterijalFilter(String materijal);
    List<Obuca> VisinaDonaFilter(String visinaDona);
    List<Obuca> TipZatvaranjaFilter(String tipZatvaranja);
    List<Obuca> BojeFilter(List<Boja> boje);

}
