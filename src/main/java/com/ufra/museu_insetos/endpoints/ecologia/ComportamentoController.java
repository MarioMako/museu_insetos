package com.ufra.museu_insetos.endpoints.ecologia;

import com.ufra.museu_insetos.dto.request.ecologica.ComportamentoDTO;
import com.ufra.museu_insetos.services.ecologica.ComportamentoService;
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
@RequestMapping("api/comportamento")
public class ComportamentoController {

    @Autowired
    ComportamentoService service;

    @GetMapping("comportamento")
    public ResponseEntity<List<ComportamentoDTO>> getAll(){
        return new ResponseEntity<>(service.getAllComportamentos(), HttpStatus.OK);
    }

    @GetMapping("comportamento/{id}")
    public ResponseEntity<ComportamentoDTO> getById(@PathVariable Integer id){
        Optional<ComportamentoDTO> comportamento = Optional.ofNullable(service.obterComportamentoPorId(id));
        if (comportamento.isPresent()) {
            return new ResponseEntity<>(comportamento.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "Comportamento", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ComportamentoDTO> create(@RequestBody ComportamentoDTO comportamento){
        var res = service.salvarComportamento(comportamento);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("Comportamento/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirComportamento(id);
    }

    @PutMapping("Comportamento")
    public ResponseEntity<ComportamentoDTO> update(@Valid @RequestBody ComportamentoDTO Comportamento) throws ConfigDataResourceNotFoundException {
        service.atualizarComportamento(Comportamento);
        return ResponseEntity.ok(Comportamento);
    }
}
