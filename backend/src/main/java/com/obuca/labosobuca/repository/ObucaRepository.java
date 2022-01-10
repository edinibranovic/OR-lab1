package com.obuca.labosobuca.repository;

import com.obuca.labosobuca.entity.Boja;
import com.obuca.labosobuca.entity.Obuca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface ObucaRepository extends JpaRepository<Obuca, Long>, JpaSpecificationExecutor<Obuca> {

    List<Obuca> findAll();

    Optional<Obuca> findById(Integer id);
    List<Obuca> findByMarka(String marka);
    List<Obuca> findByModel(String model);
    List<Obuca> findByVelicina(Integer velicina);
    List<Obuca> findByGodProizvodnje(Integer godProizvodnje);
    List<Obuca> findBySpol(String spol);
    List<Obuca> findByVrsta(String vrsta);
    List<Obuca> findByMaterijal(String materijal);
    List<Obuca> findByVisinaDona(String visinaDona);
    List<Obuca> findByTipZatvaranja(String tipZatvaranja);
    List<Obuca> findByBojeIn(List<Boja> boje);

}
