package com.ufra.museu_insetos.dto.request.usuario;

import com.ufra.museu_insetos.model.usuario.Usuario;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AcessoDTO {

    @NotBlank
    private String dataHora;

    @NotBlank
    private String ip;

    @Valid
    @NotNull
    private Usuario usuario;


}
