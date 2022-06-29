package com.ufra.museu_insetos.dto.request;

import com.ufra.museu_insetos.model.Curiosidade;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CuriosidadeDTO {

    @NotNull
    private Integer id;

    @Valid
    @NotBlank
    private String titulo;

    @Valid
    @NotBlank
    private Long descricao;

    public CuriosidadeDTO(Curiosidade curiosidade) {
        this.titulo = curiosidade.getTitulo();
        this.descricao = curiosidade.getDescricao();
    }

}
