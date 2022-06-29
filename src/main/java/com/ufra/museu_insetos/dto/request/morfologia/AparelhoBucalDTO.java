package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AparelhoBucalDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String tipoAparalhoBucal;

    @Valid
    @NotNull
    private DescricaoMorfologicaEspecieDTO descricaoMorfologica;

    public AparelhoBucalDTO(AparelhoBucal aparelhoBucal) {
        this.tipoAparalhoBucal = aparelhoBucal.getTipoAparalhoBucal();
    }

}
