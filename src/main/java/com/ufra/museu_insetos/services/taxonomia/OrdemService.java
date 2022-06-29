package com.ufra.museu_insetos.services.taxonomia;
import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import com.ufra.museu_insetos.query.taxonomia.OrdemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OrdemService {

    @Autowired
    private OrdemQuery ordemQuery;

    public OrdemDTO salvarOrdem(OrdemDTO ordemdto){
        Ordem ordem = new Ordem();
        ordem.setNomeOrdem(ordemdto.getNomeOrdem());
        var res = ordemQuery.save(ordem);
        return new OrdemDTO(res);
    }

    public OrdemDTO obterOrdemPorId(Integer id){
       var res = ordemQuery.findById(id).orElseThrow(() -> new NotFoundException("Ordem não encontrada.".replace("id",id.toString())));
       return new OrdemDTO(res);
    }

    public void excluirOrdem(Integer id){
        Ordem ordem = ordemQuery.findById(id).orElseThrow(() -> new NotFoundException("Ordem não encontrada.".replace("id",id.toString())));
        ordemQuery.delete(ordem);
    }

    public Ordem atualizarOrdem(OrdemDTO ordemdto){
        Ordem ordem = ordemQuery.findById(ordemdto.getId()).orElseThrow();
        ordem.setNomeOrdem(ordemdto.getNomeOrdem());
        return ordemQuery.save(ordem);
    }

    public List<OrdemDTO> getAllOrdens(){
        List<OrdemDTO> ordens = new ArrayList<OrdemDTO>();
        ordens = StreamSupport.stream(ordemQuery.findAll().spliterator(),false).map(OrdemDTO::new).collect(Collectors.toList());
        return ordens;
    }
}
