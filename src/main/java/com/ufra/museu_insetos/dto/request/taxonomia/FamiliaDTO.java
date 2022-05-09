package com.ufra.museu_insetos.dto.request.taxonomia;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FamiliaDTO {

    @NotBlank
    @Size(min = 2)
    private String nomeFamilia;


    @Valid
    @NotNull
    private OrdemDTO ordem;

    @Valid
    @NotNull
    private List<GeneroDTO> generos;

    @Valid
    @NotNull
    private List<EspecieDTO> especies;


}