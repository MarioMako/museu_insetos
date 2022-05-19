package com.ufra.museu_insetos.services.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.model.taxonomia.Familia;
import com.ufra.museu_insetos.query.taxonomia.FamiliaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class FamiliaService {

    @Autowired
    private FamiliaQuery familiaQuery;

    public Familia salvarFamilia(Familia familia) { return familiaQuery.save(familia); }

    public FamiliaDTO obterFamiliaPorId(Integer id){
        var res= familiaQuery.findById(id).orElseThrow(() -> new NotFoundException("Familia não encontrada.".replace("id",id.toString())));
        return new FamiliaDTO(res);
    }

    public void excluirFamilia(Integer id){
        Familia familia = familiaQuery.findById(id).orElseThrow(() -> new NotFoundException("Familia não encontrada.".replace("id",id.toString())));
        familiaQuery.delete(familia);
    }

    public FamiliaDTO atualizarFamilia(Familia familia, Integer id){
        obterFamiliaPorId(id);
        familia.setId(id);
        var res = familiaQuery.save(familia);
        return new FamiliaDTO(res);
    }

    public List<FamiliaDTO> getFamiliasByOrdem(@RequestParam(required = false) Integer nome) {
        List<FamiliaDTO> familias = new ArrayList<FamiliaDTO>();
        familiaQuery.findFamiliaByOrdem(nome).forEach(e -> familias.add(new FamiliaDTO(e)));
        return familias;
    }
}
