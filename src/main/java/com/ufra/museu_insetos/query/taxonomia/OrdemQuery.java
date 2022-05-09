package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.Ordem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrdemQuery extends JpaRepository<Ordem,Integer> {

    @Query ("SELECT o FROM Ordem o WHERE :familia IS NULL OR o.familias = :familia")
    List<Ordem> getFamiliasByOrdem(@Param("familia")Integer familia);
}
