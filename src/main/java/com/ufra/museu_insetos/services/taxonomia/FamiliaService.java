package com.ufra.museu_insetos.services.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.model.taxonomia.Familia;
import com.ufra.museu_insetos.query.taxonomia.FamiliaQuery;
import com.ufra.museu_insetos.query.taxonomia.OrdemQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FamiliaService {

    @Autowired
    private FamiliaQuery familiaQuery;
    @Autowired
    private OrdemQuery ordemQuery;

    public FamiliaDTO salvarFamilia(FamiliaDTO familiadto) {
        Familia familia = new Familia();
        familia.setNomeFamilia(familiadto.getNomeFamilia());
        familia.setOrdem(ordemQuery.findById(familiadto.getOrdem().getId()).orElseThrow());
        var res = familiaQuery.save(familia);
        return new FamiliaDTO(res);
    }

    public FamiliaDTO obterFamiliaPorId(Integer id){
        var res= familiaQuery.findById(id).orElseThrow(() -> new NotFoundException("Familia não encontrada.".replace("id",id.toString())));
        return new FamiliaDTO(res);
    }

    public void excluirFamilia(Integer id){
        Familia familia = familiaQuery.findById(id).orElseThrow(() -> new NotFoundException("Familia não encontrada.".replace("id",id.toString())));
        familiaQuery.delete(familia);
    }

    public Familia atualizarFamilia(FamiliaDTO familiadto){
        Familia familia = familiaQuery.findById(familiadto.getId()).orElseThrow();
        familia.setNomeFamilia(familiadto.getNomeFamilia());
        return familiaQuery.save(familia);
    }

    public List<FamiliaDTO> getAllFamilias(){
        List<FamiliaDTO> familias = new ArrayList<FamiliaDTO>();
        familias = StreamSupport.stream(familiaQuery.findAll().spliterator(),false).map(FamiliaDTO::new).collect(Collectors.toList());
        return familias;
    }

    public List<FamiliaDTO> getFamiliasByOrdem(@RequestParam(required = false) Integer nome) {
        List<FamiliaDTO> familias = new ArrayList<FamiliaDTO>();
        familiaQuery.findFamiliaByOrdem(nome).forEach(e -> familias.add(new FamiliaDTO(e)));
        return familias;
    }
}
