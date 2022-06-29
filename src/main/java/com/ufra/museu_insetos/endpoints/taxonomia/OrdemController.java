package com.ufra.museu_insetos.endpoints.taxonomia;

import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.services.taxonomia.OrdemService;
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
@RequestMapping("api/ordem")
public class OrdemController {

    @Autowired
    OrdemService service;

    @GetMapping("ordem")
    public ResponseEntity<List<OrdemDTO>> getAll(){
        return new ResponseEntity<>(service.getAllOrdens(), HttpStatus.OK);
    }

    @GetMapping("ordem/{id}")
    public ResponseEntity<OrdemDTO> getById(@PathVariable Integer id){
        Optional<OrdemDTO> ordem = Optional.ofNullable(service.obterOrdemPorId(id));
        if (ordem.isPresent()) {
            return new ResponseEntity<>(ordem.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "ordem", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrdemDTO> create(@RequestBody OrdemDTO ordem){
        var res = service.salvarOrdem(ordem);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("ordem/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirOrdem(id);
    }

    @PutMapping("ordem")
    public ResponseEntity<OrdemDTO> update(@Valid @RequestBody OrdemDTO ordem) throws ConfigDataResourceNotFoundException {
        service.atualizarOrdem(ordem);
        return ResponseEntity.ok(ordem);
    }
}
