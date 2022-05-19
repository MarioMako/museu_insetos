package com.ufra.museu_insetos.services.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import com.ufra.museu_insetos.query.taxonomia.OrdemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;

@Service
public class OrdemService {

    @Autowired
    private OrdemQuery ordemQuery;

    private Ordem salvarOrdem(Ordem ordem){return ordemQuery.save(ordem);}

    public OrdemDTO obterOrdemPorId(Integer id){
       var res = ordemQuery.findById(id).orElseThrow(() -> new NotFoundException("Ordem não encontrada.".replace("id",id.toString())));
       return new OrdemDTO(res);
    }

    public void excluirOrdem(Integer id){
        Ordem ordem = ordemQuery.findById(id).orElseThrow(() -> new NotFoundException("Ordem não encontrada.".replace("id",id.toString())));
        ordemQuery.delete(ordem);
    }

    public OrdemDTO atualizarOrdem(Ordem ordem, Integer id){
        obterOrdemPorId(id);
        ordem.setId(id);
        var res = ordemQuery.save(ordem);
        return new OrdemDTO(res);
    }
}
