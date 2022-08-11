package com.ufra.museu_insetos.endpoints.biologica;

import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.services.biologica.MetamorfoseService;
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
@RequestMapping(value ="/api/metamorfose")
public class MetamorfoseController {

    @Autowired
    MetamorfoseService service;

    @GetMapping("metamorfose/getall")
    public ResponseEntity<List<MetamorforseDTO>> getAll(){
        return new ResponseEntity<>(service.getAllMetamorfoses(), HttpStatus.OK);
    }

    @GetMapping("metamorfose/getbyid/{id}")
    public ResponseEntity<MetamorforseDTO> getById(@PathVariable Integer id){
        Optional<MetamorforseDTO> metamorfose = Optional.ofNullable(service.obterMetamorfosePorId(id));
        if (metamorfose.isPresent()) {
            return new ResponseEntity<>(metamorfose.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "metamorfose/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MetamorforseDTO> create(@RequestBody MetamorforseDTO metamorfose){
        var res = service.salvarMetamorfose(metamorfose);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("metamorfose/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirMetamorfose(id);
    }

    @PutMapping("metamorfose/update")
    public ResponseEntity<MetamorforseDTO> update(@Valid @RequestBody MetamorforseDTO metamorfose) throws ConfigDataResourceNotFoundException {
        service.atualizarMetamorfose(metamorfose);
        return ResponseEntity.ok(metamorfose);
    }

}
