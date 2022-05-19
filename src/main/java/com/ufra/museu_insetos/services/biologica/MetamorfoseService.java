package com.ufra.museu_insetos.services.biologica;

import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.query.biologica.MetamorfoseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

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

    public Metamorfose atualizarMetamorfose(Metamorfose metamorfose, Integer id){
        obterMetamorfosePorId(id);
        metamorfose.setId(id);
        return metamorfoseQuery.save(metamorfose);
    }
}
