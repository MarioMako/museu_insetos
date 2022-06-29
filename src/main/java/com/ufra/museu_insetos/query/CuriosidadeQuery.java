package com.ufra.museu_insetos.query;

import com.ufra.museu_insetos.model.Curiosidade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CuriosidadeQuery extends CrudRepository<Curiosidade, Integer> {

    @Query("SELECT c FROM Curiosidade c WHERE c.titulo LIKE %:titulo% OR :titulo IS NULL")
    List<Curiosidade> findAllbYTituloDesc(@Param("titulo")String titulo);
}
