package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.model.morfologia.Asas;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class AsasDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoAsas;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;


    public AsasDTO(Asas asas) {
        this.tipoAsas = asas.getTipoAsas();
    }
}
