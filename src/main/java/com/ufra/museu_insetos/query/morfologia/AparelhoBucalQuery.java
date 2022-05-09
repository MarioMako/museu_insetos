package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AparelhoBucalQuery extends JpaRepository<AparelhoBucal, Integer> {

    @Query("SELECT a FROM AparelhoBucal a WHERE a.descricaoMorfologica.id = :aparelhoBucal")
    List<AparelhoBucal> getAparelhoBucalByDescricaoMorfologicaId(@Param("aparelhoBucal")Integer aparelhoBucal);
}
