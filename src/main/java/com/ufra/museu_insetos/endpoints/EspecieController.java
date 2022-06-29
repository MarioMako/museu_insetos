package com.ufra.museu_insetos.endpoints;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.services.EspecieService;
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
@RequestMapping(value ="api/especie")
public class EspecieController {

    @Autowired
    EspecieService service;

    @GetMapping("especie/getall")
    public ResponseEntity<List<EspecieDTO>> getAll(){
        return new ResponseEntity<>(service.getAllEspecies(),HttpStatus.OK);
    }

    @GetMapping("especie/getbyid/{id}")
    public ResponseEntity<EspecieDTO> getById(@PathVariable Integer id){
        Optional<EspecieDTO> especie = Optional.ofNullable(service.obterEspeciePorId(id));
        if (especie.isPresent()) {
            return new ResponseEntity<>(especie.get(), HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }
    }

    @PostMapping(path = "especie/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EspecieDTO> create(@RequestBody EspecieDTO especie){
        var res = service.salvarEspecie(especie);
        if (res == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        } else {
            return new ResponseEntity<>(res, HttpStatus.CREATED);
        }
    }

    @DeleteMapping("especie/delete/{id}")
    public void delete(@PathVariable(value = "id") Integer id){
        service.excluirEspecie(id);
    }

    @PutMapping("especie/update")
    public ResponseEntity<EspecieDTO> update(@Valid @RequestBody EspecieDTO especie) throws ConfigDataResourceNotFoundException {
        service.atualizarEspecie(especie);
        return ResponseEntity.ok(especie);
    }

    @GetMapping("especie/pesquisa/{nome}")
    public ResponseEntity<List<EspecieDTO>> getPesquisa(@RequestBody EspecieDTO especie){
        List<EspecieDTO> especies = service.pesquisaEspecie(especie.getNomeVulgar(),especie.getClassificacaoTaxonomica().getOrdem().getId(),
                                                            especie.getClassificacaoTaxonomica().getFamilia().getId(),
                                                            especie.getClassificacaoTaxonomica().getGenero().getId(),
                                                            especie.getDescricaoMorfologica().getAbdomen().getId(),
                                                            especie.getDescricaoMorfologica().getAntena().getId(),
                                                            especie.getDescricaoMorfologica().getAparelhoBucal().getId(),
                                                            especie.getDescricaoMorfologica().getAsas().getId(),
                                                            especie.getDescricaoMorfologica().getPernas().getId(),
                                                            especie.getComportamento().getId(), especie.getMetamorfose().getId(), especie.getHabitat());
        if (especies != null) {
            return new ResponseEntity<>(especies, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,("Item necessitado não preenchido"));
        }

    }
}
