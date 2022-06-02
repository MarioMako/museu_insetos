package com.ufra.museu_insetos.services.biologica;

import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.query.biologica.MetamorfoseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MetamorfoseService {

    @Autowired
    private MetamorfoseQuery metamorfoseQuery;

    public Metamorfose salvarMetamorfose(Metamorfose metamorfose){return metamorfoseQuery.save(metamorfose);}

    public MetamorforseDTO obterMetamorfosePorId(Integer id){
        var res= metamorfoseQuery.findById(id).orElseThrow(() -> new NotFoundException("Metamorfose não encontrada".replace("id",id.toString())));
        return new MetamorforseDTO(res);
    }

    public void excluirMetamorfose(Integer id){
        Metamorfose metamorfose = metamorfoseQuery.findById(id).orElseThrow(() -> new NotFoundException("Metamorfose não encontrada".replace("id",id.toString())));
        metamorfoseQuery.delete(metamorfose);
    }

    public List<MetamorforseDTO> getAllMetamorfoses(){
        List<MetamorforseDTO> metamorfoses = new ArrayList<MetamorforseDTO>();
        metamorfoses = StreamSupport.stream(metamorfoseQuery.findAll().spliterator(),false).map(MetamorforseDTO::new).collect(Collectors.toList());
        return metamorfoses;
    }

    public Metamorfose atualizarMetamorfose(Metamorfose metamorfose, Integer id){
        obterMetamorfosePorId(id);
        metamorfose.setId(id);
        return metamorfoseQuery.save(metamorfose);
    }
}
