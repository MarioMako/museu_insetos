package com.ufra.museu_insetos.endpoints.morfologia;


import com.ufra.museu_insetos.dto.request.morfologia.AsasDTO;
import com.ufra.museu_insetos.services.morfologia.AsasService;
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
@CrossOrigin("*")
@RequestMapping(value ="api/asas")
public class AsasController {

    @Autowired
    AsasService service;

    @GetMapping("asas/getall")
    public ResponseEntity<List<AsasDTO>> getAll(){
        return new ResponseEntity<>(service.getAllAsas(), HttpStatus.OK);
    }

    @GetMapping("asas/getbyid/{id}")
    public ResponseEntity<AsasDTO> getById(@PathVariable Integer id){
        Optional<AsasDTO> asas = Optional.ofNullable(service.obterAsasPorId(id));
        if (asas.isPresent()) {
            return new ResponseEntity<>(asas.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "asas/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AsasDTO> create(@RequestBody AsasDTO asas){
        var res = service.salvarAsas(asas);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("asas/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirAsas(id);
    }

    @PutMapping("asas/update")
    public ResponseEntity<AsasDTO> update(@Valid @RequestBody AsasDTO asas) throws ConfigDataResourceNotFoundException {
        service.atualizarAsas(asas);
        return ResponseEntity.ok(asas);
    }
}
