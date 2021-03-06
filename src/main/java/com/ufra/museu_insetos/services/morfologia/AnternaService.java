package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AntenaDTO;
import com.ufra.museu_insetos.model.morfologia.Antena;
import com.ufra.museu_insetos.model.morfologia.Antena;
import com.ufra.museu_insetos.query.morfologia.AntenaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnternaService {

    @Autowired
    private AntenaQuery antenaQuery;

    public AntenaDTO salvarAntena(AntenaDTO antenadto){
        Antena antena = new Antena();
        antena.setTipoAntena(antenadto.getTipoAntena());
        var res = antenaQuery.save(antena);
        return new AntenaDTO(res);
    }

    public AntenaDTO obterAntenaPorId(Integer id){
        var res = antenaQuery.findById(id).orElseThrow(() -> new NotFoundException("Antena não encontrada.".replace("id",id.toString())));
        return new AntenaDTO(res);
    }

    public void excluirAntena(Integer id){
        Antena antena = antenaQuery.findById(id).orElseThrow(() -> new NotFoundException("Antena não encontrada.".replace("id",id.toString())));
        antenaQuery.delete(antena);
    }

    public List<AntenaDTO> getAllAntenas(){
        List<AntenaDTO> antenas = new ArrayList<AntenaDTO>();
        antenas = StreamSupport.stream(antenaQuery.findAll().spliterator(),false).map(AntenaDTO::new).collect(Collectors.toList());
        return antenas;
    }

    public Antena atualizarAntena(AntenaDTO antenadto){
        Antena antena = antenaQuery.findById(antenadto.getId()).orElseThrow();
        antena.setTipoAntena(antenadto.getTipoAntena());
        return antenaQuery.save(antena);
    }
}
