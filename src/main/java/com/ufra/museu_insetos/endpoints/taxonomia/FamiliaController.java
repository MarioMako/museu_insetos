package com.ufra.museu_insetos.endpoints.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.services.taxonomia.FamiliaService;
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
@RequestMapping(value ="api/familia")
public class FamiliaController {

    @Autowired
    FamiliaService service;

    @GetMapping("familia/getall")
    public ResponseEntity<List<FamiliaDTO>> getAll(){
        return new ResponseEntity<>(service.getAllFamilias(), HttpStatus.OK);
    }

    @GetMapping("familia/getbyid/{id}")
    public ResponseEntity<FamiliaDTO> getById(@PathVariable Integer id){
        Optional<FamiliaDTO> familia = Optional.ofNullable(service.obterFamiliaPorId(id));
        if (familia.isPresent()) {
            return new ResponseEntity<>(familia.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "familia/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FamiliaDTO> create(@RequestBody FamiliaDTO familia){
        var res = service.salvarFamilia(familia);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("familia/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirFamilia(id);
    }

    @PutMapping("familia/update")
    public ResponseEntity<FamiliaDTO> update(@Valid @RequestBody FamiliaDTO familia) throws ConfigDataResourceNotFoundException {
        service.atualizarFamilia(familia);
        return ResponseEntity.ok(familia);
    }

    @GetMapping("familia/filtro/{id}")
    public ResponseEntity<List<FamiliaDTO>> getFiltro(@PathVariable Integer id){
        List<FamiliaDTO> familia = service.getFamiliasByOrdem(id);
        if (familia != null) {
            return new ResponseEntity<>(familia, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }
}
