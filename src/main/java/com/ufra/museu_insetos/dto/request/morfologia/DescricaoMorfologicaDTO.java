package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class DescricaoMorfologicaDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoDescricaoMorfologicaa;

    @Valid
    @NotNull
    private List<AntenaDTO> antenas;

    @Valid
    @NotNull
    private List<AsasDTO> asasList;

    @Valid
    @NotNull
    private List<AbdomenDTO> abdomens;

    @Valid
    @NotNull
    private List<AparelhoBucalDTO> aparelhoBucais;

    @Valid
    @NotNull
    private List<PernasDTO> pernasList;

    @Valid
    @NotNull
    private List<EspecieDTO> especies;

    public DescricaoMorfologicaDTO(DescricaoMorfologica descricaoMorfologica) {
    }
}
