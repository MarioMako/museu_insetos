package com.ufra.museu_insetos.model.morfologia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "ABDOMEN"
)

@Getter
@Setter
public class Abdomen extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_ANTENA"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    @ManyToOne
    @JoinColumn(name="ID_DESCRICAO_MORFOLOGICA",nullable = false)
    private DescricaoMorfologica descricaoMorfologica_id;

    public Abdomen() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
