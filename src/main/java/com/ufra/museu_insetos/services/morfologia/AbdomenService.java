package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AbdomenDTO;
import com.ufra.museu_insetos.model.morfologia.Abdomen;
import com.ufra.museu_insetos.query.morfologia.AbdomenQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AbdomenService {

    @Autowired
    private AbdomenQuery abdomenQuery;

    public Abdomen salvarAbdomen(Abdomen abdomen){return abdomenQuery.save(abdomen);}

    public AbdomenDTO obterAbdomenPorId(Integer id){
        var res= abdomenQuery.findById(id).orElseThrow(() -> new NotFoundException("Abdomen não encontrado.".replace("id",id.toString())));
        return new AbdomenDTO(res);
    }

    public void excluirAbdomen(Integer id){
        Abdomen abdomen = abdomenQuery.findById(id).orElseThrow(() -> new NotFoundException("Abdomen não encontrado.".replace("id",id.toString())));
        abdomenQuery.delete(abdomen);
    }

    public List<AbdomenDTO> getAllAbdomens(){
        List<AbdomenDTO> abdomens = new ArrayList<AbdomenDTO>();
        abdomens = StreamSupport.stream(abdomenQuery.findAll().spliterator(),false).map(AbdomenDTO::new).collect(Collectors.toList());
        return abdomens;
    }

    public AbdomenDTO atualizarAbdomen(Abdomen abdomen, Integer id){
        obterAbdomenPorId(id);
        abdomen.setId(id);
        var res = abdomenQuery.save(abdomen);
        return new AbdomenDTO(res);
    }
}
