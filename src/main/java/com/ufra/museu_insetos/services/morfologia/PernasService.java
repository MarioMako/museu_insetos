package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.PernasDTO;
import com.ufra.museu_insetos.model.morfologia.Pernas;
import com.ufra.museu_insetos.model.morfologia.Pernas;
import com.ufra.museu_insetos.query.morfologia.PernasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PernasService {

    @Autowired
    private PernasQuery pernasQuery;

    public PernasDTO salvarPernas(PernasDTO pernasdto){
        Pernas pernas = new Pernas();
        pernas.setTipoPernas(pernasdto.getTipoPernas());
        var res = pernasQuery.save(pernas);
        return new PernasDTO(res);
    }

    public PernasDTO obterPernasPorId(Integer id){
        var res= pernasQuery.findById(id).orElseThrow(() -> new NotFoundException("Pernas não encontradas.".replace("id",id.toString())));
        return new PernasDTO(res);
    }

    public void excluirPernas(Integer id){
        Pernas pernas = pernasQuery.findById(id).orElseThrow(() -> new NotFoundException("Pernas não encontradas.".replace("id",id.toString())));
        pernasQuery.delete(pernas);
    }

    public List<PernasDTO> getAllPernas(){
        List<PernasDTO> pernas = new ArrayList<PernasDTO>();
        pernas = StreamSupport.stream(pernasQuery.findAll().spliterator(),false).map(PernasDTO::new).collect(Collectors.toList());
        return pernas;
    }

    public Pernas atualizarPernas(PernasDTO pernasdto){
        Pernas pernas = pernasQuery.findById(pernasdto.getId()).orElseThrow();
        pernas.setTipoPernas(pernasdto.getTipoPernas());
        return pernasQuery.save(pernas);
    }
}
