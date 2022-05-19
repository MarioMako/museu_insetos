package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.model.morfologia.Antena;
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
public class AntenaDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoAntena;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

    public AntenaDTO(Antena antena) {
        this.tipoAntena = antena.getTipoAntena();
    }
}
