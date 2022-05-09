package com.ufra.museu_insetos.query.biologica;

import com.ufra.museu_insetos.model.biologica.Metamorfose;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MetamorfoseQuery extends JpaRepository<Metamorfose, Integer> {

    @Query("SELECT m FROM Metamorfose m WHERE :fases IS NULL OR m.fases = :fases")
    List<Metamorfose> getFasesByMetamorfose(@Param("fases")Integer fases);
}
