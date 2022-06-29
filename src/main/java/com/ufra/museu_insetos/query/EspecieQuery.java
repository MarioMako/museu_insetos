package com.ufra.museu_insetos.query;

import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EspecieQuery extends CrudRepository<Especie,Integer> {

    @Query("SELECT e from Especie e " + "" +
            "JOIN e.classificacaoTaxonomicaEspecie.ordem o JOIN e.classificacaoTaxonomicaEspecie.familia f JOIN e.classificacaoTaxonomicaEspecie.genero g" +
            " JOIN e.descricaoMorfologicaEspecie.abdomen ab JOIN e.descricaoMorfologicaEspecie.antena ant JOIN e.descricaoMorfologicaEspecie.aparelho ap JOIN e.descricaoMorfologicaEspecie.asas asa" +
            " JOIN e.descricaoMorfologicaEspecie.pernas p JOIN e.comportamento comp JOIN e.metamorfose meta WHERE " +
            "(e.nomeVulgar LIKE %:nome% OR :nome IS NULL) AND (e.nomeCientifico LIKE %:nome% OR :nome IS NULL) AND" +
            "(o.id = :ordem OR :ordem IS NULL) AND (f.id = :familia OR :familia IS NULL) AND (g.id = :genero OR :genero IS NULL) AND " +
            "(ab.id = :abdomen OR :abdomen IS NULL) AND (ant.id = :antena OR :antena IS NULL) AND (ap.id = :aparelho OR :aparelho IS NULL) AND " +
            "(asa.id = :asas OR :asas IS NULL) AND (p.id = :pernas OR :pernas IS NULL) AND (comp.id = :comportamento OR :comportamento IS NULL) AND " +
            "(meta.id = :metamorfose OR :metamorfose IS NULL) AND (e.habitat = :habitat OR :habitat IS NULL)")
    List<Especie> findAllByFiltros(@Param("nome") String nome,
                             @Param("ordem") Integer ordem, @Param("familia") Integer familia, @Param("genero") Integer genero,
                             @Param("abdomen") Integer abdomen, @Param("antena") Integer antena, @Param("aparelho") Integer aparelho,
                             @Param("asas") Integer asas, @Param("pernas") Integer pernas, @Param("comportamento") Integer comportamento,
                                   @Param("metamorfose") Integer metamorfose, @Param("habitat") HabitatEnum habitat);
}
