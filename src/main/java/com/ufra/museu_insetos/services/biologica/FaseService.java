package com.ufra.museu_insetos.services.biologica;

import com.ufra.museu_insetos.dto.request.biologica.FaseDTO;
import com.ufra.museu_insetos.model.biologica.Fase;
import com.ufra.museu_insetos.model.morfologia.Abdomen;
import com.ufra.museu_insetos.query.biologica.FaseQuery;
import com.ufra.museu_insetos.query.biologica.MetamorfoseQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FaseService {

    @Autowired
    private FaseQuery faseQuery;
    @Autowired
    private MetamorfoseQuery metamorfoseQuery;

    public FaseDTO salvarFase(FaseDTO fasedto){
        Fase fase = new Fase();
        fase.setDescricaoFase(fasedto.getDescricaoFase());
        fase.setTempoFase(fasedto.getTempoFase());
        fase.setMetamorfose(metamorfoseQuery.findById(fasedto.getMetamorfose().getId()).orElseThrow());
        var res = faseQuery.save(fase);
        return new FaseDTO(res);
    }

    public FaseDTO obterFasePorId(Integer id){
        var res= faseQuery.findById(id).orElseThrow(() -> new NotFoundException("Fase não encontrada.".replace("id",id.toString())));
        return new FaseDTO(res);
    }

    public void excluirFase(Integer id){
        Fase fase = faseQuery.findById(id).orElseThrow(() -> new NotFoundException("Fase não encontrada.".replace("id",id.toString())));
        faseQuery.delete(fase);
    }

    public Fase atualizarFase(FaseDTO fasedto){
        Fase fase = faseQuery.findById(fasedto.getId()).orElseThrow();
        fase.setDescricaoFase(fasedto.getDescricaoFase());
        fase.setTempoFase(fasedto.getTempoFase());
        return faseQuery.save(fase);
    }

    public List<FaseDTO> getAllFases(){
        List<FaseDTO> fases = new ArrayList<FaseDTO>();
        fases = StreamSupport.stream(faseQuery.findAll().spliterator(),false).map(FaseDTO::new).collect(Collectors.toList());
        return fases;
    }

    public List<FaseDTO> getFaseByMetamorfose(@RequestParam(required = false) Integer nome){
        List<FaseDTO> fases = new ArrayList<FaseDTO>();
        faseQuery.findFaseByMetamorfoseId(nome).forEach(e-> fases.add(new FaseDTO(e)));
        return fases;
    }

}
