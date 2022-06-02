package com.ufra.museu_insetos.services.ecologica;

import com.ufra.museu_insetos.dto.request.ecologica.ComportamentoDTO;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.query.ecologia.ComportamentoQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ComportamentoService {

    @Autowired
    private ComportamentoQuery comportamentoQuery;

    private Comportamento salvarComportamento(Comportamento comportamento){return comportamentoQuery.save(comportamento);}

    public ComportamentoDTO obterComportamentoPorId(Integer id){
        var res= comportamentoQuery.findById(id).orElseThrow(() -> new NotFoundException("Comportamento não encontrado.".replace("id",id.toString())));
        return new ComportamentoDTO(res);
    }

    public void excluirComportamento(Integer id){
        Comportamento comportamento = comportamentoQuery.findById(id).orElseThrow(() -> new NotFoundException("Comportamento não encontrado.".replace("id",id.toString())));
        comportamentoQuery.delete(comportamento);
    }

    public List<ComportamentoDTO> getAllComportamentos(){
        List<ComportamentoDTO> comportamentos = new ArrayList<ComportamentoDTO>();
        comportamentos = StreamSupport.stream(comportamentoQuery.findAll().spliterator(),false).map(ComportamentoDTO::new).collect(Collectors.toList());
        return comportamentos;
    }

    public Comportamento atualizarComportamento(Comportamento comportamento, Integer id){
        obterComportamentoPorId(id);
        comportamento.setId(id);
        return comportamentoQuery.save(comportamento);
    }
}
