package com.ufra.museu_insetos.model.biologica;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import com.ufra.museu_insetos.model.taxonomia.Genero;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(
        name = "METAMORFOSE"
)

@Getter
@Setter
public class Metamorfose extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_METAMORFOSE"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    @OneToMany(mappedBy="metamorfose", fetch = FetchType.LAZY)
    private List<Fase> fases;

    @OneToMany(mappedBy="metamorfose", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public Metamorfose() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
