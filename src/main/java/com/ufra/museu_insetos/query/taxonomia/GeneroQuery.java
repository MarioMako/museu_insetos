package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.Genero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneroQuery extends CrudRepository<Genero, Integer> {

    @Query("SELECT g FROM Genero g WHERE g.familia.id = :familia")
    List<Genero> findGeneroByFamilia(@Param("familia")Integer familia);
}
