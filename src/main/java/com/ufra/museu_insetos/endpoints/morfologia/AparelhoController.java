package com.ufra.museu_insetos.endpoints.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AparelhoBucalDTO;
import com.ufra.museu_insetos.services.morfologia.AparelhoBucalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("api/aparelho")
public class AparelhoController {

    @Autowired
    AparelhoBucalService service;

    @GetMapping("aparelhoBucal")
    public ResponseEntity<List<AparelhoBucalDTO>> getAll(){
        return new ResponseEntity<>(service.getAllAparelhos(), HttpStatus.OK);
    }

    @GetMapping("aparelhoBucal/{id}")
    public ResponseEntity<AparelhoBucalDTO> getById(@PathVariable Integer id){
        Optional<AparelhoBucalDTO> aparelhoBucal = Optional.ofNullable(service.obterAparelhoPorId(id));
        if (aparelhoBucal.isPresent()) {
            return new ResponseEntity<>(aparelhoBucal.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "aparelhoBucal", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AparelhoBucalDTO> create(@RequestBody AparelhoBucalDTO aparelhoBucal){
        var res = service.salvarAparelhoBucal(aparelhoBucal);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("aparelhoBucal/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirAparelhoBucal(id);
    }

    @PutMapping("aparelhoBucal")
    public ResponseEntity<AparelhoBucalDTO> update(@Valid @RequestBody AparelhoBucalDTO aparelhoBucal) throws ConfigDataResourceNotFoundException {
        service.atualizarAparelho(aparelhoBucal);
        return ResponseEntity.ok(aparelhoBucal);
    }

}
