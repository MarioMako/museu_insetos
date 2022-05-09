package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ClassificacaoTaxonomicaQuery extends JpaRepository<ClassificacaoTaxonomica, Integer> {

    @Query("SELECT c FROM ClassificacaoTaxonomica c WHERE :ordem is null or c.ordens.id = :ordem AND " +
            " :familia is null or c.familias.id = :familia")
    List<ClassificacaoTaxonomica> getFiltros(@Param("ordem")Integer ordem,@Param("familia")Integer familia);
}
