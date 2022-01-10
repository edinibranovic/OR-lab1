package com.obuca.labosobuca.repository;

import com.obuca.labosobuca.entity.Boja;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import java.util.*;

@Repository
public interface BojaRepository extends JpaRepository<Boja, Long>, JpaSpecificationExecutor<Boja> {

    List<Boja> findAll();
    List<Boja> findById(Integer id);
    List<Boja> findByNaziv(String bojaNaziv);
}
