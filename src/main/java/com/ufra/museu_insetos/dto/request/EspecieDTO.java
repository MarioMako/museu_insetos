package com.ufra.museu_insetos.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.dto.request.ecologica.ComportamentoDTO;
import com.ufra.museu_insetos.dto.request.morfologia.DescricaoMorfologicaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.ClassificacaoTaxonomicaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.FamiliaDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.OrdemDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomica;
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
    private Long descricaoLivre;

    @NotBlank
    @Size(min = 2)
    private Long urlImagem;

    @Valid
    @NotNull
    private HabitatEnum habitat;

    @Valid
    @NotNull
    private ComportamentoDTO comportamento;

    @Valid
    @NotNull
    private MetamorforseDTO metamorfose;

    @Valid
    @NotNull
    private DescricaoMorfologicaDTO descricaoMorfologica;

    @Valid
    @NotNull
    private ClassificacaoTaxonomicaDTO classificacaoTaxonomica;

    public EspecieDTO(Especie e){
        this.nomeCientifico = e.getNomeCientifico();
        this.nomeVulgar = e.getNomeVulgar();
        this.descricaoLivre = e.getDescricaoLivre();
        this.urlImagem = e.getUrlImagem();
        this.habitat = e.getHabitat();
        this.comportamento = new ComportamentoDTO(e.getComportamento());
        this.metamorfose = new MetamorforseDTO(e.getMetamorfose());
        this.descricaoMorfologica = new DescricaoMorfologicaDTO(e.getDescricaoMorfologica());
        this.classificacaoTaxonomica = new ClassificacaoTaxonomicaDTO(e.getClassificacaoTaxonomica());
    }
}
