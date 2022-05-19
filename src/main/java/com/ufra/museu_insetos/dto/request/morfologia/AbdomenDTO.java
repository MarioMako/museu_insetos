package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.model.morfologia.Abdomen;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
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
public class AbdomenDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoAbdomen;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

    public AbdomenDTO(Abdomen abdomen) {
        this.tipoAbdomen = abdomen.getTipoAbdomen();
    }
}
