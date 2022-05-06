package com.ufra.museu_insetos.model.ecologica;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "HABITAT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Habitat implements Serializable {

    private static final long serialVersionUID = -1093577302803184665L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_HABITAT")
    private int id;

    @Column(name = "TIPO_HABITAT")
    private String tipoHabitat;

    @ManyToMany
    @JoinTable(name = "especie_has_habitat", joinColumns = @JoinColumn(name = "habitat_id"),
            inverseJoinColumns = @JoinColumn(name = "especie_id"))
    Set<Especie> habitatEspecie;


}
