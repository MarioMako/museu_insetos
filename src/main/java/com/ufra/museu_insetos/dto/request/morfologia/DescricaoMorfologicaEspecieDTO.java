package com.ufra.museu_insetos.dto.request.morfologia;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologicaEspecie;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
public class DescricaoMorfologicaEspecieDTO {

    @NotNull
    private Integer id;

    @Valid
    @NotNull
    private AntenaDTO antena;

    @Valid
    @NotNull
    private AsasDTO asas;

    @Valid
    @NotNull
    private AbdomenDTO abdomen;

    @Valid
    @NotNull
    private AparelhoBucalDTO aparelhoBucal;

    @Valid
    @NotNull
    private PernasDTO pernas;

    public DescricaoMorfologicaEspecieDTO(DescricaoMorfologicaEspecie descricaoMorfologicaEspecie){

    }
}
