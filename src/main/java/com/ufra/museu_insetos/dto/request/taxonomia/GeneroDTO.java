package com.ufra.museu_insetos.dto.request.taxonomia;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.taxonomia.Familia;
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
public class GeneroDTO {

    @NotBlank
    @Size(min = 5)
    private String nomeGenero;

    @Valid
    @NotNull
    private FamiliaDTO familia;

    @Valid
    @NotNull
    private List<EspecieDTO> especies;

}
