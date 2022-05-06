package com.ufra.museu_insetos.model.ecologica;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "COMPORTAMENTO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Comportamento implements Serializable {

    private static final long serialVersionUID = -1832909764807384010L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPORTAMENTO")
    private int id;

    @Column(name = "TIPO_COMPORTAMENTO", nullable = false)
    private String tipoComportamento;

    @OneToMany(mappedBy = "comportamento", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;


}
