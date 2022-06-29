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

    @Query("SELECT e from Especie e " + "JOIN e.nomeVulgar nv JOIN e.nomeCientifico nc " +
            "JOIN e.classificacaoTaxonomica.ordem.id o JOIN e.classificacaoTaxonomica.familia.id f JOIN e.classificacaoTaxonomica.genero.id g" +
            " JOIN e.descricaoMorfologica.abdomen.id ab JOIN e.descricaoMorfologica.antena.id ant JOIN e.descricaoMorfologica.aparelho.id ap JOIN e.descricaoMorfologica.asas.id asa" +
            " JOIN e.descricaoMorfologica.pernas.id p JOIN e.comportamento.id comp JOIN e.metamorfose.id meta JOIN e.habitat h WHERE " +
            "(nv LIKE %:nome% OR :nv IS NULL) OR (nc LIKE %:nome% OR nc IS NULL) OR" +
            "(o = :ordem OR :ordem IS NULL) OR (f = :familia OR :familia IS NULL) OR (g = :genero OR :genero IS NULL) OR " +
            "(ab = :abdomen OR :abdomen IS NULL) OR (ant = :antena OR :antena IS NULL) OR (ap = :aparelho OR :aparelho IS NULL) OR " +
            "(asa = :asas OR :asas IS NULL) OR (p = :pernas OR :pernas IS NULL) OR (comp = :comportamento OR :comportamento IS NULL) OR " +
            "(meta = :metamorfose OR :metamorfose IS NULL) OR (h = :habitat OR :habitat IS NULL)")
    List<Especie> findAllByFiltros(@Param("nome") String nome,
                             @Param("ordem") Integer ordem, @Param("familia") Integer familia, @Param("genero") Integer genero,
                             @Param("abdomen") Integer abdomen, @Param("antena") Integer antena, @Param("aparelho") Integer aparelho,
                             @Param("asas") Integer asas, @Param("pernas") Integer pernas, @Param("comportamento") Integer comportamento,
                                   @Param("metamorfose") Integer metamorfose, @Param("habitat") HabitatEnum habitat);
}
