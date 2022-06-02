package com.ufra.museu_insetos.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.dto.request.ecologica.ComportamentoDTO;
import com.ufra.museu_insetos.dto.request.morfologia.DescricaoMorfologicaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.ClassificacaoTaxonomicaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
public class EspecieDTO {

    @NotBlank
    @Size(min = 2, max = 25)
    private String nomeCientifico;

    @NotBlank
    @Size(min = 2, max = 25)
    private String nomeVulgar;

    @NotBlank
    @Size(min = 2)
    private String descricaoLivre;

    @NotBlank
    private String urlImagem;

    @Valid
    @NotNull
    private HabitatEnum habitat;

    @Valid
    @NotNull
    private ComportamentoDTO comportamento;

    @Valid
    @NotNull
    private FamiliaDTO familia;

    @Valid
    @NotNull
    private OrdemDTO ordem;

    @Valid
    @NotNull
    private MetamorforseDTO metamorfose;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

    @Valid
    @NotNull
    private ClassificacaoTaxonomicaDTO classificacaoTaxonomica;

    public EspecieDTO(Especie e) {
        this.nomeVulgar = e.getNomeVulgar();
        this.nomeCientifico = e.getNomeCientifico();
        this.habitat = e.getHabitat();
        this.urlImagem = e.getUrlImagem();
    }
}
