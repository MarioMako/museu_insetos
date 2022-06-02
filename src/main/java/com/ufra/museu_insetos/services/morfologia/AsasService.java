package com.ufra.museu_insetos.services.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AsasDTO;
import com.ufra.museu_insetos.model.morfologia.Asas;
import com.ufra.museu_insetos.query.morfologia.AsasQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AsasService {

    @Autowired
    private AsasQuery asasQuery;

    public Asas salvarAsas(Asas asas){return asasQuery.save(asas);}

    public AsasDTO obterAsasPorId(Integer id){
        var res= asasQuery.findById(id).orElseThrow(() -> new NotFoundException("Asas não encontradas.".replace("id",id.toString())));
        return new AsasDTO(res);
    }

    public void excluirAsas(Integer id){
        Asas asas = asasQuery.findById(id).orElseThrow(() -> new NotFoundException("Asas não encontradas.".replace("id",id.toString())));
        asasQuery.delete(asas);
    }

    public List<AsasDTO> getAllAsas(){
        List<AsasDTO> asas = new ArrayList<AsasDTO>();
        asas = StreamSupport.stream(asasQuery.findAll().spliterator(),false).map(AsasDTO::new).collect(Collectors.toList());
        return asas;
    }

    public AsasDTO atualizarAsas(Asas asas, Integer id){
        obterAsasPorId(id);
        asas.setId(id);
        var res= asasQuery.save(asas);
        return new AsasDTO(res);
    }
}
