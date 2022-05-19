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

    @Query("SELECT e FROM Especie e WHERE e.nomeCientifico LIKE %:nome% " +
            " OR e.nomeVulgar LIKE %:nome% OR :nome IS NULL")
    List<Especie> findAllByNomes(@Param("nome")Integer nome);

    @Query("SELECT e FROM Especie e WHERE e.habitat = :habitat")
    List<Especie> findAllByHabitat(@Param("habitat")Enum<HabitatEnum> habitat);

    @Query("SELECT e FROM Especie e WHERE e.comportamento.id = :comportamento")
    List<Especie> findAllByComportamento(@Param("comportamento")Integer comportamento);
    @Query ("SELECT e FROM Especie e WHERE e.classificacaoTaxonomica.id = :classificacaoTaxonomica")
    List<Especie> findAllByClassificacaoTaxonomicaId(@Param("classificacaoTaxonomica")Integer classificacaoTaxonomica);
    @Query ("SELECT e FROM Especie e WHERE e.metamorfose.id = :metamorfose")
    List<Especie> findAllByMetamorfoseId(@Param("metamorfose")Integer metamorfose);
    @Query ("SELECT e FROM Especie e WHERE e.descricaoMorfologica.id = :descricaoMorfologica")
    List<Especie> findAllByDescricaoMorfologicaId(@Param("descricaoMorfologica")Integer descricaoMorfologica);
}
