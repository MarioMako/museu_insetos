package com.ufra.museu_insetos.query.biologica;

import com.ufra.museu_insetos.model.biologica.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FaseQuery extends JpaRepository<Fase,Integer> {

    @Query("SELECT f FROM Fase f WHERE f.metamorfose.id = :metamorfose")
    List<Fase> getFaseByMetamorfoseId(@Param("metamorfose")Integer metamorfose);
}
