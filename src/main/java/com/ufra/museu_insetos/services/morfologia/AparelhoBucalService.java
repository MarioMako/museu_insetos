package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AparelhoBucalDTO;
import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import com.ufra.museu_insetos.query.morfologia.AparelhoBucalQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class AparelhoBucalService {

    @Autowired
    private AparelhoBucalQuery aparelhoBucalQuery;

    public AparelhoBucal salvarAparelhoBucal(AparelhoBucal aparelhoBucal){return aparelhoBucalQuery.save(aparelhoBucal);}

    public AparelhoBucalDTO obterAparelhoPorId(Integer id){
        var res= aparelhoBucalQuery.findById(id).orElseThrow(() -> new NotFoundException("Aparelho Bucal não encontrado.".replace("id",id.toString())));
        return new AparelhoBucalDTO(res);
    }

    public void excluirAparelhoBucal(Integer id){
        AparelhoBucal aparelhoBucal = aparelhoBucalQuery.findById(id).orElseThrow(() -> new NotFoundException("Aparelho Bucal não encontrado.".replace("id",id.toString())));
        aparelhoBucalQuery.delete(aparelhoBucal);
    }

    public AparelhoBucalDTO atualizarAparelho(AparelhoBucal aparelhoBucal, Integer id){
        obterAparelhoPorId(id);
        aparelhoBucal.setId(id);
        var res = aparelhoBucalQuery.save(aparelhoBucal);
        return new AparelhoBucalDTO(res);
    }
}
