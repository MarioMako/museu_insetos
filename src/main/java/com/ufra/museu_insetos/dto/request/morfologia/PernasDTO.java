package com.ufra.museu_insetos.dto.request.morfologia;


import com.ufra.museu_insetos.model.morfologia.Pernas;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class PernasDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String tipoPernas;

    @Valid
    @NotNull
    private DescricaoMorfologicaEspecieDTO descricaoMorfologica;


    public PernasDTO(Pernas pernas) {
        this.tipoPernas = pernas.getTipoPernas();
    }
}
