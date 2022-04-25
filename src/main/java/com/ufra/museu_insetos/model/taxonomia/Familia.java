package com.ufra.museu_insetos.model.taxonomia;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "FAMILIA"
)

@Getter
@Setter
public class Familia extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_FAMILIA"
    )
    private int id;

    @Column(
            name = "NOME"
    )
    private String nome;

    @ManyToOne
    @JoinColumn(name="ID_ORDEM",nullable = false)
    private Ordem ordem_id;

    @OneToMany(mappedBy="familia", fetch = FetchType.LAZY)
    private List<Genero> generos;

    @OneToMany(mappedBy="familia", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public Familia() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
