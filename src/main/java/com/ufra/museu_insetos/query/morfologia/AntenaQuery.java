package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.Antena;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AntenaQuery extends JpaRepository<Antena, Integer> {

    @Query("SELECT a FROM Antena a WHERE a.descricaoMorfologica.id = :antena")
    List<Antena> getAntenaByDescricaoMorfologicaId(@Param("antena")Integer antena);
}
