package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomicaEspecie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassificacaoTaxonomicaQuery extends CrudRepository<ClassificacaoTaxonomicaEspecie, Integer> {

    @Query("SELECT c FROM ClassificacaoTaxonomicaEspecie c JOIN c.ordem o JOIN c.familia f JOIN c.genero g WHERE (o.id = :ordem OR :ordem IS NULL) OR" +
            " (f.id = :familia OR :familias IS NULL) OR (g.id = :genero OR :genero IS NULL) ")
    ClassificacaoTaxonomicaEspecie findFiltros(@Param("ordem")Integer ordem,@Param("familia")Integer familia,@Param("genero")Integer genero);

}
