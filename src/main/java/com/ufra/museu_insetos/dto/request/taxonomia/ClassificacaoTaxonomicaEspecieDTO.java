package com.ufra.museu_insetos.dto.request.taxonomia;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomicaEspecie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class ClassificacaoTaxonomicaEspecieDTO {

    @NotNull
    private Integer id;

    @Valid
    @NotNull
    private OrdemDTO ordem;

    @Valid
    @NotNull
    private FamiliaDTO familia;

    @Valid
    @NotNull
    private GeneroDTO genero;


    public ClassificacaoTaxonomicaEspecieDTO(ClassificacaoTaxonomicaEspecie classificacaoTaxonomicaEspecie){

    }
}
