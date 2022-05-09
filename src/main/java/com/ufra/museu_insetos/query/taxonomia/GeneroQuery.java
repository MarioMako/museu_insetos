package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface GeneroQuery extends JpaRepository<Genero, Integer> {

    @Query("SELECT g FROM Genero g WHERE g.familia.id = :familia")
    List<Genero> getGeneroByFamiliaId(@Param("familia")Integer familia);
}
