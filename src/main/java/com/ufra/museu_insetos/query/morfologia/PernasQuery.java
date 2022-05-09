package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.Pernas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface PernasQuery extends JpaRepository<Pernas,Integer> {

    @Query("SELECT p FROM Pernas p WHERE p.descricaoMorfologica.id = :pernas")
    List<Pernas> getPernasByDescricaoMorfologicaId(@Param("pernas")Integer pernas);
}
