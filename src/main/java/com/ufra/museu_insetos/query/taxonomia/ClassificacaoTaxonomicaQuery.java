package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomica;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ClassificacaoTaxonomicaQuery extends CrudRepository<ClassificacaoTaxonomica, Integer> {

    @Query("SELECT c FROM ClassificacaoTaxonomica c JOIN c.ordens o JOIN c.familias f JOIN c.generos g WHERE (o.id = :ordens OR :ordens IS NULL) OR" +
            " (f.id = :familias OR :familias IS NULL) OR (g.id = :generos OR :generos IS NULL) ")
    ClassificacaoTaxonomica findFiltros(@Param("ordens")Integer ordens,@Param("familias")Integer familia,@Param("generos")Integer genero);

}
