package com.ufra.museu_insetos.dto.request.taxonomia;

import com.ufra.museu_insetos.dto.request.morfologia.DescricaoMorfologicaEspecieDTO;
import com.ufra.museu_insetos.model.taxonomia.Familia;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
public class FamiliaDTO {

    @NotNull
    private Integer id;

    @NotBlank
    @Size(min = 2)
    private String nomeFamilia;

    @Valid
    @NotNull
    private OrdemDTO ordem;

    @Valid
    @NotNull
    private DescricaoMorfologicaEspecieDTO descricaoMorfologica;

    @Valid
    @NotNull
    private List<GeneroDTO> generos;

    public FamiliaDTO(Familia familia) {
        this.nomeFamilia = familia.getNomeFamilia();
    }
}
