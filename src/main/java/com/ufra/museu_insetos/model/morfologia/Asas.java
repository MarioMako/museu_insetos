package com.ufra.museu_insetos.model.morfologia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "ASAS"
)

@Getter
@Setter
public class Asas extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ASAS"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    public Asas() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
