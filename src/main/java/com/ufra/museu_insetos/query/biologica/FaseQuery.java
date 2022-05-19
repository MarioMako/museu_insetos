package com.ufra.museu_insetos.query.biologica;

import com.ufra.museu_insetos.model.biologica.Fase;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FaseQuery extends CrudRepository<Fase,Integer> {

    @Query("SELECT f FROM Fase f WHERE f.metamorfose.id = :metamorfose")
    List<Fase> findFaseByMetamorfoseId(@Param("metamorfose")Integer metamorfose);
}
