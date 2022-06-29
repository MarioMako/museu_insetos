package com.ufra.museu_insetos.dto.request.ecologica;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class ComportamentoDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String tipoComportamento;

    @Valid
    @NotNull
    private List<EspecieDTO> especies;

    public ComportamentoDTO(Comportamento comportamento) {
        this.tipoComportamento = comportamento.getTipoComportamento();
    }
}
