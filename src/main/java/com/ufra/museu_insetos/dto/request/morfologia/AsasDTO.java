package com.ufra.museu_insetos.dto.request.morfologia;

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
public class AsasDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoAsas;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

}
