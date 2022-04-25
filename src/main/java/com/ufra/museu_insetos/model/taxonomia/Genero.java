package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
            name = "ID_GENERO"
    )
    private int id;

    @Column(
            name = "NOME"
    )
    private String nome;

    @ManyToOne
    @JoinColumn(name="ID_FAMILIA",nullable = false)
    private Familia familia_id;

    @OneToMany(mappedBy="genero", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public Genero() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
