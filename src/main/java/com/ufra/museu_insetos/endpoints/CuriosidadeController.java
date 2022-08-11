package com.ufra.museu_insetos.endpoints;

import com.ufra.museu_insetos.dto.request.CuriosidadeDTO;
import com.ufra.museu_insetos.services.CuriosidadeService;
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
@RequestMapping(value ="api/curiosidade")
public class CuriosidadeController {

    @Autowired
    CuriosidadeService service;

    @GetMapping("curiosidade/getall")
    public ResponseEntity<List<CuriosidadeDTO>> getAll(){
        return new ResponseEntity<>(service.getAllCuriosidades(), HttpStatus.OK);
    }

    @GetMapping("curiosidade/getbyid/{id}")
    public ResponseEntity<CuriosidadeDTO> getById(@PathVariable Integer id){
        Optional<CuriosidadeDTO> curiosidade = Optional.ofNullable(service.obterCuriosidadePorId(id));
        if (curiosidade.isPresent()) {
            return new ResponseEntity<>(curiosidade.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "curiosidade/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CuriosidadeDTO> create(@RequestBody CuriosidadeDTO curiosidade){
        var res = service.salvarCuriosidade(curiosidade);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("curiosidade/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirCuriosidade(id);
    }

    @PutMapping("curiosidade/update")
    public ResponseEntity<CuriosidadeDTO> update(@Valid @RequestBody CuriosidadeDTO curiosidade) throws ConfigDataResourceNotFoundException {
        service.atualizarCuriosidade(curiosidade);
        return ResponseEntity.ok(curiosidade);
    }

    @GetMapping("curiosidade/pesquisa/{titulo}")
    public ResponseEntity<List<CuriosidadeDTO>> getPesquisa(@PathVariable String titulo){
        List<CuriosidadeDTO> curiosidade = service.pesquisaCuriosidade(titulo);
        if (curiosidade != null) {
            return new ResponseEntity<>(curiosidade, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

}
