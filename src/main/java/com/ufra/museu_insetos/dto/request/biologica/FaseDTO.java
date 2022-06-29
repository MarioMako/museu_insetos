package com.ufra.museu_insetos.dto.request.biologica;

import com.ufra.museu_insetos.model.biologica.Fase;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Getter
@Setter
public class FaseDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String descricaoFase;

    @NotBlank
    @Size(min = 2)
    private String tempoFase;

    @Valid
    @NotNull
    private MetamorforseDTO metamorfose;

    public FaseDTO(Fase fase) {
        this.descricaoFase = fase.getDescricaoFase();
        this.tempoFase = fase.getTempoFase();
    }
}
