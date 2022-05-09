package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.Familia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FamiliaQuery extends JpaRepository<Familia, Integer> {

    @Query("SELECT f FROM Familia f WHERE f.ordem.id = :ordem")
    List<Familia> getFamiliaByOrdemId(@Param("ordem")Integer ordem);
}
