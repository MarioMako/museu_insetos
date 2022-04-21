package com.ufra.museu_insetos.model.morfologia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "DESCRICAO_MORFOLOGICA"
)

@Getter
@Setter
public class DescricaoMorfologica extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_TIPO"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    public DescricaoMorfologica() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
