package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "GENERO"
)

@Getter
@Setter
public class Genero extends AbstractEntity {

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

    public Genero() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
