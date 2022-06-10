package com.ufra.museu_insetos.dto.request;

import com.ufra.museu_insetos.model.Curiosidade;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class CuriosidadeDTO {

    @Valid
    @NotNull
    private String titulo;

    @Valid
    @NotNull
    private Long descricao;

    public CuriosidadeDTO(Curiosidade curiosidade) {
        this.titulo = curiosidade.getTitulo();
        this.descricao = curiosidade.getDescricao();
    }

}
