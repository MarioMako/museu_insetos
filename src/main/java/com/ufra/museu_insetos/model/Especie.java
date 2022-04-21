package com.ufra.museu_insetos.model;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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

    public Especie() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
