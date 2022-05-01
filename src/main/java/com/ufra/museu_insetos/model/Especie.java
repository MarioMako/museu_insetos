package com.ufra.museu_insetos.model;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import com.ufra.museu_insetos.model.ecologica.Comportamento;
import com.ufra.museu_insetos.model.ecologica.Habitat;
import com.ufra.museu_insetos.model.morfologia.DescricaoMorfologica;
import com.ufra.museu_insetos.model.taxonomia.Familia;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import com.ufra.museu_insetos.model.taxonomia.Ordem;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "ESPECIE"
)

@Getter
@Setter
public class Especie extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ESPECIE"
    )
    private int id;

    @Column(
            name = "NOME_CIENTIFICO"
    )
    private String nome_cientifico;

    @Column(
            name = "NOME_VULGAR"
    )
    private String nome_vulgar;

    @Column(
            name = "DESCRICAO_LIVRE"
    )
    private Long descricao_livre;

    @Column(
            name = "URL_IMAGEM"
    )
    private Long url_imagem;

    @ManyToMany
    @JoinTable(
            name = "especie_has_habitat",
            joinColumns = @JoinColumn(name = "especie_id"),
            inverseJoinColumns =  @JoinColumn(name = "habitat_id"))
    Set<Habitat> especieHabitat;

    @ManyToOne
    @JoinColumn(name="ID_FAMILIA",nullable = false)
    private Familia familia_id;

    @ManyToOne
    @JoinColumn(name="ID_ORDEM",nullable = false)
    private Ordem ordem_id;

    @ManyToOne
    @JoinColumn(name="ID_GENERO",nullable = false)
    private Genero genero_id;

    @ManyToOne
    @JoinColumn(name="ID_COMPORTAMENTO",nullable = false)
    private Comportamento comportamento_id;

    @ManyToOne
    @JoinColumn(name="ID_METAMORFOSE",nullable = false)
    private Metamorfose metamorfose_id;

    @ManyToOne
    @JoinColumn(name="ID_DESCRICAO_MORFOLOGICA",nullable = false)
    private DescricaoMorfologica descricaoMorfologica_id;

    public Especie() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
