package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "CLASSIFICACAO_TAXONOMICA"
)

@Getter
@Setter
public class ClassificacaoTaxonomica extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_CLASSIFICACAO_TAXONOMICA"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    public ClassificacaoTaxonomica() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}