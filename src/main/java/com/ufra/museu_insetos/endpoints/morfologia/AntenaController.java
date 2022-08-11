package com.ufra.museu_insetos.endpoints.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AntenaDTO;
import com.ufra.museu_insetos.services.morfologia.AnternaService;
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
@RequestMapping(value ="api/antena")
public class AntenaController {

    @Autowired
    AnternaService service;

    @GetMapping("antena/getall")
    public ResponseEntity<List<AntenaDTO>> getAll(){
        return new ResponseEntity<>(service.getAllAntenas(), HttpStatus.OK);
    }

    @GetMapping("antena/getbyid/{id}")
    public ResponseEntity<AntenaDTO> getById(@PathVariable Integer id){
        Optional<AntenaDTO> antena = Optional.ofNullable(service.obterAntenaPorId(id));
        if (antena.isPresent()) {
            return new ResponseEntity<>(antena.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "antena/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AntenaDTO> create(@RequestBody AntenaDTO antena){
        var res = service.salvarAntena(antena);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("antena/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirAntena(id);
    }

    @PutMapping("antena/update")
    public ResponseEntity<AntenaDTO> update(@Valid @RequestBody AntenaDTO antena) throws ConfigDataResourceNotFoundException {
        service.atualizarAntena(antena);
        return ResponseEntity.ok(antena);
    }
}
