package com.ufra.museu_insetos.services;

import com.ufra.museu_insetos.dto.request.CuriosidadeDTO;
import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.Curiosidade;
import com.ufra.museu_insetos.query.CuriosidadeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;


@Service
public class CuriosidadeService {

    @Autowired
    private CuriosidadeQuery curiosidadeQuery;

    public CuriosidadeDTO salvarCuriosidade(CuriosidadeDTO curiosidadedto){
        Curiosidade curiosidade = new Curiosidade();
        curiosidade.setTitulo(curiosidadedto.getTitulo());
        curiosidade.setDescricao(curiosidadedto.getDescricao());
        var res = curiosidadeQuery.save(curiosidade);
        return new CuriosidadeDTO(res);
    }

    public CuriosidadeDTO obterCuriosidadePorId(Integer id){
        var res= curiosidadeQuery.findById(id).orElseThrow(() -> new NotFoundException("Curiosidade não encontrada.".replace("id",id.toString())));
        return new CuriosidadeDTO(res);
    }

    public void excluirCuriosidade(Integer id){
        var res= curiosidadeQuery.findById(id).orElseThrow(() -> new NotFoundException("Curiosidade não encontrada.".replace("id",id.toString())));
        curiosidadeQuery.delete(res);
    }

    public List<CuriosidadeDTO> getAllCuriosidades(){
        List<CuriosidadeDTO> curiosidades = new ArrayList<CuriosidadeDTO>();
        curiosidades = StreamSupport.stream(curiosidadeQuery.findAll().spliterator(),false).map(CuriosidadeDTO::new).collect(Collectors.toList());
        return curiosidades;
    }

    public Curiosidade atualizarCuriosidade(CuriosidadeDTO curiosidadedto){
        Curiosidade curiosidade = curiosidadeQuery.findById(curiosidadedto.getId()).orElseThrow();
        curiosidade.setTitulo(curiosidadedto.getTitulo());
        curiosidade.setDescricao(curiosidadedto.getDescricao());
        return curiosidadeQuery.save(curiosidade);
    }

    public List<CuriosidadeDTO> pesquisaCuriosidade(String titulo) {
        var res = curiosidadeQuery.findAllbYTituloDesc(titulo);
        List<CuriosidadeDTO> dtos = new ArrayList<>();

        res.forEach(curiosidade -> {
            CuriosidadeDTO dto = new CuriosidadeDTO(curiosidade);
            dtos.add(dto);
        });
        return dtos;
    }


}
