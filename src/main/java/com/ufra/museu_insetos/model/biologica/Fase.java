package com.ufra.museu_insetos.model.biologica;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.biologica.Metamorfose;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
@Entity
@Table(
        name = "FASE"
)

@Getter
@Setter
public class Fase extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_FASE"
    )
    private int id;

    @Column(
            name = "DESCRICAO"
    )
    private String descricao;

    @Column(
            name = "TEMPO"
    )
    private String tempo;

    @ManyToOne
    @JoinColumn(name="ID_METAMORFOSE",nullable = false)
    private Metamorfose metamorfose_id;

    public Fase() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}