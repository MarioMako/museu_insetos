package com.ufra.museu_insetos.model;


import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologicaEspecie;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomica;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomicaEspecie;
import com.ufra.museu_insetos.services.morfologia.DescricaoMorfologicaService;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ESPECIE")
@Getter
@Setter
@ToString
public class Especie implements Serializable {


    private static final long serialVersionUID = -5324260941044333990L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ESPECIE")
    private Integer id;

    @Column(name = "NOME_CIENTIFICO", nullable = false, unique = true)
    private String nomeCientifico;

    @Column(name = "NOME_VULGAR", nullable = false)
    private String nomeVulgar;

    @Column(name = "DESCRICAO_LIVRE", nullable = false)
    private String descricaoLivre;

    @Column(name = "URL_IMAGEM", nullable = false)
    private String urlImagem;

    @Enumerated(EnumType.ORDINAL)
    private HabitatEnum habitat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPORTAMENTO", nullable = false)
    private Comportamento comportamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLASSIFICACAO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomicaEspecie classificacaoTaxonomica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_METAMORFOSE", nullable = false)
    private Metamorfose metamorfose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologicaEspecie descricaoMorfologica;



}
