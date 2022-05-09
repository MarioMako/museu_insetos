package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.Asas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AsasQuery extends JpaRepository<Asas,Integer> {

    @Query("SELECT a FROM Asas a WHERE a.descricaoMorfologica.id = :asas")
    List<Asas> getAsasByDescricaoMorfologicaId(@Param("asas")Integer asas);
}
