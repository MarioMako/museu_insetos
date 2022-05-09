package com.ufra.museu_insetos.query;

import com.ufra.museu_insetos.model.Especie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface EspecieQuery extends JpaRepository<Especie,Integer> {

    @Query("SELECT e FROM Especie e WHERE e.nomeCientifico LIKE :nomeCientifico%")
    List<Especie> findAllByNomeCientificoStartsWith(@Param("nomeCientifico")String nomeCientifico);
    @Query("SELECT e FROM Especie e WHERE e.nomeCientifico LIKE %:nomeCientifico")
    List<Especie> findAllByNomeCientificoEndsWith(@Param("nomeCientifico")String nomeCientifico);
    @Query("SELECT e FROM Especie e WHERE e.nomeCientifico LIKE %:nomeCientifico%")
    List<Especie> findAllByNomeCientificoContains(@Param("nomeCientifico")String nomeCientifico);

    @Query("SELECT e FROM Especie e WHERE e.nomeVulgar LIKE :nomeVulgar%")
    List<Especie> findAllByNomeVulgarStartsWith(@Param("nomeVulgar")String nomeVulgar);
    @Query("SELECT e FROM Especie e WHERE e.nomeVulgar LIKE %:nomeVulgar")
    List<Especie> findAllByNomeVulgarEndsWith(@Param("nomeVulgar")String nomeVulgar);
    @Query("SELECT e FROM Especie e WHERE e.nomeVulgar LIKE %:nomeVulgar%")
    List<Especie> findAllByNomeVulgarContains(@Param("nomeVulgar")String nomeVulgar);

    @Query ("SELECT e FROM Especie e WHERE e.classificacaoTaxonomica.id = :classificacaoTaxonomica")
    List<Especie> findAllByClassificacaoTaxonomicaId(@Param("classificacaoTaxonomica")Integer classificacaoTaxonomica);
    @Query ("SELECT e FROM  Especie e WHERE e.comportamento.id = :comportamento")
    List<Especie> findAllByComportamentoId(@Param("comportamento")Integer comportamento);
    @Query ("SELECT e FROM Especie e WHERE e.metamorfose.id = :metamorfose")
    List<Especie> findAllByMetamorfoseId(@Param("metamorfose")Integer metamorfose);
    @Query ("SELECT e FROM Especie e WHERE e.especieHabitat.id = :especieHabitat")
    List<Especie> findAllByEspecieHabitatId(@Param("especieHabitat")Integer especieHabitat);
    @Query ("SELECT e FROM Especie e WHERE e.descricaoMorfologica.id = :descricaoMorfologica")
    List<Especie> findAllByDescricaoMorfologicaId(@Param("descricaoMorfologica")Integer descricaoMorfologica);
}
