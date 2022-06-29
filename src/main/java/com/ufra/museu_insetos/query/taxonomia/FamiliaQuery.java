package com.ufra.museu_insetos.query.taxonomia;

import com.ufra.museu_insetos.model.taxonomia.Familia;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FamiliaQuery extends CrudRepository<Familia, Integer> {

    @Query("SELECT f FROM Familia f WHERE f.ordem.id = :ordem")
    List<Familia> findFamiliaByOrdem(@Param("ordem")Integer ordem);
}
