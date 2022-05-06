package com.ufra.museu_insetos.dto.request.usuario;

import com.ufra.museu_insetos.model.usuario.Acesso;
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
public class UsuarioDTO {

    @NotBlank
    @Size(min = 3, max = 20)
    private String nome;

    @NotNull
    private String cpf;

    @NotBlank
    private String login;

    @Valid
    @NotNull
    private List<Acesso> acessos;

}
