package com.ufra.museu_insetos.model.ecologica;

import br.com.wpe.api.persistence.bean.AbstractEntity;
import com.ufra.museu_insetos.model.Especie;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(
        name = "HABITAT"
)

@Getter
@Setter
public class Habitat extends AbstractEntity {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(
            name = "ID_HABITAT"
    )
    private int id;

    @Column(
            name = "TIPO"
    )
    private String tipo;

    @ManyToMany
    @JoinTable(
       name = "especie_has_habitat",
       joinColumns = @JoinColumn(name = "habitat_id"),
       inverseJoinColumns =  @JoinColumn(name = "especie_id"))
    Set<Especie> habitatEspecie;

    public Habitat() {
    }

    public Object getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
