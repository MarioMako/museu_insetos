package com.ufra.museu_insetos.dto.request.ecologica;

import com.ufra.museu_insetos.dto.request.EspecieDTO;
import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HabitatDTO {

    @NotBlank
    @Size(min = 2)
    private String tipoHabitat;

    @Valid
    @NotNull
    Set<EspecieDTO> habitatEspecie;


}
