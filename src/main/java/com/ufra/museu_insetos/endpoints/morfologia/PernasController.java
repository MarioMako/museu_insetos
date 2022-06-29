package com.ufra.museu_insetos.endpoints.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.PernasDTO;
import com.ufra.museu_insetos.services.morfologia.PernasService;
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
@RequestMapping(value ="api/pernas")
public class PernasController {

    @Autowired
    PernasService service;

    @GetMapping("pernas/getall")
    public ResponseEntity<List<PernasDTO>> getAll(){
        return new ResponseEntity<>(service.getAllPernas(), HttpStatus.OK);
    }

    @GetMapping("pernas/getbyid/{id}")
    public ResponseEntity<PernasDTO> getById(@PathVariable Integer id){
        Optional<PernasDTO> pernas = Optional.ofNullable(service.obterPernasPorId(id));
        if (pernas.isPresent()) {
            return new ResponseEntity<>(pernas.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "pernas/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PernasDTO> create(@RequestBody PernasDTO pernas){
        var res = service.salvarPernas(pernas);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("pernas/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirPernas(id);
    }

    @PutMapping("pernas/update")
    public ResponseEntity<PernasDTO> update(@Valid @RequestBody PernasDTO pernas) throws ConfigDataResourceNotFoundException {
        service.atualizarPernas(pernas);
        return ResponseEntity.ok(pernas);
    }
}
