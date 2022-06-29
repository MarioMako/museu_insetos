package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologicaEspecie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DescricaoMorfologicaQuery extends JpaRepository<DescricaoMorfologicaEspecie, Integer>{

    @Query("SELECT d FROM DescricaoMorfologicaEspecie d JOIN d.abdomen ab JOIN d.antena an JOIN d.aparelho ap JOIN d.asas asa JOIN d.pernas p WHERE " +
            " (ab.id = :abdomen OR :abdomen IS NULL) OR (an.id = :antena OR :antena IS NULL) OR (ap.id = :aparelhoBucal OR :aparelhoBucal IS NULL) " +
            "OR (asa.id = :asas OR :asas IS NULL) OR  (p.id = :pernas OR :pernas IS NULL)")
    DescricaoMorfologicaEspecie getFiltros(@Param("abdomen")Integer abdomen, @Param("antena")Integer antena, @Param("aparelhoBucal")Integer aparelhoBucal,
                                           @Param("asas")Integer asas, @Param("pernas")Integer pernas);
}
