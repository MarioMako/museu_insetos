package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AparelhoBucalQuery extends CrudRepository<AparelhoBucal, Integer> {

}
