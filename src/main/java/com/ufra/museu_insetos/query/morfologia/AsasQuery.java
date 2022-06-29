package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.Asas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AsasQuery extends CrudRepository<Asas,Integer> {

}
