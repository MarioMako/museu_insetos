package com.ufra.museu_insetos.model.ecologica;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "COMPORTAMENTO"
)

@Getter
@Setter
public class Comportamento extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_COMPORTAMENTO"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    public Comportamento() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
