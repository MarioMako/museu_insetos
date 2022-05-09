package com.ufra.museu_insetos.query.morfologia;

import com.ufra.museu_insetos.model.morfologia.Abdomen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface AbdomenQuery extends JpaRepository<Abdomen,Integer> {

    @Query ("SELECT a FROM Abdomen a WHERE a.descricaoMorfologica.id = :abdomen")
    List<Abdomen> getAbdomenByDescricaoMorfologicaId(@Param("abdomen")Integer abdomen);
}
