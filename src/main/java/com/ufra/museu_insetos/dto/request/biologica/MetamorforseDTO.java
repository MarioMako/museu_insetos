package com.ufra.museu_insetos.dto.request.biologica;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;


@Getter
@Setter
public class MetamorforseDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoMetamorfose;

    @Valid
    @NotNull
    private List<FaseDTO> fases;

    @Valid
    @NotNull
    private List<EspecieDTO> especies;


    public MetamorforseDTO(Metamorfose metamorfose) {
        this.tipoMetamorfose = metamorfose.getTipoMetamorfose();
    }
}
