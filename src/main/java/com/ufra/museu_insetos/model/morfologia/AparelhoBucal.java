package com.ufra.museu_insetos.model.morfologia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "APARELHO_BUCAL"
)

@Getter
@Setter
public class AparelhoBucal extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_APARELHO_BUCAL"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    public AparelhoBucal() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
