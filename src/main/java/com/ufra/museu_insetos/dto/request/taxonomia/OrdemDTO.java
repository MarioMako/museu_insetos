package com.ufra.museu_insetos.dto.request.taxonomia;


import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class OrdemDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String nomeOrdem;

    @Valid
    @NotNull
    private ClassificacaoTaxonomicaEspecieDTO classificacaoTaxonomica;

    @Valid
    @NotNull
    private List<FamiliaDTO> familias;


    public OrdemDTO(Ordem ordem) {
        this.nomeOrdem = ordem.getNomeOrdem();
    }
}
