package com.ufra.museu_insetos.endpoints.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.GeneroDTO;
import com.ufra.museu_insetos.services.taxonomia.GeneroService;
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
@RequestMapping(value ="api/genero")
public class GeneroController {

    @Autowired
    GeneroService service;

    @GetMapping("genero/getall")
    public ResponseEntity<List<GeneroDTO>> getAll(){
        return new ResponseEntity<>(service.getAllGeneros(), HttpStatus.OK);
    }

    @GetMapping("genero/getbyid/{id}")
    public ResponseEntity<GeneroDTO> getById(@PathVariable Integer id){
        Optional<GeneroDTO> genero = Optional.ofNullable(service.obterGeneroPorId(id));
        if (genero.isPresent()) {
            return new ResponseEntity<>(genero.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "genero/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GeneroDTO> create(@RequestBody GeneroDTO genero){
        var res = service.salvarGenero(genero);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("genero/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirGenero(id);
    }

    @PutMapping("genero/update")
    public ResponseEntity<GeneroDTO> update(@Valid @RequestBody GeneroDTO genero) throws ConfigDataResourceNotFoundException {
        service.atualizarGenero(genero);
        return ResponseEntity.ok(genero);
    }

    @GetMapping("genero/filtro/{id}")
    public ResponseEntity<List<GeneroDTO>> getFiltro(@PathVariable Integer id){
        List<GeneroDTO> genero = service.getGeneroByFamilia(id);
        if (genero != null) {
            return new ResponseEntity<>(genero, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

}
