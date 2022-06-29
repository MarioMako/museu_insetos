package com.ufra.museu_insetos.dto.request.taxonomia;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class GeneroDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String nomeGenero;

    @Valid
    @NotNull
    private FamiliaDTO familia;

    @Valid
    @NotNull
    private ClassificacaoTaxonomicaEspecieDTO classificacaoTaxonomica;

    public GeneroDTO(Genero genero) {
        this.nomeGenero = genero.getNomeGenero();
    }
}
