package com.ufra.museu_insetos.services.biologica;

import com.ufra.museu_insetos.dto.request.biologica.FaseDTO;
import com.ufra.museu_insetos.model.biologica.Fase;
import com.ufra.museu_insetos.query.biologica.FaseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FaseService {

    @Autowired
    private FaseQuery faseQuery;

    public Fase salvarFase(Fase fase){return faseQuery.save(fase);}

    public FaseDTO obterFasePorId(Integer id){
        var res= faseQuery.findById(id).orElseThrow(() -> new NotFoundException("Fase não encontrada.".replace("id",id.toString())));
        return new FaseDTO(res);
    }

    public void excluirFase(Integer id){
        Fase fase = faseQuery.findById(id).orElseThrow(() -> new NotFoundException("Fase não encontrada.".replace("id",id.toString())));
        faseQuery.delete(fase);
    }

    public Fase atualizarFase(Fase fase, Integer id){
        obterFasePorId(id);
        fase.setId(id);
        return faseQuery.save(fase);
    }

    public List<FaseDTO> getFaseByMetamorfose(@RequestParam(required = false) Integer nome){
        List<FaseDTO> fases = new ArrayList<FaseDTO>();
        faseQuery.findFaseByMetamorfoseId(nome).forEach(e-> fases.add(new FaseDTO(e)));
        return fases;
    }

}
