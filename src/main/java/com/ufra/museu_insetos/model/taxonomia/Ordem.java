package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "ORDEM"
)

@Getter
@Setter
public class Ordem extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ORDEM"
    )
    private int id;

    @Column(
            name = "NOME"
    )
    private String nome;

    public Ordem() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}