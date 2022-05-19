package com.ufra.museu_insetos.services;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.query.EspecieQuery;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Service
public class EspecieService {

    @Autowired
    private EspecieQuery especieQuery;

    public Especie salvarEspecie(Especie especie) {
        return especieQuery.save(especie);
    }

    public List<EspecieDTO> getAllEspecies(@RequestParam(required = false) Integer nome) {
        List<EspecieDTO> especies = new ArrayList<EspecieDTO>();
        especieQuery.findAllByNomes(nome).forEach(e -> especies.add(new EspecieDTO(e)));
        return especies;
    }


}
