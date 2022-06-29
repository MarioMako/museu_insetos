package com.ufra.museu_insetos.model;


import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.model.ecologica.HabitatEnum;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologicaEspecie;
import com.ufra.museu_insetos.model.taxonomia.ClassificacaoTaxonomicaEspecie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

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
    private byte[] urlImagem;

    @Enumerated(EnumType.ORDINAL)
    private HabitatEnum habitat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_COMPORTAMENTO", nullable = false)
    private Comportamento comportamento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_CLASSIFICACAO_TAXONOMICA_ESPECIE", nullable = false)
    private ClassificacaoTaxonomicaEspecie classificacaoTaxonomicaEspecie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_METAMORFOSE", nullable = false)
    private Metamorfose metamorfose;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_DESCRICAO_MORFOLOGICA_ESPECIE", nullable = false)
    private DescricaoMorfologicaEspecie descricaoMorfologicaEspecie;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especie especie = (Especie) o;
        return Objects.equals(id, especie.id) && Objects.equals(nomeCientifico, especie.nomeCientifico) && Objects.equals(nomeVulgar, especie.nomeVulgar) && Objects.equals(descricaoLivre, especie.descricaoLivre) && Arrays.equals(urlImagem, especie.urlImagem) && habitat == especie.habitat && Objects.equals(comportamento, especie.comportamento) && Objects.equals(classificacaoTaxonomicaEspecie, especie.classificacaoTaxonomicaEspecie) && Objects.equals(metamorfose, especie.metamorfose) && Objects.equals(descricaoMorfologicaEspecie, especie.descricaoMorfologicaEspecie);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(id, nomeCientifico, nomeVulgar, descricaoLivre, habitat, comportamento, classificacaoTaxonomicaEspecie, metamorfose, descricaoMorfologicaEspecie);
        result = 31 * result + Arrays.hashCode(urlImagem);
        return result;
    }
}
