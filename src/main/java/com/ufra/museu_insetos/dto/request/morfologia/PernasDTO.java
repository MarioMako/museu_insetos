package com.ufra.museu_insetos.dto.request.morfologia;


import com.ufra.museu_insetos.model.morfologia.Pernas;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PernasDTO {


    @NotBlank
    @Size(min = 2)
    private String tipoPernas;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;


    public PernasDTO(Pernas pernas) {
        this.tipoPernas = pernas.getTipoPernas();
    }
}
