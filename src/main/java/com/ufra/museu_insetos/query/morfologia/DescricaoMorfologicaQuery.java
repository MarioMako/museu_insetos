package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface DescricaoMorfologicaQuery extends JpaRepository<DescricaoMorfologica, Integer> {

    @Query("SELECT d FROM DescricaoMorfologica d WHERE :abdomen IS NULL OR d.abdomens.id = :abdomen AND " +
            " :antena IS NULL OR d.antenas.id = :antena AND " +
            " :aparelhoBucal IS NULL OR d.aparelhoBucais.id = :aparelhoBucal AND " +
            " :asas IS NULL OR d.asasList.id = :asas AND " +
            " :pernas IS NULL OR d.pernasList.id = :pernas")
    List<DescricaoMorfologica> getFiltros(@Param("abdomen")Integer abdomen,@Param("antena")Integer antenas,@Param("aparelhoBucal")Integer aparelhoBucal,
                                          @Param("asas")Integer asas,@Param("pernas")Integer pernas);
}
