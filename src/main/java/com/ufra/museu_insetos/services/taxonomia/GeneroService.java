package com.ufra.museu_insetos.services.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.GeneroDTO;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import com.ufra.museu_insetos.query.taxonomia.GeneroQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class GeneroService {

    @Autowired
    private GeneroQuery generoQuery;

    public Genero salvarGenero(Genero genero){return generoQuery.save(genero);}

    public GeneroDTO obterGeneroPorId(Integer id){
        var res = generoQuery.findById(id).orElseThrow(() -> new NotFoundException("Genero não encontrado.".replace("id",id.toString())));
        return new GeneroDTO(res);
    }

    public void excluirGenero(Integer id){
        Genero genero = generoQuery.findById(id).orElseThrow(() -> new NotFoundException("Genero não encontrado.".replace("id",id.toString())));
        generoQuery.delete(genero);
    }

    public GeneroDTO atualizarGenero(Genero genero, Integer id){
        obterGeneroPorId(id);
        genero.setId(id);
        var res= generoQuery.save(genero);
        return new GeneroDTO(res);
    }

    public List<GeneroDTO> getAllGeneros(){
        List<GeneroDTO> generos = new ArrayList<GeneroDTO>();
        generos = StreamSupport.stream(generoQuery.findAll().spliterator(),false).map(GeneroDTO::new).collect(Collectors.toList());
        return generos;
    }

    public List<GeneroDTO> getGeneroByFamilia(@RequestParam(required = false) Integer nome){
        List<GeneroDTO> generos = new ArrayList<GeneroDTO>();
        generoQuery.findGeneroByFamilia(nome).forEach(e -> generos.add(new GeneroDTO(e)));
        return generos;
    }

}
