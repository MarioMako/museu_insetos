package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AparelhoBucalDTO;
import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import com.ufra.museu_insetos.query.morfologia.AparelhoBucalQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AparelhoBucalService {

    @Autowired
    private AparelhoBucalQuery aparelhoBucalQuery;

    public AparelhoBucalDTO salvarAparelhoBucal(AparelhoBucalDTO aparelhoBucaldto){
        AparelhoBucal aparelhoBucal = new AparelhoBucal();
        aparelhoBucal.setTipoAparalhoBucal(aparelhoBucaldto.getTipoAparalhoBucal());
        var res = aparelhoBucalQuery.save(aparelhoBucal);
        return new AparelhoBucalDTO(res);
    }

    public AparelhoBucalDTO obterAparelhoPorId(Integer id){
        var res= aparelhoBucalQuery.findById(id).orElseThrow(() -> new NotFoundException("Aparelho Bucal não encontrado.".replace("id",id.toString())));
        return new AparelhoBucalDTO(res);
    }

    public void excluirAparelhoBucal(Integer id){
        AparelhoBucal aparelhoBucal = aparelhoBucalQuery.findById(id).orElseThrow(() -> new NotFoundException("Aparelho Bucal não encontrado.".replace("id",id.toString())));
        aparelhoBucalQuery.delete(aparelhoBucal);
    }

    public List<AparelhoBucalDTO> getAllAparelhos(){
        List<AparelhoBucalDTO> aparelhos = new ArrayList<AparelhoBucalDTO>();
        aparelhos = StreamSupport.stream(aparelhoBucalQuery.findAll().spliterator(),false).map(AparelhoBucalDTO::new).collect(Collectors.toList());
        return aparelhos;
    }

    public AparelhoBucal atualizarAparelho(AparelhoBucalDTO aparelhoBucaldto){
        AparelhoBucal aparelhoBucal = aparelhoBucalQuery.findById(aparelhoBucaldto.getId()).orElseThrow();
        aparelhoBucal.setTipoAparalhoBucal(aparelhoBucaldto.getTipoAparalhoBucal());
        return aparelhoBucalQuery.save(aparelhoBucal);
    }
}
