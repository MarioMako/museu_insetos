package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DescricaoMorfologicaQuery extends JpaRepository<DescricaoMorfologica, Integer>{

    @Query("SELECT d FROM DescricaoMorfologica d JOIN d.abdomens ab JOIN d.antenas an JOIN d.aparelhoBucais ap JOIN d.asasList asa JOIN d.pernasList p WHERE " +
            " (ab.id = :abdomens OR :abdomens IS NULL) OR (an.id = :antenas OR :antenas IS NULL) OR (ap.id = :aparelhoBucais OR :aparelhoBucais IS NULL) " +
            "OR (asa.id = :asas OR :asas IS NULL) OR  (p.id = :pernas OR :pernas IS NULL)")
    List<DescricaoMorfologica> getFiltros(@Param("abdomens")Integer abdomens, @Param("antenas")Integer antenas, @Param("aparelhoBucais")Integer aparelhoBucais,
                                          @Param("asas")Integer asas, @Param("pernas")Integer pernas);
}
