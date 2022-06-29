package com.ufra.museu_insetos.dto.request;

import com.ufra.museu_insetos.dto.request.biologica.MetamorforseDTO;
import com.ufra.museu_insetos.dto.request.ecologica.ComportamentoDTO;
import com.ufra.museu_insetos.dto.request.morfologia.DescricaoMorfologicaEspecieDTO;
import com.ufra.museu_insetos.dto.request.taxonomia.ClassificacaoTaxonomicaEspecieDTO;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;

import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
public class EspecieDTO {

    @NotNull
    private Integer id;

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
    @Size(min = 2)
    private byte[] urlImagem;

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
    private DescricaoMorfologicaEspecieDTO descricaoMorfologica;

    @Valid
    @NotNull
    private ClassificacaoTaxonomicaEspecieDTO classificacaoTaxonomica;


    public EspecieDTO(Especie e){
        this.nomeCientifico = e.getNomeCientifico();
        this.nomeVulgar = e.getNomeVulgar();
        this.descricaoLivre = e.getDescricaoLivre();
        this.urlImagem = e.getUrlImagem();
        this.habitat = e.getHabitat();
        this.comportamento = new ComportamentoDTO(e.getComportamento());
        this.metamorfose = new MetamorforseDTO(e.getMetamorfose());
        this.descricaoMorfologica = new DescricaoMorfologicaEspecieDTO(e.getDescricaoMorfologicaEspecie());
        this.classificacaoTaxonomica = new ClassificacaoTaxonomicaEspecieDTO(e.getClassificacaoTaxonomicaEspecie());
    }
}
