package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.model.morfologia.AparelhoBucal;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AparelhoBucalDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoAparalhoBucal;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

    public AparelhoBucalDTO(AparelhoBucal aparelhoBucal) {
        this.tipoAparalhoBucal = aparelhoBucal.getTipoAparalhoBucal();
    }

}
