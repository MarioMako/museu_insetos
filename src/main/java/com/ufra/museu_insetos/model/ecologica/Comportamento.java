package com.ufra.museu_insetos.model.ecologica;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    @OneToMany(mappedBy="comportamento", fetch = FetchType.LAZY)
    private List<Especie> especies;

    public Comportamento() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
