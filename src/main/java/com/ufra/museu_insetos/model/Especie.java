package com.ufra.museu_insetos.model;


import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.model.ecologica.Habitat;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomica;
import com.ufra.museu_insetos.model.taxonomia.Familia;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "ESPECIE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    @ManyToMany
    @JoinTable(
            name = "especie_has_habitat",
            joinColumns = @JoinColumn(name = "especie_id"),
            inverseJoinColumns = @JoinColumn(name = "habitat_id"))
    Set<Habitat> especieHabitat;

    @ManyToOne
    @JoinColumn(name = "ID_FAMILIA", nullable = false)
    private Familia familia;

    @ManyToOne
    @JoinColumn(name = "ID_ORDEM", nullable = false)
    private Ordem ordem;

    @ManyToOne
    @JoinColumn(name = "ID_GENERO", nullable = false)
    private Genero genero;

    @ManyToOne
    @JoinColumn(name = "ID_COMPORTAMENTO", nullable = false)
    private Comportamento comportamento;

    @ManyToOne
    @JoinColumn(name = "ID_METAMORFOSE", nullable = false)
    private Metamorfose metamorfose;

    @ManyToOne
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA", nullable = false)
    private DescricaoMorfologica descricaoMorfologica;

    @ManyToOne
    @JoinColumn(name = "ID_CLASSIFICACAO_TAXONOMICA", nullable = false)
    private ClassificacaoTaxonomica classificacaoTaxonomica;


}
