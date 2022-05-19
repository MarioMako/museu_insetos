package com.ufra.museu_insetos.query.ecologia;

import com.ufra.museu_insetos.model.ecologica.Comportamento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComportamentoQuery extends CrudRepository<Comportamento, Integer> {

}
