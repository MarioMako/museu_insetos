package com.ufra.museu_insetos.endpoints.morfologia;

import com.ufra.museu_insetos.dto.request.morfologia.AbdomenDTO;
import com.ufra.museu_insetos.services.morfologia.AbdomenService;
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
@RequestMapping("/api/abdomen")
public class AbdomenController {

    @Autowired
    AbdomenService service;

    @GetMapping("abdomen")
    public ResponseEntity<List<AbdomenDTO>> getAll(){
        return new ResponseEntity<>(service.getAllAbdomens(), HttpStatus.OK);
    }

    @GetMapping("abdomen/{id}")
    public ResponseEntity<AbdomenDTO> getById(@PathVariable Integer id){
        Optional<AbdomenDTO> abdomen = Optional.ofNullable(service.obterAbdomenPorId(id));
        if (abdomen.isPresent()) {
            return new ResponseEntity<>(abdomen.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "abdomen", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AbdomenDTO> create(@RequestBody AbdomenDTO abdomen){
        var res = service.salvarAbdomen(abdomen);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("abdomen/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirAbdomen(id);
    }

    @PutMapping("abdomen")
    public ResponseEntity<AbdomenDTO> update(@Valid @RequestBody AbdomenDTO abdomen) throws ConfigDataResourceNotFoundException {
        service.atualizarAbdomen(abdomen);
        return ResponseEntity.ok(abdomen);
    }

}
