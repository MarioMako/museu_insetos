package com.ufra.museu_insetos.model.biologica;

import com.ufra.museu_insetos.model.Especie;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "METAMORFOSE")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Metamorfose implements Serializable {

    private static final long serialVersionUID = -9029098455045980874L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_METAMORFOSE")
    private int id;

    @Column(name = "TIPO_METAMORFOSE", nullable = false)
    private String tipoMetamorfose;

    @OneToMany(mappedBy = "metamorfose", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Fase> fases;

    @OneToMany(mappedBy = "metamorfose", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Especie> especies;


}
